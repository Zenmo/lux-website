FROM eclipse-temurin:24 AS builder

WORKDIR /app

RUN apt-get update && apt-get install -y \
    npm

# pre-rendering disabled until it's useful
#    libglib2.0-0t64 \
#    libnss3 \
#    libnspr4 \
#    libdbus-1-3 \
#    libatk1.0-0t64 \
#    libatk-bridge2.0-0t64 \
#    libatspi2.0-0t64 \
#    libx11-6 \
#    libxcomposite1 \
#    libxdamage1 \
#    libxext6 \
#    libxfixes3 \
#    libxrandr2 \
#    libgbm1 \
#    libxkbcommon0 \
#    libasound2t64
#
#WORKDIR /app/prerender
#RUN ./gradlew publish

# Create a cache layer with dependencies
# Need to copy all the gradle subprojects
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
    ./

# Cache gradle dependencies in a docker layer
RUN ./gradlew site:dependencies

COPY site/rollup site/rollup

# Cache Rollup dependencies in a docker layer
RUN ./gradlew site:npmInstall

# Copy source code
COPY shared shared
COPY site site

# BACKEND_URL is used in index.html
ARG BACKEND_URL=https://site-backend.lux.energy
# -PkobwebBuildTarget=RELEASE removes hot reload elements and styles from index.html
RUN ./gradlew site:jsProcessResources -PkobwebBuildTarget=RELEASE

# Use Caddy to serve static files
FROM caddy:2.8.4
WORKDIR /srv

COPY --from=builder /app/site/build/processedResources/js/main/public /srv/
COPY deploy/static/Caddyfile /etc/caddy/Caddyfile
EXPOSE 80

CMD ["caddy", "run", "--config", "/etc/caddy/Caddyfile"]
