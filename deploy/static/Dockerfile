FROM eclipse-temurin:24 AS builder

WORKDIR /app

RUN apt-get update && apt-get install -y \
    npm

# Firefox and its system libraries for prerendering, in their own cached layer.
# Keep the version equal to the Playwright the site build resolves (the Kobweb plugin brings it):
#   ./gradlew site:buildEnvironment | grep playwright
# Then the prerender task finds this browser. If they differ, it downloads its own, which also works.
RUN npx --yes playwright@1.58.0 install --with-deps firefox

# Create a cache layer with dependencies.
# Need to copy all the gradle subprojects.
# TODO: js-libs has the potential to change a lot, invalidating the cache layer.
COPY --parents \
    gradle \
    gradlew \
    gradle.properties \
    settings.gradle.kts \
    site/build.gradle.kts \
    site/.kobweb \
    shared/build.gradle.kts \
    backend/build.gradle.kts \
    remotedev/build.gradle.kts \
    prerender/build.gradle.kts \
    prerender/settings.gradle.kts \
    prerender/src/main \
    js-libs \
    ./

# Cache gradle and npm dependencies in a docker layer.
# kotlinNpmInstall also installs our own js-libs, which Rollup bundles into the JavaScript.
RUN ./gradlew kotlinNpmInstall && ./gradlew site:dependencies

COPY site/rollup site/rollup

# Cache Rollup dependencies in a docker layer
RUN ./gradlew site:npmInstall

# Copy source code
COPY shared shared
COPY site site

# BACKEND_URL is used in index.html.
# The domains decide which pages are prerendered and the folder each one is saved in,
# so they must match the backend build (deploy/backend/Dockerfile).
ARG BACKEND_URL=https://site-backend.lux.energy
ARG ZENMO_DOMAIN=zenmo.com
ARG LUX_DOMAIN=lux.energy
ARG SUBDOMAIN_SEPARATOR=.
# -PkobwebBuildTarget=RELEASE removes hot reload elements and styles from index.html.
# preRender also builds the static site (jsProcessResources) and the JavaScript it renders with.
RUN ./gradlew site:preRender -PkobwebBuildTarget=RELEASE

# Use Caddy to serve static files
FROM caddy:2.8.4
WORKDIR /srv

COPY --from=builder /app/site/build/processedResources/js/main/public /srv/
# One folder per host, e.g. /srv/lux.energy/nl/index.html. The Caddyfile looks there first.
COPY --from=builder /app/site/build/preRender /srv/
COPY deploy/static/Caddyfile /etc/caddy/Caddyfile
EXPOSE 80

CMD ["caddy", "run", "--config", "/etc/caddy/Caddyfile"]
