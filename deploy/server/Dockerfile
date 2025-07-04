FROM eclipse-temurin:21 AS builder
RUN apt-get update && apt-get install -y \
    npm \
    libglib2.0-0t64 \
    libnss3 \
    libnspr4 \
    libdbus-1-3 \
    libatk1.0-0t64 \
    libatk-bridge2.0-0t64 \
    libatspi2.0-0t64 \
    libx11-6 \
    libxcomposite1 \
    libxdamage1 \
    libxext6 \
    libxfixes3 \
    libxrandr2 \
    libgbm1 \
    libxkbcommon0 \
    libasound2t64

WORKDIR /app

COPY . ./

RUN chmod +x ./gradlew
# these arguments will be included in the javascript artifact
# TODO: set per environment
ARG BACKEND_URL=https://site-backend.zenmo.com
ARG ZENMO_DOMAIN=nieuw.zenmo.com
ARG LUX_DOMAIN=lux.energy
RUN --mount=type=cache,target=/root/.gradle \
    --mount=type=cache,target=/root/.cache \
    --mount=type=cache,target=/app/.gradle \
    ./gradlew server:build

FROM eclipse-temurin:21
WORKDIR /app
COPY --from=builder /app/server/build/distributions/server.tar /app/server.tar
RUN tar -xf server.tar && rm server.tar
CMD ["./server/bin/server"]
