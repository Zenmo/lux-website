#!/bin/bash

set -ex

cd $(dirname "$0")

source ../git-vars.sh

# It seems we can always specify GitHub Actions caching
# and if it's not available it will fall back to local caching.
docker buildx build \
    --file Dockerfile \
    --tag ghcr.io/zenmo/zenmo-website-static:$TAG \
    --progress=plain \
    --cache-to type=gha,mode=max,scope=static \
    --cache-from type=gha,scope=static \
    $@ \
    ../..
