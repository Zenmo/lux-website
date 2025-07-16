
BRANCH=$(git branch --show-current)
BRANCH=${BRANCH:-$GITHUB_HEAD_REF} # for pull requests in GitHub Actions

COMMIT=$(git rev-parse --short HEAD)
# prefer run number in GitHub Actions, otherwise use commit hash
VERSION=${GITHUB_RUN_NUMBER:-$COMMIT}

TAG=$BRANCH-$VERSION
