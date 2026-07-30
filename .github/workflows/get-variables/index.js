const configPerBranch = {
    production: (runNumber) => {
        const LUX_DOMAIN = "lux.energy"
        const BACKEND_DOMAIN = `site-backend.${LUX_DOMAIN}`

        return {
            ENVIRONMENT: "production",
            TAG: `production-${runNumber}`,

            // backend settings
            BACKEND_DOMAIN,
            BACKEND_URL: `https://${BACKEND_DOMAIN}`,
            TRAEFIK_BACKEND_CERT: `*.${LUX_DOMAIN}`,
            CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",

            // settings for static site compilation
            ZENMO_DOMAIN: "nieuw.zenmo.com",
            LUX_DOMAIN,
            SUBDOMAIN_SEPARATOR: ".",

            // settings for Traefik
            TRAEFIK_ZENMO_MAIN_CERT: "*.zenmo.com",
            TRAEFIK_LUX_MAIN_CERT: LUX_DOMAIN,
            TRAEFIK_LUX_SANS_CERT: `*.${LUX_DOMAIN}`,
            TRAEFIK_LUX_HOST_REGEXP: "^[\\\\w-]+\\\\.lux\\\\.energy",
            // negative priority so other applications can route specific *.lux.energy subdomains
            // without explicitly setting priority
            TRAEFIK_PRIORITY: -2000,

            SSH_HOST: "prodpods.zenmo.com",
            SSH_HOST_ED25519_PUBLIC_KEY: "AAAAC3NzaC1lZDI1NTE5AAAAIB9QSQTFJtC1QzZ/iBdR6QfIQ8IFFw9ow14PN68fulC7",
        }
    },
    main: (runNumber) => {
        const LUX_DOMAIN = "test.lux.energy"
        const BACKEND_DOMAIN = `site-backend.${LUX_DOMAIN}`

        return {
            ENVIRONMENT: "test",
            TAG: `main-${runNumber}`,

            // backend settings
            BACKEND_DOMAIN,
            BACKEND_URL: `https://${BACKEND_DOMAIN}`,
            TRAEFIK_BACKEND_CERT: BACKEND_DOMAIN,
            CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",

            // settings for static site compilation
            ZENMO_DOMAIN: "test.zenmo.com",
            LUX_DOMAIN: LUX_DOMAIN,
            SUBDOMAIN_SEPARATOR: ".",

            // settings for Traefik
            TRAEFIK_ZENMO_MAIN_CERT: "*.zenmo.com",
            TRAEFIK_LUX_MAIN_CERT: LUX_DOMAIN,
            TRAEFIK_LUX_SANS_CERT: `*.${LUX_DOMAIN}`,
            TRAEFIK_LUX_HOST_REGEXP: "^[\\\\w-]+\\\\.test\\\\.lux\\\\.energy",
            // Higher priority for test because productions *.lux.energy shadows test.lux.energy
            TRAEFIK_PRIORITY: -1000,

            SSH_HOST: "testpods.zenmo.com",
            SSH_HOST_ED25519_PUBLIC_KEY: "AAAAC3NzaC1lZDI1NTE5AAAAIHdaAqGEO3FCNQf9o7ButP6fnnssixPOm24Z3OoLByoK",
        }
    },
    pull_request: (runNumber, prNumber) => {
        const compoundNumber = `${prNumber}-${runNumber}`

        const luxPrDomain = "pr.lux.energy"
        const zenmoPrdomain = "pr.zenmo.com"

        const LUX_DOMAIN = `${compoundNumber}.${luxPrDomain}`
        const BACKEND_DOMAIN = `site-backend-${compoundNumber}.${luxPrDomain}`

        return {
            ENVIRONMENT: `pr-${compoundNumber}`,
            TAG: `pr-${compoundNumber}`,

            // backend settings
            BACKEND_DOMAIN,
            BACKEND_URL: `https://${BACKEND_DOMAIN}`,
            TRAEFIK_BACKEND_CERT: `*.${luxPrDomain}`,
            CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",

            // settings for static site compilation
            ZENMO_DOMAIN: `${compoundNumber}.${zenmoPrdomain}`,
            LUX_DOMAIN,
            SUBDOMAIN_SEPARATOR: "-",

            // settings for Traefik
            TRAEFIK_ZENMO_MAIN_CERT: `*.${zenmoPrdomain}`,
            TRAEFIK_LUX_MAIN_CERT: `*.${luxPrDomain}`,
            TRAEFIK_LUX_SANS_CERT: "",
            TRAEFIK_LUX_HOST_REGEXP: `^[\\\\w-]+-${compoundNumber}\\\\.pr\\\\.lux\\\\.energy`,
            // Higher priority for pr because productions *.lux.energy shadows pr.lux.energy
            TRAEFIK_PRIORITY: -1000,

            SSH_HOST: "testpods.zenmo.com",
            SSH_HOST_ED25519_PUBLIC_KEY: "AAAAC3NzaC1lZDI1NTE5AAAAIHdaAqGEO3FCNQf9o7ButP6fnnssixPOm24Z3OoLByoK",
        }
    }
}

/**
 * Called by @actions/github-script to get the variables for the build.
 *
 * @param {import("@actions/github/lib/context").Context} context
 */
module.exports = (context) => {
    // const branch = context.payload.pull_request?.head?.ref ?? context.ref.match(/refs\/heads\/(.+)/)[1]
    let configKey = context.eventName === "pull_request" ? "pull_request" : context.ref.match(/refs\/heads\/(.+)/)[1]

    // temporary
    if (configKey === "deploy-pull-request") {
        configKey = "main"
    }

    if (!Object.keys(configPerBranch).includes(configKey)) {
        throw Error(`No config for branch ${configKey}`)
    }
    
    let configFactory = configPerBranch[configKey]

    return configFactory(context.runNumber, context.payload.pull_request?.number)
}
