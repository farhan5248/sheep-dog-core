package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObjectIDE implements InputFileAsciidocFile {

    @Override
    public String getCellListNodeCellName(HashMap<String, String> keyMap) {
        return assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public String getCellListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertDescriptionEmpty();
        }
        return keyMap.get("State");
    }

    @Override
    public String getLineListNodeLineContent(HashMap<String, String> keyMap) {
        return assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public String getLineListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getNestedDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getNestedDescriptionNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertDescriptionEmpty();
        }
        return keyMap.get("State");
    }

    @Override
    public String getStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getStepDefinitionListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            assertStepDefinitionListEmpty();
        } else if (keyMap.get("State").contentEquals("Absent")) {
            Assertions.assertNull(cursor);
        }
        return keyMap.get("State");
    }

    @Override
    public String getStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        return assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public String getStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getStepParametersListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            assertStepParametersListEmpty();
        } else if (keyMap.get("State").contentEquals("Absent")) {
            Assertions.assertNull(cursor);
        }
        return keyMap.get("State");
    }

    @Override
    public String getStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        return assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return "Present";
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTableAbsent();
        } else if (keyMap.get("State").contentEquals("Present")) {
            assertTablePresent();
        }
        return keyMap.get("State");
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setLineListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepDefinitionName(HashMap<String, String> keyMap) {
        return assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public String getStepParametersName(HashMap<String, String> keyMap) {
        return assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public void setCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public void setLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public String getNestedDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public void setStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepDefinitionListNodeAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public String getStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public void setStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepParametersListNodeAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }

    @Override
    public String getStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "Present";
    }
}
