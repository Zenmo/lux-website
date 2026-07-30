#!/bin/bash
# Stop and remove all Quadlet environments belonging to a pull request.

set -euxo pipefail

if [[ ! ${PR_NUMBER:-} =~ ^[0-9]+$ ]]; then
    echo "PR_NUMBER must be a numeric pull request number" >&2
    exit 1
fi

ssh root@"$SSH_HOST" bash -s -- "$PR_NUMBER" <<'REMOTE_SCRIPT'
set -euxo pipefail

pr_number="$1"

for environment_dir in /etc/containers/systemd/website-pr-"$pr_number"-*; do
    [[ -d "$environment_dir" ]] || continue

    environment=${environment_dir##*/website-}
    systemctl stop "site-static-$environment" "site-backend-$environment" || true
    rm -rf -- "$environment_dir"
done

systemctl daemon-reload
REMOTE_SCRIPT
