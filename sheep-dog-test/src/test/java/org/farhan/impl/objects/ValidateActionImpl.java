package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestObjectIDE implements ValidateAction {

    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestObject.cursor instanceof ICell) {
                ICell cell = (ICell) TestObject.cursor;
                if (TestObject.validateDialog == null || TestObject.validateDialog.isEmpty()) {
                    TestObject.validateDialog = CellIssueDetector.validateNameOnly(cell);
                    if (TestObject.validateDialog == null) {
                        TestObject.validateDialog = "";
                    }
                }
            } else if (TestObject.cursor instanceof IRow) {
                IRow row = (IRow) TestObject.cursor;
                if (TestObject.validateDialog == null || TestObject.validateDialog.isEmpty()) {
                    TestObject.validateDialog = RowIssueDetector.validateCellListWorkspace(row);
                    if (TestObject.validateDialog == null) {
                        TestObject.validateDialog = "";
                    }
                }
            } else if (TestObject.cursor instanceof IText) {
                IText text = (IText) TestObject.cursor;
                if (TestObject.validateDialog == null || TestObject.validateDialog.isEmpty()) {
                    TestObject.validateDialog = TextIssueDetector.validateNameWorkspace(text);
                    if (TestObject.validateDialog == null) {
                        TestObject.validateDialog = "";
                    }
                }
            } else if (TestObject.cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) TestObject.cursor;
                if (TestObject.validateDialog == null || TestObject.validateDialog.isEmpty()) {
                    TestObject.validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(testStep);
                    if (TestObject.validateDialog == null) {
                        TestObject.validateDialog = "";
                    }
                    if (TestObject.validateDialog.isEmpty()) {
                        TestObject.validateDialog = TestStepIssueDetector.validateStepDefinitionNameOnly(testStep);
                        if (TestObject.validateDialog == null) {
                            TestObject.validateDialog = "";
                        }
                        if (TestObject.validateDialog.isEmpty()) {
                            TestObject.validateDialog = TestStepIssueDetector
                                    .validateStepObjectNameWorkspace(testStep);
                            if (TestObject.validateDialog == null) {
                                TestObject.validateDialog = "";
                            }
                            if (TestObject.validateDialog.isEmpty()) {
                                TestObject.validateDialog = TestStepIssueDetector
                                        .validateStepDefinitionNameWorkspace(testStep);
                                if (TestObject.validateDialog == null) {
                                    TestObject.validateDialog = "";
                                }
                            }
                        }
                    }
                }
            } else if (TestObject.cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestObject.cursor;
                if (TestObject.validateDialog == null || TestObject.validateDialog.isEmpty()) {
                    TestObject.validateDialog = TestStepContainerIssueDetector
                            .validateTestStepListFile(testStepContainer);
                    if (TestObject.validateDialog == null) {
                        TestObject.validateDialog = "";
                    }
                    if (TestObject.validateDialog.isEmpty()) {
                        TestObject.validateDialog = TestStepContainerIssueDetector
                                .validateNameOnly(testStepContainer);
                        if (TestObject.validateDialog == null) {
                            TestObject.validateDialog = "";
                        }
                    }
                }
            } else if (TestObject.cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) TestObject.cursor;
                if (TestObject.validateDialog == null || TestObject.validateDialog.isEmpty()) {
                    TestObject.validateDialog = TestSuiteIssueDetector.validateNameOnly(testSuite);
                    if (TestObject.validateDialog == null) {
                        TestObject.validateDialog = "";
                    }
                }
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
