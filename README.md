# Sheep Dog Core

The transformation engine at the heart of the sheep-dog ecosystem. Xtext-based parsers convert AsciiDoc specifications and Cucumber features into UML models and back, enabling bidirectional round-trip engineering between documentation and test code.

```
AsciiDoc <-> UML Model <-> Cucumber/JUnit
```

## Projects

| Project | Description |
|---------|-------------|
| sheep-dog-grammar | Xtext grammar and test project with Cucumber scenarios |
| sheepdogasciidoc.parent | AsciiDoc Xtext parser and LSP server |
| sheepdogcucumber.parent | Cucumber Xtext parser framework |
| sheep-dog-asciidoc-api | AsciiDoc to UML API library (depends on sheepdogasciidoc.parent) |
| sheep-dog-cucumber-gen | Cucumber code generation library (depends on sheep-dog-asciidoc-api, sheepdogcucumber.parent) |

## Build Order

```
sheep-dog-grammar
  -> sheepdogasciidoc.parent
  -> sheepdogcucumber.parent
  -> sheep-dog-asciidoc-api
  -> sheep-dog-cucumber-gen
```

## Build Command

Run `scripts/install.bat` in each project directory. This script defines the correct build command for that project.
