# Sheep Dog Core

The transformation engine at the heart of the sheep-dog ecosystem. Xtext-based parsers convert AsciiDoc specifications and Cucumber features into UML models and back, enabling bidirectional round-trip engineering between documentation and test code.

```
AsciiDoc <-> UML Model <-> Cucumber/JUnit
```

## Projects

| Project | Description |
|---------|-------------|
| sheep-dog-grammar | Core grammar logic and validation framework shared across Xtext DSL projects |
| sheepdogasciidoc.parent | Xtext-based AsciiDoc parser and LSP server |
| sheepdogcucumber.parent | Xtext-based Cucumber/Gherkin parser |
| sheep-dog-asciidoc-api | Bidirectional transformation between AsciiDoc and UML models |
| sheep-dog-cucumber-gen | Generates Cucumber test code and step definitions from UML models |

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
