package org.farhan.common;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.junit.jupiter.api.Assertions;

public class TestObjectIDE extends TestObject {

    // === add* helpers (from TestObjectDoc) ===

    protected void addCellWithName(String name) {
        if (cursor instanceof ICell) {
            cursor = ((ICell) cursor).getParent();
        }
        cursor = SheepDogBuilder.createCell((IRow) cursor, name);
    }

    protected void addLineWithContent(String content) {
        if (cursor instanceof ILine) {
            cursor = ((ILine) cursor).getParent();
        }
        cursor = SheepDogBuilder.createLine((IDescription) cursor, content);
    }

    protected void addRowWithContent(String content) {
        if (cursor instanceof IRow) {
            cursor = ((IRow) cursor).getParent();
        }
        IRow row = SheepDogBuilder.createRow((ITable) cursor);
        SheepDogBuilder.createCell(row, content);
        cursor = row;
    }

    protected void addStepDefinitionWithName(String name) {
        if (cursor instanceof IStepDefinition) {
            cursor = ((IStepDefinition) cursor).getParent();
        }
        cursor = SheepDogBuilder.createStepDefinition((IStepObject) cursor, name);
    }

    protected void addStepObjectWithFullName(String stepObjectName) {
        if (cursor instanceof IStepObject) {
            cursor = ((IStepObject) cursor).getParent();
        }
        cursor = SheepDogBuilder.createStepObject(testProject, stepObjectName);
    }

    protected void addStepParametersWithName(String name) {
        if (cursor instanceof IStepParameters) {
            cursor = ((IStepParameters) cursor).getParent();
        }
        cursor = SheepDogBuilder.createStepParameters((IStepDefinition) cursor, name);
    }

    protected void addTable() {
        if (cursor instanceof ITestStep) {
            cursor = SheepDogBuilder.createTable((ITestStep) cursor);
        } else if (cursor instanceof IStepParameters) {
            cursor = SheepDogBuilder.createTable((IStepParameters) cursor);
        }
    }

    protected void addTestCaseWithName(String testStepContainerName) {
        if (cursor instanceof ITestCase) {
            cursor = ((ITestCase) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestCase((ITestSuite) cursor, testStepContainerName);
    }

    protected void addTestDataWithName(String name) {
        if (cursor instanceof ITestData) {
            cursor = ((ITestData) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestData((ITestCase) cursor, name);
    }

    protected void addTestSetupWithName(String testSetupName) {
        if (cursor instanceof ITestStepContainer) {
            cursor = ((ITestStepContainer) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestSetup((ITestSuite) cursor, testSetupName);
    }

    protected void addTestStepWithFullName(String stepName) {
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepName);
    }

    protected void addTestSuiteWithFullName(String testSuiteFullName) {
        if (cursor instanceof ITestSuite) {
            cursor = ((ITestSuite) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestSuite(testProject, testSuiteFullName);
    }

    protected void addTextWithContent(String content) {
        cursor = SheepDogBuilder.createText((ITestStep) cursor, content);
    }

    // === assert* helpers (from TestObjectDoc) ===

    protected void assertCellName(String name) {
        if (cursor instanceof ICell) {
            Assertions.assertEquals(name, ((ICell) cursor).getName());
        } else {
            cursor = ((IRow) cursor).getCell(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertDescriptionEmpty() {
        IDescription desc = null;
        if (cursor instanceof ITestSuite)
            desc = ((ITestSuite) cursor).getDescription();
        else if (cursor instanceof ITestStepContainer)
            desc = ((ITestStepContainer) cursor).getDescription();
        else if (cursor instanceof IStepObject)
            desc = ((IStepObject) cursor).getDescription();
        else if (cursor instanceof IStepDefinition)
            desc = ((IStepDefinition) cursor).getDescription();
        else if (cursor instanceof IStepParameters)
            desc = ((IStepParameters) cursor).getDescription();
        else if (cursor instanceof ITestData)
            desc = ((ITestData) cursor).getDescription();
        Assertions.assertNull(desc);
    }

    protected void assertLineContent(String content) {
        if (cursor instanceof ILine) {
            Assertions.assertEquals(content, ((ILine) cursor).getName());
        } else {
            cursor = ((IDescription) cursor).getLine(content);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertRowContent(String content) {
        cursor = ((IRow) cursor).getCell(content);
        Assertions.assertNotNull(cursor);
    }

    protected void assertStepDefinitionListEmpty() {
        Assertions.assertTrue(((IStepObject) cursor).getStepDefinitionList().isEmpty());
    }

    protected void assertStepDefinitionName(String name) {
        if (cursor instanceof IStepDefinition) {
            Assertions.assertEquals(name, ((IStepDefinition) cursor).getName());
        } else {
            cursor = ((IStepObject) cursor).getStepDefinition(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertStepObjectName(String name) {
        Assertions.assertEquals(name, ((IStepObject) cursor).getName());
    }

    protected void assertStepParametersListEmpty() {
        Assertions.assertTrue(((IStepDefinition) cursor).getStepParameterList().isEmpty());
    }

    protected void assertStepParametersName(String name) {
        if (cursor instanceof IStepParameters) {
            Assertions.assertEquals(name, ((IStepParameters) cursor).getName());
        } else {
            cursor = ((IStepDefinition) cursor).getStepParameters(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTableAbsent() {
        ITable t = null;
        if (cursor instanceof IStepParameters)
            t = ((IStepParameters) cursor).getTable();
        else if (cursor instanceof ITestData)
            t = ((ITestData) cursor).getTable();
        Assertions.assertNull(t);
    }

    protected void assertTablePresent() {
        Assertions.assertNotNull(cursor);
    }

    protected void assertTestDataListEmpty() {
        Assertions.assertTrue(((ITestCase) cursor).getTestDataList().isEmpty());
    }

    protected void assertTestDataName(String name) {
        if (cursor instanceof ITestData) {
            Assertions.assertEquals(name, ((ITestData) cursor).getName());
        } else {
            cursor = ((ITestCase) cursor).getTestData(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestStepContainerListEmpty() {
        Assertions.assertTrue(((ITestSuite) cursor).getTestStepContainerList().isEmpty());
    }

    protected void assertTestStepContainerName(String name) {
        if (cursor instanceof ITestStepContainer) {
            Assertions.assertEquals(name, ((ITestStepContainer) cursor).getName());
        } else {
            cursor = ((ITestSuite) cursor).getTestStepContainer(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestStepFullName(String fullName) {
        Assertions.assertEquals(fullName, ((ITestStep) cursor).getFullName());
    }

    protected void assertTestStepListEmpty() {
        Assertions.assertTrue(((ITestStepContainer) cursor).getTestStepList().isEmpty());
    }

    protected void assertStepDefinitionRefName(String name) {
        Assertions.assertEquals(name, ((ITestStep) cursor).getStepDefinitionName());
    }

    protected void assertStepObjectRefName(String name) {
        Assertions.assertEquals(name, ((ITestStep) cursor).getStepObjectName());
    }

    protected void assertTestSuiteName(String name) {
        Assertions.assertEquals(name, ((ITestSuite) cursor).getName());
    }

    protected void assertTextAbsent() {
        Assertions.assertNull(((ITestStep) cursor).getText());
    }

    protected void assertTextPresent() {
        Assertions.assertNotNull(((ITestStep) cursor).getText());
    }

    // === set* helpers (from TestObjectDoc) ===

    protected void setStepDefinitionName(String name) {
        ((ITestStep) cursor).setStepDefinitionName(name);
    }

    protected void setTestSuiteName(String name) {
        if (cursor instanceof ITestSuite) {
            ((ITestSuite) cursor).setName(name);
        }
    }

    // === Node navigation (from TestObjectIDE) ===

    protected static Object getDocumentFromNode(Object node) {
        Object current = node;
        while (current != null && !(current instanceof ITestDocument)) {
            if (current instanceof ICell) {
                current = ((ICell) current).getParent();
            } else if (current instanceof IRow) {
                current = ((IRow) current).getParent();
            } else if (current instanceof ITable) {
                current = ((ITable) current).getParent();
            } else if (current instanceof IText) {
                current = ((IText) current).getParent();
            } else if (current instanceof ILine) {
                current = ((ILine) current).getParent();
            } else if (current instanceof IDescription) {
                current = ((IDescription) current).getParent();
            } else if (current instanceof ITestStep) {
                current = ((ITestStep) current).getParent();
            } else if (current instanceof ITestData) {
                current = ((ITestData) current).getParent();
            } else if (current instanceof ITestStepContainer) {
                current = ((ITestStepContainer) current).getParent();
            } else if (current instanceof IStepParameters) {
                current = ((IStepParameters) current).getParent();
            } else if (current instanceof IStepDefinition) {
                current = ((IStepDefinition) current).getParent();
            } else if (current instanceof ITestProject) {
                return null;
            } else {
                return null;
            }
        }
        return current;
    }

    private Object getChildNode(Object parent, String elementType, int index) {
        switch (elementType) {
        case "Table":
            if (parent instanceof ITestStep) return ((ITestStep) parent).getTable();
            if (parent instanceof ITestData) return ((ITestData) parent).getTable();
            return ((IStepParameters) parent).getTable();
        case "Text":
            return ((ITestStep) parent).getText();
        case "Description":
            if (parent instanceof ITestSuite) return ((ITestSuite) parent).getDescription();
            if (parent instanceof ITestStepContainer) return ((ITestStepContainer) parent).getDescription();
            if (parent instanceof IStepObject) return ((IStepObject) parent).getDescription();
            if (parent instanceof IStepDefinition) return ((IStepDefinition) parent).getDescription();
            if (parent instanceof IStepParameters) return ((IStepParameters) parent).getDescription();
            return ((ITestData) parent).getDescription();
        case "TestStepContainerList":
            return ((ITestSuite) parent).getTestStepContainer(index);
        case "TestStepList":
            return ((ITestStepContainer) parent).getTestStep(index);
        case "RowList":
            return ((ITable) parent).getRow(index);
        case "CellList":
            return ((IRow) parent).getCell(index);
        case "StepDefinitionList":
            return ((IStepObject) parent).getStepDefinition(index);
        case "StepParametersList":
            return ((IStepDefinition) parent).getStepParameters(index);
        case "LineList":
            return ((IDescription) parent).getLine(index);
        case "TestDataList":
            return ((ITestCase) parent).getTestData(index);
        default:
            throw new IllegalArgumentException("Unknown element type: " + elementType);
        }
    }

    private Object getOrCreateNode(Object parent, String elementType, int index) {
        switch (elementType) {
        case "Table": {
            Object child = getChildNode(parent, elementType, index);
            if (child != null) return child;
            if (parent instanceof ITestStep) return SheepDogBuilder.createTable((ITestStep) parent);
            if (parent instanceof ITestData) return SheepDogBuilder.createTable((ITestData) parent);
            return SheepDogBuilder.createTable((IStepParameters) parent);
        }
        case "Description": {
            Object child = getChildNode(parent, elementType, index);
            if (child != null) return child;
            if (parent instanceof ITestSuite) return SheepDogBuilder.createDescription((ITestSuite) parent);
            if (parent instanceof ITestStepContainer) return SheepDogBuilder.createDescription((ITestStepContainer) parent);
            if (parent instanceof IStepObject) return SheepDogBuilder.createDescription((IStepObject) parent);
            if (parent instanceof IStepDefinition) return SheepDogBuilder.createDescription((IStepDefinition) parent);
            if (parent instanceof IStepParameters) return SheepDogBuilder.createDescription((IStepParameters) parent);
            return SheepDogBuilder.createDescription((ITestData) parent);
        }
        default:
            try {
                return getChildNode(parent, elementType, index);
            } catch (IndexOutOfBoundsException e) {
                switch (elementType) {
                case "TestStepContainerList":
                    return SheepDogBuilder.createTestCase((ITestSuite) parent, "");
                case "TestStepList":
                    return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
                case "RowList":
                    return SheepDogBuilder.createRow((ITable) parent);
                case "CellList":
                    return SheepDogBuilder.createCell((IRow) parent, "");
                case "StepDefinitionList":
                    return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
                case "StepParametersList":
                    return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
                case "LineList":
                    return SheepDogBuilder.createLine((IDescription) parent, "");
                case "TestDataList":
                    return SheepDogBuilder.createTestData((ITestCase) parent, "");
                default:
                    throw new IllegalArgumentException("Unknown element type: " + elementType);
                }
            }
        }
    }

    protected void createNodeDependencies(String part) {
        String[] parts = part.split("/");
        Object current = getDocumentFromNode(cursor);
        int i = 0;

        while (i < parts.length) {
            String elementType = parts[i];

            if (elementType.equals("Table") || elementType.equals("Description")
                    || elementType.equals("NestedDescription")) {
                current = getOrCreateNode(current, elementType, 0);
                i++;
            } else if (elementType.equals("Text") || elementType.equals("CellList")) {
                break;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                if (elementType.equals("TestStepContainerList") && i + 2 < parts.length
                        && parts[i + 2].equals("TestDataList")) {
                    Object container = null;
                    try {
                        container = getChildNode(current, elementType, index);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    if (container instanceof ITestCase) {
                        current = container;
                    } else {
                        current = SheepDogBuilder.createTestCase((ITestSuite) current, "Test Case");
                    }
                } else {
                    current = getOrCreateNode(current, elementType, index);
                }
                i += 2;
            }
        }

        cursor = current;
    }

    protected String getFullNameFromPath() {
        String path = (String) properties.get("path");
        return path.replace("src/test/resources/asciidoc/", "");
    }

    protected void setCursorAtNode(String path) {
        String[] parts = path.split("/");
        Object current = getDocumentFromNode(cursor);

        int i = 0;
        while (i < parts.length && current != null) {
            String elementType = parts[i];

            if (elementType.equals("Table") || elementType.equals("Text")
                    || elementType.equals("Description") || elementType.equals("NestedDescription")) {
                current = getChildNode(current, elementType, 0);
                i++;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                try {
                    current = getChildNode(current, elementType, index);
                } catch (IndexOutOfBoundsException e) {
                    cursor = null;
                    return;
                }
                i += 2;
            }
            if (current != null)
                cursor = current;
        }

    }

    public void transition() {
        if (properties.get("Test Suite Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        } else if (properties.get("Step Object Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Step Object Full Name").toString()));
            properties.remove("Step Object Full Name");
        }
    }

}
