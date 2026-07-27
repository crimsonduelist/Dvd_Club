#!/bin/bash
# docker_setup.sh - Sets up Docker infrastructure (MySQL + WildFly)
# Safe to run multiple times - skips what already exists.

set -e

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_DIR"

# --- Network ---
if ! docker network inspect dvdclub-net >/dev/null 2>&1; then
    echo "Creating network dvdclub-net..."
    docker network create dvdclub-net
fi

# --- MySQL ---
if docker ps -a --format '{{.Names}}' | grep -q '^dvdclub-db$'; then
    echo "MySQL container exists."
    if ! docker ps --format '{{.Names}}' | grep -q '^dvdclub-db$'; then
        echo "Starting MySQL..."
        docker start dvdclub-db
    fi
else
    echo "Creating MySQL container..."
    docker run -d --name dvdclub-db \
        --network dvdclub-net \
        -e MYSQL_ROOT_PASSWORD=rootpass \
        -e MYSQL_DATABASE=dvdclub_db \
        -e MYSQL_USER=user \
        -e MYSQL_PASSWORD=pass \
        -v dvdclub-mysql-data:/var/lib/mysql \
        mysql:8
fi

echo "Waiting for MySQL..."
until docker exec dvdclub-db mysqladmin ping -h localhost -uuser -ppass --silent 2>/dev/null; do
    sleep 2
done
echo "MySQL ready."

# --- WildFly image ---
if ! docker images --format '{{.Repository}}:{{.Tag}}' | grep -q '^dvdclub-wildfly:latest$'; then
    echo "Building WildFly image..."
    docker build -f docker/Dockerfile.wildfly -t dvdclub-wildfly .
fi

# --- WildFly container ---
if docker ps -a --format '{{.Names}}' | grep -q '^dvdclub-wildfly$'; then
    echo "WildFly container exists."
    if ! docker ps --format '{{.Names}}' | grep -q '^dvdclub-wildfly$'; then
        echo "Starting WildFly..."
        docker start dvdclub-wildfly
    fi
else
    echo "Creating WildFly container..."
    docker run -d --name dvdclub-wildfly \
        --network dvdclub-net \
        -p 8080:8080 \
        -p 9990:9990 \
        dvdclub-wildfly
fi

echo "Docker setup complete."
