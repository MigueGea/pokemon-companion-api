The main idea of Hexagonal Architecture is that your business logic (the domain) should not depend on frameworks, databases, or external APIs. Instead, the outside world depends on your business logic.

Let's go through each folder.
#Domain
domain

This is the heart of your application.

It contains the business concepts and rules. Ideally, it should have no Spring annotations like @Service, @Component, or @Repository.

model

These are your business objects.

port

A port is simply an interface.

It defines what the domain needs without saying how it will be done.

Notice there's no mention of:

HTTP
POKEMONAPI
JSON
Spring

The domain only says:

"I need someone capable of searching characters."

It doesn't care who does it.

service

This contains your business logic.

application

This layer coordinates use cases.

Think of it as the application's workflow.

infrastructure

Everything related to the outside world goes here.

adapter/in/rest

These are your REST controllers.

adapter/out

This contains implementations of your ports.

client

This is the low-level HTTP communication.

dto

DTOs represent data exchanged with external systems.

shared

Things used by multiple features.
