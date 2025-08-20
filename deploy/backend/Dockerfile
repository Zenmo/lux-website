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

WORKDIR /app/prerender
RUN ./gradlew publish
WORKDIR /app

RUN chmod +x ./gradlew
# these arguments will be included in the javascript artifact
ARG BACKEND_URL=https://site-backend.zenmo.com
ARG ZENMO_DOMAIN=nieuw.zenmo.com
ARG LUX_DOMAIN=lux.energy
RUN --mount=type=cache,target=/root/.gradle \
    --mount=type=cache,target=/root/.cache \
    --mount=type=cache,target=/app/.gradle \
    ./gradlew backend:build -PkobwebBuildTarget=RELEASE

FROM eclipse-temurin:21
WORKDIR /app
COPY --from=builder /app/backend/build/distributions/backend.tar /app/backend.tar
RUN tar -xf backend.tar && rm backend.tar
EXPOSE 80
ENV PORT=80

CMD ["./backend/bin/backend"]
