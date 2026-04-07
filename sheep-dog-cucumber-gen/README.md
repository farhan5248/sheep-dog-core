# Sheep Dog Cucumber Gen

Generates Cucumber test code and Java step definitions from UML models.

## Overview

Converts UML models into Cucumber feature files and Java step definition classes. Supports multiple testing frameworks: plain Cucumber, Guice, and Spring variants. Also supports the reverse direction, converting Cucumber features back into UML models.

## Key Functionality

- UML model to Cucumber feature generation
- Cucumber to UML model transformation
- Java step definition code generation (plain, Guice, Spring variants)
- Depends on sheep-dog-asciidoc-api for UML model classes

## Technology

- Eclipse EMF/UML2
- Eclipse Xtext
- JavaParser for Java code generation
- Depends on sheep-dog-asciidoc-api, sheepdogcucumber.parent
- Java 21

## Build

```
scripts/install.bat
```
