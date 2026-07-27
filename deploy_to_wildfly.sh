#!/bin/bash
# deploy_to_wildfly.sh - Compiles and deploys WAR to running WildFly.
# Safe to run multiple times.

set -e

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_DIR"

if ! docker ps -a --format '{{.Names}}' | grep -q '^dvdclub-wildfly$'; then
    echo "ERROR: WildFly container not found. Run './docker_setup.sh' first."
    exit 1
fi

echo "Building WAR..."
mvn clean package -DskipTests -q

DEPLOY_DIR="/opt/jboss/wildfly/standalone/deployments"

echo "Stopping WildFly..."
docker stop dvdclub-wildfly
while [ "$(docker inspect -f '{{.State.Status}}' dvdclub-wildfly 2>/dev/null)" != "exited" ]; do
    sleep 1
done

echo "Uploading WAR..."
docker cp target/dvdclub-1.0.war dvdclub-wildfly:$DEPLOY_DIR/dvdclub.war

echo "Starting WildFly..."
docker start dvdclub-wildfly

echo "Waiting for WildFly..."
until curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/dvdclub 2>/dev/null | grep -qE "200|302"; do
    sleep 3
done
echo "Deployed. App at http://localhost:8080/dvdclub"
