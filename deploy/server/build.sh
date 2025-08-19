#!/bin/bash

set -ex

cd $(dirname "$0")

#source ../git-vars.sh

# It seems we can always specify GitHub Actions caching
# and if it's not available it will fall back to local caching.
docker buildx build \
    --file Dockerfile \
    --tag ghcr.io/zenmo/zenmo-website-server:$TAG \
    --build-arg BACKEND_URL=$BACKEND_URL \
    --build-arg ZENMO_DOMAIN=$ZENMO_DOMAIN \
    --build-arg LUX_DOMAIN=$LUX_DOMAIN \
    --progress=plain \
    --cache-to type=gha,mode=max,scope=server \
    --cache-from type=gha,scope=server \
    $@ \
    ../..
