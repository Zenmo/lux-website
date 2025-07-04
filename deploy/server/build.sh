#!/bin/bash

set -ex

cd $(dirname "$0")

source vars.sh

# It seems we can always specify GitHub Actions caching
# and if it's not available it will fall back to local caching.
docker buildx build \
    --file Dockerfile \
    --tag $TAG \
    --progress=plain \
    --cache-to type=gha,mode=max,scope=server \
    --cache-from type=gha,scope=server \
    --push \
    ../..
