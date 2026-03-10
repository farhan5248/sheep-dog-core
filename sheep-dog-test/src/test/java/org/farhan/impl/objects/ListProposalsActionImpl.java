package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectIDE implements ListProposalsAction {

    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestObject.cursor instanceof IRow) {
                IRow row = (IRow) TestObject.cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                TestObject.listProposalsDialog
                        .addAll(RowIssueResolver.suggestCellListWorkspace((ITestStep) testStep));
            } else if (TestObject.cursor instanceof ITestStep) {
                TestObject.listProposalsDialog
                        .addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) TestObject.cursor));
                TestObject.listProposalsDialog.addAll(
                        TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) TestObject.cursor));
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        properties.put("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    }
}
