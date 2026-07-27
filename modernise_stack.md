If you just want it **running locally with minimal changes**:
1. Keep WildFly (download once, runs anywhere)
2. Or use **Payara Micro** — lighter, same programming model

If you want to **modernize the stack** (like your other projects):
- Spring Boot 3 + Thymeleaf/HTMX or REST + frontend
- Quarkus if you want Jakarta EE continuity

Want me to sketch a migration plan for one of these paths?


You change code → mvn package → docker build (10 sec) → docker run new container


```bash
# First time ever
./build.sh

# Daily development (code changes only)
./build.sh

# Schema changes / want fresh data
./build.sh --reseed

# Clean build
./build.sh --clean
