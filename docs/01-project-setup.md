# 02 - Hexagonal Architecture

## Overview

This project follows a **feature-oriented Hexagonal Architecture** (also known as Ports and Adapters).

The goal is to keep the business logic independent from external technologies such as Spring Boot, databases or external APIs.

Each feature is organized as an independent module.

Current project structure:

```text
com.miguegea.pokemon.companion

├── common/
├── config/
└── character/
    ├── application/
    ├── domain/
    └── infrastructure/
```

---

## Why Hexagonal Architecture?

The project uses Hexagonal Architecture for the following reasons:

- Separate business logic from infrastructure.
- Make the domain easy to test.
- Allow external technologies to be replaced without affecting the core business logic.
- Improve maintainability as the project grows.

---

## Project Layers

### Domain

The domain contains the business model.

It should contain:

- Entities
- Value Objects
- Domain Services
- Business Rules

The domain must **not** depend on:

- Spring Boot
- JPA
- REST Controllers
- External APIs

---

### Application

The application layer coordinates the use cases.

It is responsible for:

- Executing business use cases.
- Calling the required ports.
- Orchestrating the domain.

Business logic should remain inside the domain whenever possible.

---

### Infrastructure

The infrastructure layer contains all technical implementations.

Examples include:

- REST Controllers
- Database access
- JPA repositories
- External API clients
- Configuration
- Persistence implementations

Infrastructure depends on the application layer, never the opposite.

---

## Feature-Oriented Packaging

Instead of organizing the project by technical layers:

```text
controller/
service/
repository/
```

the project is organized by business features.

For example:

```text
character/
world/
lodestone/
```

Each feature owns its own application, domain and infrastructure layers.

---

## Dependency Direction

Dependencies always point toward the business logic.

```text
Infrastructure
        ↓
Application
        ↓
Domain
```

The domain must remain independent of external frameworks.

---

## Ports and Adapters

Communication between the application layer and infrastructure is performed using Ports and Adapters.

- Ports are interfaces defined by the application.
- Adapters are implementations provided by the infrastructure.

This allows infrastructure to change without affecting business logic.

---

## Current Features

At the moment, the project contains the following feature:

- Character

Additional features will be added as the project evolves.

## Guiding Principles

When adding new code, always ask:

1. Does this belong to the business domain?
2. Is this a use case?
3. Is this infrastructure?

If the answer is unclear, reconsider the design before writing code.
