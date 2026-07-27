#!/bin/bash
# build.sh - Compiles Java, sets up Docker, seeds DB, deploys to WildFly.
# Single command to get everything running.

set -e

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_DIR"

# 1. Docker infrastructure
echo "=== Docker setup ==="
./docker_setup.sh

# 2. Seed DB if empty
echo ""
echo "=== Seeding database ==="
./seed_sql.sh

# 3. Compile and deploy
echo ""
echo "=== Deploying to WildFly ==="
./deploy_to_wildfly.sh

echo ""
echo "Done. App at http://localhost:8080/dvdclub"
