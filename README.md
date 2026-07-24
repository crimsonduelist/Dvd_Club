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
- MySQL/MariaDB
- WildFly 26.1.0.Final
- Maven

## Setup

### Prerequisites

- Java 8 JDK
- Maven
- MySQL/MariaDB
- WildFly 26.1.0.Final

### Database Setup

1. Run `sql/01_schema.sql` to create the DVD Club database
2. Run `sql/02_users.sql` to create the authentication database
3. (Optional) Run `sql/03_samples.sql` to populate with sample data

### WildFly Configuration

1. Add MySQL JDBC driver to WildFly
2. Create two datasources in WildFly:
   - `MYSQL_DS_CREDENTIALS3` → DVD Club database
   - `MYSQL_DS_CREDENTIALS2` → Users database
3. Update `src/main/resources/META-INF/persistence.xml` if you change datasource names
4. Update `src/main/webapp/WEB-INF/shiro.ini` if you change datasource names

### Build & Deploy

```bash
mvn clean package
```

Deploy `target/dvdclub-1.0.war` to WildFly.

## Project Structure

```
src/main/java/com/crimsonduelist/dvdclub/
├── controllers/     # JSF managed beans (backing beans)
├── entities/        # JPA entity classes
├── services/        # Business logic layer
├── helpers/         # Utility classes
└── shiro/           # Apache Shiro integration
src/main/webapp/
├── admin/           # Admin-facing pages
├── user/            # User-facing pages
├── templates/       # Shared UI templates
└── WEB-INF/         # Configuration (web.xml, shiro.ini)
sql/                 # Database setup scripts
docs/                # ER diagram
```

## Known Issues

- Deleting the last row of a table may cause errors
- Non-admin user side needs more implementation
- Registration and password hashing not yet implemented
- Shiro filter may affect JSF/PrimeFaces styling on first page load (workaround: COOKIE tracking mode)
