
BRANCH=$(git branch --show-current)
COMMIT=$(git rev-parse --short HEAD)
TAG=ghcr.io/zenmo/zenmo-website-static:$BRANCH-$COMMIT
