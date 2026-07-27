# DVD Club

A web-based DVD club management system built with Java EE (JSF/PrimeFaces) and MySQL.

## Features

- DVD catalog management (add, edit, delete DVDs)
- Member registration and management
- DVD borrowing/loan tracking
- Actor and category management
- Role-based access control (Admin/User) with Apache Shiro authentication
- Separate credentials database for user management

## Tech Stack

- Java EE 8 (JSF 2.3, PrimeFaces 10)
- Apache Shiro (authentication & authorization)
- MySQL 8
- WildFly 25
- Maven
- Docker

## Quick Start

```bash
./build.sh
```

This sets up Docker containers, seeds the database, compiles and deploys the app.

App runs at http://localhost:8080/dvdclub

**Default accounts:**
- Admin: `admin` / `admin`
- User: `user` / `user`

## Scripts

| Script | What it does |
|--------|-------------|
| `build.sh` | Full setup: Docker + DB seed + compile + deploy |
| `docker_setup.sh` | Creates MySQL + WildFly containers |
| `seed_sql.sh` | Seeds both databases if empty |
| `deploy_to_wildfly.sh` | Compiles WAR, uploads to WildFly, restarts server |
| `drop_db.sh` | Drops both databases for a fresh start |

## Databases

- `dvdclub_db` — main app data (DVDs, members, loans, actors, categories)
- `dvdclub_auth_db` — Shiro authentication (users, roles)

## Project Structure

```
src/main/java/com/crimsonduelist/dvdclub/
├── controllers/     # JSF managed beans
├── entities/        # JPA entity classes
├── services/        # Business logic (EJBs)
├── helpers/         # Utility classes
├── shiro/           # Apache Shiro integration
└── shiro/controllers/ # Login/logout controller
src/main/webapp/
├── admin/           # Admin-facing pages
├── user/            # User-facing pages
├── templates/       # Shared UI templates
├── admintemplates/  # Admin navbar
├── usertemplates/   # User navbar
├── login.xhtml      # Login page
├── main.xhtml       # Home page (public)
├── error.xhtml      # Error page
└── WEB-INF/         # Configuration (web.xml, shiro.ini)
sql/                 # Database setup scripts
sql/drop/            # Scripts that need root access
docker/              # WildFly Docker image (MySQL driver + datasources)
docs/                # ER diagram
```

## TODO

- [ ] (decouple container creation from config)
- [ ] Non-admin user view needs implementation
- [ ] Registration and password hashing not yet implemented
- [ ] Deleting the last row of a table may cause errors
- [ ] More views for anonymous users
