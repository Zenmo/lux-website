#!/bin/bash
# Set up Quadlet config files, copy them to the Podman host, and restart the services.

set -ex
cd $(dirname "$0")

source ../git-vars.sh
export TAG

mkdir -p website

# Prepare Quadlet files
for filename in *.container *.env; do
  envsubst < "$filename" > "website/$filename"
done

  # Copy files to the Podman host
  scp -r website podman@podhost.zenmo.com:~/.config/containers/systemd/

  # Restart services
  ssh podman@podhost.zenmo.com "\
      systemctl --user daemon-reload \
      && systemctl --user restart site-static \
      && systemctl --user restart site-backend"
