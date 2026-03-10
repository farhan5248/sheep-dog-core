package org.farhan.impl.objects;

import java.util.Arrays;
import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.PhraseFragments;
import org.farhan.dsl.grammar.StepDefinitionRefFragments;
import org.farhan.dsl.grammar.StepDefinitionRefPartTypes;
import org.farhan.dsl.grammar.StepDefinitionRefStateTypes;
import org.farhan.dsl.grammar.StepObjectRefComponentTypes;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.farhan.dsl.grammar.StepObjectRefObjectEdgeTypes;
import org.farhan.dsl.grammar.StepObjectRefObjectVertexTypes;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessGrammarFragmentAsciidocFileImpl extends TestObjectIDE implements ProcessGrammarFragmentAsciidocFile {

    @Override
    public String getPhraseTagFragmentTagList(HashMap<String, String> keyMap) {
        String expected = replaceKeyword(keyMap.get("Tag List"));
        java.util.List<String> actual = PhraseFragments.getTagAsList(properties.get("Line").toString());
        Assertions.assertTrue(actual
                .containsAll(expected.isEmpty() ? Arrays.asList() : Arrays.asList(expected.split(", "))));
        return listToString(actual);
    }

    @Override
    public String getPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        String actual = PhraseFragments.getTodoDesc(properties.get("Line").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Description")), actual);
        return actual;
    }

    @Override
    public String getPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        String actual = PhraseFragments.getTodoType(properties.get("Line").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Type")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String actual = StepDefinitionRefFragments.getPart(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String actual = StepDefinitionRefFragments.getPartDesc(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Description")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String actual = StepDefinitionRefFragments.getPartType(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String partType = StepDefinitionRefFragments.getPartType(stepDefRef);
        String actual = StepDefinitionRefPartTypes.valueOf(partType.toUpperCase()).description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type Description")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String actual = StepDefinitionRefFragments.getState(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("State")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String actual = StepDefinitionRefFragments.getStateDesc(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Description")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String actual = StepDefinitionRefFragments.getStateType(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type")), actual);
        return actual;
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String stateType = StepDefinitionRefFragments.getStateType(stepDefRef);
        String description = Arrays.stream(StepDefinitionRefStateTypes.values()).filter(e -> e.value.equals(stateType))
                .findFirst().orElseThrow().description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type Description")), description);
        return description;
    }

    @Override
    public String getStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getComponent(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getComponentName(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Name")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getComponentType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap) {
        String componentType = StepObjectRefFragments
                .getComponentType(properties.get("Test Step Full Name").toString());
        String actual = StepObjectRefComponentTypes.valueOf(componentType.toUpperCase()).description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type Description")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getObjectEdgeType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectEdgeType(properties.get("Test Step Full Name").toString());
        String actual = StepObjectRefObjectEdgeTypes.valueOf(objectType.toUpperCase()).description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getObject(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getObjectName(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getObjectType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        String actual = StepObjectRefFragments.getObjectVertexType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")), actual);
        return actual;
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectVertexType(properties.get("Test Step Full Name").toString());
        String actual = StepObjectRefObjectVertexTypes.valueOf(objectType.toUpperCase()).description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")), actual);
        return actual;
    }

    @Override
    public void setLineTypeLine(HashMap<String, String> keyMap) {
        properties.put("Line", keyMap.get("Line"));
    }

    @Override
    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap) {
        properties.put("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    @Override
    public void setTestStepTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepObjectRefObjectFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public void setLineTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getPhraseTagFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getPhraseTodoFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepDefinitionRefPartFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepDefinitionRefStateFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepObjectRefComponentFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return cursor == null ? null : cursor.toString();
    }

    private String getStepDefinitionRef() {
        String testStep = properties.get("Test Step Full Name").toString();
        return testStep.substring(StepObjectRefFragments.getAll(testStep).length()).trim();
    }

}
