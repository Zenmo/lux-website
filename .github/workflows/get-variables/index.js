const configPerBranch = {
    production: (runNumber) => ({
        BACKEND_DOMAIN: "site-backend.lux.energy",
        BACKEND_URL: "https://site-backend.lux.energy",
        CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",
        ENVIRONMENT: "production",
        LUX_DOMAIN: "lux.energy",
        LUX_HOST_REGEXP: "^[\\\\w-]+\\\\.lux\\\\.energy",
        // negative priority so other applications can route subdomains
        // without explicitly setting priority
        TRAEFIK_PRIORITY: -2000,
        ZENMO_DOMAIN: "nieuw.zenmo.com",
        SSH_HOST: "prodpods.zenmo.com",
        SSH_HOST_ED25519_PUBLIC_KEY: "AAAAC3NzaC1lZDI1NTE5AAAAIB9QSQTFJtC1QzZ/iBdR6QfIQ8IFFw9ow14PN68fulC7",
        TAG: `production-${runNumber}`
    }),
    main: (runNumber) => ({
        BACKEND_DOMAIN: "site-backend.test.lux.energy",
        BACKEND_URL: "https://site-backend.test.lux.energy",
        ENVIRONMENT: "test",
        CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",
        LUX_DOMAIN: "test.lux.energy",
        LUX_HOST_REGEXP: "^[\\\\w-]+\\\\.test\\\\.lux\\\\.energy",
        // Higher priority for test because productions *.lux.energy shadows test.lux.energy
        TRAEFIK_PRIORITY: -1000,
        ZENMO_DOMAIN: "test.zenmo.com",
        SSH_HOST: "testpods.zenmo.com",
        SSH_HOST_ED25519_PUBLIC_KEY: "AAAAC3NzaC1lZDI1NTE5AAAAIHdaAqGEO3FCNQf9o7ButP6fnnssixPOm24Z3OoLByoK",
        TAG: `main-${runNumber}`
    }),
    pull_request: (runNumber) => ({
        BACKEND_DOMAIN: `site-backend-${runNumber}.pr.lux.energy`,
        BACKEND_URL: `http://site-backend-${runNumber}.pr.lux.energy`,
        ENVIRONMENT: "pull_request",
        CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",
        LUX_DOMAIN: `${runNumber}.pr.lux.energy`,
        LUX_HOST_REGEXP: "^[\\\\w-]+\\\\.test\\\\.lux\\\\.energy",
        TRAEFIK_PRIORITY: -1500,
        ZENMO_DOMAIN: `pr-${runNumber}.zenmo.com`,
        SSH_HOST: "testpods.zenmo.com",
        SSH_HOST_ED25519_PUBLIC_KEY: "AAAAC3NzaC1lZDI1NTE5AAAAIHdaAqGEO3FCNQf9o7ButP6fnnssixPOm24Z3OoLByoK",
        TAG: `pr-${runNumber}`
    })
}

/**
 * Called by @actions/github-script to get the variables for the build.
 *
 * @param {import("@actions/github/lib/context").Context} context
 */
module.exports = (context) => {
    // const branch = context.payload.pull_request?.head?.ref ?? context.ref.match(/refs\/heads\/(.+)/)[1]
    let configKey = context.eventName === "pull_request" ? "pull_request" : context.ref.match(/refs\/heads\/(.+)/)[1]

    if (configKey === "move-server") {
        configKey = "main"
    }

    if (!Object.keys(configPerBranch).includes(configKey)) {
        throw Error(`No config for branch ${configKey}`)
    }
    
    let configFactory = configPerBranch[configKey]

    return configFactory()(context.runNumber, context.payload.pull_request?.number)
}
