# Energy Management System

### Database Systems | Java Swing & MySQL

A desktop energy marketplace for households, industrial consumers, and suppliers. Users can buy energy credits, review consumption and payments, and manage transactions through role-specific interfaces.

## At a glance

| Area | Overview |
| --- | --- |
| Resume project | Energy Management System |
| Focus | Database design, SQL workflows, and a desktop user interface |
| Stack | Java Swing, JDBC, MySQL, NetBeans/Ant |
| Users | Household consumers, industrial consumers, energy suppliers |
| Context | BITS Pilani Database Systems course project, April 2024 |

## Features

- Separate registration, login, and dashboards for households, industries, and suppliers.
- Purchase renewable and non-renewable energy credits, with industrial permit trading.
- Review credit balances, monthly consumption, payments, and transaction history.
- Project household weekly consumption from appliance usage.
- Model solar-panel subsidies and manage consumer complaints.
- SQL schema, stored procedures, triggers, and supporting CSV data.

## Project layout

| Path | Contents |
| --- | --- |
| [EnergyManagementSystem/](EnergyManagementSystem/) | NetBeans Java Swing application and form definitions |
| [Data/](Data/) | Supplied CSV data and SQL scripts |
| [CreateTables.sql](CreateTables.sql) | Top-level schema script |
| [Original project brief](DBS%20Project%20README.pdf) | Original feature summary and course context |
| [.env.example](.env.example) | Required local database settings |

## Run locally

1. Install a JDK suitable for the project's Java 20 source/target setting, MySQL, and NetBeans with Java/Ant support.
2. Create a MySQL database named `EMS`. Review and run `CreateTables.sql`, then the applicable scripts in `Data/`. Import CSV data only after checking the target table layouts.
3. Open `EnergyManagementSystem/` as a NetBeans project and configure MySQL Connector/J on its library/classpath. The saved project contains machine-specific connector paths that need updating.
4. Set database variables in the environment used to launch NetBeans or the application:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/EMS"
$env:DB_USER = "root"
$env:DB_PASSWORD = "your-local-password"
```

5. Build and run the configured main class, `LoginPages.Login_Startup`.

Database credentials now come from environment variables. `.env.example` documents them; the application does not automatically load a `.env` file.

## Validation

All 33 Java source files compile with JDK 20 and MySQL Connector/J 8.3.0 after the environment-variable configuration change. The compiler reports existing deprecated-API usage. A live database and GUI workflow were not exercised.

## Implementation notes

This is an academic prototype. The schema scripts and CSV exports are not a turnkey database migration: CSV headers and some entities used by the application require reconciliation before a full run. The supplied login schema uses short plaintext passwords and should be redesigned before any production use. The Java GUI and database workflows have not been validated against a live MySQL instance for this upload.

## Resume fit

This repository corresponds to **Energy Management System** in the Projects section: an energy marketplace with weekly consumption modelling, solar subsidies, renewable credits, and industrial permits. It demonstrates relational modelling, SQL-backed workflows, and Java desktop development.

The original application and project brief are retained as an academic project snapshot. Compiled output, original Git history, machine-local IDE settings, and hardcoded database credentials are excluded.
