#!/bin/bash
# seed_sql.sh - Seeds the database if empty.
# Safe to run multiple times - skips if data already exists.

set -e

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_DIR"

DATA_COUNT=$(docker exec dvdclub-db mysql -uroot -prootpass -sN -e "SELECT COUNT(*) FROM dvdclub_db.Member" 2>/dev/null || echo "0")

if [ "$DATA_COUNT" -gt 0 ]; then
    echo "Database already seeded ($DATA_COUNT members). Skipping."
    exit 0
fi

echo "Database empty. Seeding..."

echo "  Creating DVD Club schema..."
docker exec -i dvdclub-db mysql -uroot -prootpass < sql/create_db.sql

echo "  Creating auth schema..."
docker exec -i dvdclub-db mysql -uroot -prootpass < sql/create_users.sql

echo "  Seeding DVD Club data..."
docker exec -i dvdclub-db mysql -uroot -prootpass < sql/seed.sql

echo "  Seeding user accounts..."
docker exec -i dvdclub-db mysql -uroot -prootpass < sql/seed_users.sql

echo "  Granting user access to auth database..."
docker exec dvdclub-db mysql -uroot -prootpass -e "GRANT ALL PRIVILEGES ON dvdclub_auth_db.* TO 'user'@'%'; FLUSH PRIVILEGES;"

echo "Seeding complete."
