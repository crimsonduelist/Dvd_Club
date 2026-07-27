#!/bin/bash
# drop_db.sh - Drops both databases for a fresh start.
# Run ./build.sh after this to reseed.

set -e

echo "Dropping databases..."
docker exec -i dvdclub-db mysql -uroot -prootpass < sql/drop/drop_db.sql
echo "Databases dropped."
