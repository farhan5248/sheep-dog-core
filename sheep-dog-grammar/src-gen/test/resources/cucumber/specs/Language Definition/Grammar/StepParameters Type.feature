@grammar
Feature: StepParameters Type

  \@grammar
  Step Parameters is a grammar rule in SheepDog.xtext contained within a Step Definition. These tests verify editing Step Parameters elements within a document.

  @list
  Scenario: Step Parameters

    \@list
    Step Parameters must have
    - Name
    and optionally have these
    - Description
    - Table

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParameterList node is created as follows
          | Node Path                               | Step Parameters Name  |
          | StepDefinitionList/1/StepParameterList | First Step Parameters |
     When The xtext plugin edit document action is performed to modify StepParameterList with
          | Step Object Full Name                       | Node Path                               | Step Parameters Name   |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList/1/StepParameterList | Second Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParameterList node will be created as follows
          | Node Path                                 | Step Parameters Name   |
          | StepDefinitionList/1/StepParameterList/2 | Second Step Parameters |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows
          | Node Path                                             | State  |
          | StepDefinitionList/1/StepParameterList/2/Description | Absent |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Table node will be as follows
          | Node Path                                       | State  |
          | StepDefinitionList/1/StepParameterList/2/Table | Absent |

  Scenario: Duplicate Step Parameters Name

    Step Parameters name must be unique within a Step Definition. Creating Step Parameters with an existing name returns the existing one.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParameterList node is created as follows
          | Node Path                               | Step Parameters Name  |
          | StepDefinitionList/1/StepParameterList | First Step Parameters |
     When The xtext plugin edit document action is performed to modify StepParameterList with
          | Step Object Full Name                       | Node Path                               | Step Parameters Name  |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList/1/StepParameterList | First Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParameterList node will be as follows
          | Node Path                                 | State  |
          | StepDefinitionList/1/StepParameterList/2 | Absent |

  Scenario: Sorted Step Parameters Name

    Step Parameters are sorted alphabetically by name within a Step Definition.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParameterList node is created as follows
          | Node Path                               | Step Parameters Name   |
          | StepDefinitionList/1/StepParameterList | Second Step Parameters |
     When The xtext plugin edit document action is performed to modify StepParameterList with
          | Step Object Full Name                       | Node Path                               | Step Parameters Name  |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList/1/StepParameterList | First Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParameterList node will be created as follows
          | Node Path                                 | Step Parameters Name   |
          | StepDefinitionList/1/StepParameterList/1 | First Step Parameters  |
          | StepDefinitionList/1/StepParameterList/2 | Second Step Parameters |

