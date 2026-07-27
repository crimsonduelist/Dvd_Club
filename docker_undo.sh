# 1. Stop and remove WildFly container
docker stop dvdclub-wildfly && docker rm dvdclub-wildfly

# 2. Stop and remove MySQL container
docker stop dvdclub-db && docker rm dvdclub-db

# 3. Remove MySQL data volume
docker volume rm dvdclub-mysql-data

# 4. Remove network
docker network rm dvdclub-net

# 5. Remove WildFly image
docker rmi dvdclub-wildfly
