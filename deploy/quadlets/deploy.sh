#!/bin/bash
# Set up Quadlet config files, copy them to the Podman host, and restart the services.

set -ex
cd $(dirname "$0")

source ../git-vars.sh
export TAG

OUTPUT_DIR=website-$ENVIRONMENT
mkdir -p $OUTPUT_DIR

# Prepare Quadlet files
for filename in *.container *.env; do
    newfilename=${filename%.*}-$ENVIRONMENT.${filename##*.}
    envsubst < "$filename" > "$OUTPUT_DIR/$newfilename"
done

# Copy files to the Podman host
scp -r $OUTPUT_DIR root@$SSH_HOST:/etc/containers/systemd/

# Restart services
ssh root@$SSH_HOST "\
    systemctl daemon-reload \
    && systemctl restart site-static-$ENVIRONMENT \
    && systemctl restart site-backend-$ENVIRONMENT"
