const configPerBranch = {
    production: {
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
    },
    main: {
        BACKEND_DOMAIN: "site-backend.test.lux.energy",
        BACKEND_URL: "https://site-backend.test.lux.energy",
        ENVIRONMENT: "test",
        CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",
        LUX_DOMAIN: "test.lux.energy",
        LUX_HOST_REGEXP: "^[\\\\w-]+\\\\.test\\\\.lux\\\\.energy",
        // Higher priority for test because productions *.lux.energy shadows test.lux.energy
        TRAEFIK_PRIORITY: -1000,
        ZENMO_DOMAIN: "test.zenmo.com",
    },
    pull_request: {
        BACKEND_DOMAIN: "localhost",
        BACKEND_URL: "http://localhost:9000",
        ENVIRONMENT: "pull_request",
        CORS_ORIGIN_PATTERN: "https:\\/\\/((.*\\.)?lux\\.energy|(.*\\.)?zenmo\\.com)",
        LUX_DOMAIN: "lux.localhost:8080",
        LUX_HOST_REGEXP: "",
        TRAEFIK_PRIORITY: -10_000,
        ZENMO_DOMAIN: "zenmo.localhost:8080",
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

    if (configKey === "gradle-docker-layer-cache") {
        configKey = "main"
    }

    if (!Object.keys(configPerBranch).includes(configKey)) {
        throw Error(`No config for branch ${configKey}`)
    }

    return {
        ...configPerBranch[configKey],
        TAG: `${configKey}-${context.runNumber}`
    }
}
