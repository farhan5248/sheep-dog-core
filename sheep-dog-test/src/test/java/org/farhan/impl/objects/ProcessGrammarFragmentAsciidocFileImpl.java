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
        Assertions.assertTrue(PhraseFragments.getTagAsList(properties.get("Line").toString())
                .containsAll(expected.isEmpty() ? Arrays.asList() : Arrays.asList(expected.split(", "))));
        return "";
    }

    @Override
    public String getPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Description")),
                PhraseFragments.getTodoDesc(properties.get("Line").toString()));
        return "";
    }

    @Override
    public String getPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Type")),
                PhraseFragments.getTodoType(properties.get("Line").toString()));
        return "";
    }

    @Override
    public String getStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part")), StepDefinitionRefFragments.getPart(stepDefRef));
        return "";
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Description")),
                StepDefinitionRefFragments.getPartDesc(stepDefRef));
        return "";
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type")),
                StepDefinitionRefFragments.getPartType(stepDefRef));
        return "";
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String partType = StepDefinitionRefFragments.getPartType(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type Description")),
                StepDefinitionRefPartTypes.valueOf(partType.toUpperCase()).description);
        return "";
    }

    @Override
    public String getStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State")), StepDefinitionRefFragments.getState(stepDefRef));
        return "";
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Description")),
                StepDefinitionRefFragments.getStateDesc(stepDefRef));
        return "";
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type")),
                StepDefinitionRefFragments.getStateType(stepDefRef));
        return "";
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String stateType = StepDefinitionRefFragments.getStateType(stepDefRef);
        String description = Arrays.stream(StepDefinitionRefStateTypes.values()).filter(e -> e.value.equals(stateType))
                .findFirst().orElseThrow().description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type Description")), description);
        return "";
    }

    @Override
    public String getStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component")),
                StepObjectRefFragments.getComponent(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Name")),
                StepObjectRefFragments.getComponentName(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type")),
                StepObjectRefFragments.getComponentType(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap) {
        String componentType = StepObjectRefFragments
                .getComponentType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type Description")),
                StepObjectRefComponentTypes.valueOf(componentType.toUpperCase()).description);
        return "";
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectEdgeType(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectEdgeType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")),
                StepObjectRefObjectEdgeTypes.valueOf(objectType.toUpperCase()).description);
        return "";
    }

    @Override
    public String getStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object")),
                StepObjectRefFragments.getObject(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")),
                StepObjectRefFragments.getObjectName(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectType(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectVertexType(properties.get("Test Step Full Name").toString()));
        return "";
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectVertexType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")),
                StepObjectRefObjectVertexTypes.valueOf(objectType.toUpperCase()).description);
        return "";
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
        return "";
    }

    @Override
    public String getStepObjectRefObjectFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    @Override
    public void setLineTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getPhraseTagFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    @Override
    public String getPhraseTodoFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    @Override
    public String getStepDefinitionRefPartFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    @Override
    public String getStepDefinitionRefStateFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    @Override
    public String getStepObjectRefComponentFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }

    private String getStepDefinitionRef() {
        String testStep = properties.get("Test Step Full Name").toString();
        return testStep.substring(StepObjectRefFragments.getAll(testStep).length()).trim();
    }

}
