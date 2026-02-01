# Build artifact
FROM eclipse-temurin:24 AS builder

RUN apt-get update && apt-get install -y \
    npm

WORKDIR /app

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
RUN ./gradlew backend:dependencies

COPY site/rollup site/rollup

# Cache Rollup dependencies in a docker layer
RUN ./gradlew site:npmInstall

# Copy source code
COPY shared shared
COPY backend backend
COPY site site
COPY anylogic-cloud-client anylogic-cloud-client

# these arguments will be included in the javascript artifact
ARG BACKEND_URL=https://site-backend.lux.energy
ARG ZENMO_DOMAIN=nieuw.zenmo.com
ARG LUX_DOMAIN=lux.energy
# -PkobwebBuildTarget=RELEASE removes hot reload code from the JavaScript
RUN ./gradlew backend:build -PkobwebBuildTarget=RELEASE

# New image without source code files to run the backend
FROM eclipse-temurin:24
WORKDIR /app
COPY --from=builder /app/backend/build/distributions/backend.tar /app/backend.tar
RUN tar -xf backend.tar && rm backend.tar
EXPOSE 80
ENV PORT=80

CMD ["./backend/bin/backend"]
