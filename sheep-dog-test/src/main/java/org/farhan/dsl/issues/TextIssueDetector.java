package org.farhan.dsl.issues;

import java.util.List;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepObjectRefFragments;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TextIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theText the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameWorkspace(IText theText) throws Exception {
        logger.debug("Entering validateNameWorkspace");
        String message = "";

        if (theText != null) {
            // Get the parent test step
            ITestStep testStep = theText.getParent();
            if (testStep != null) {
                String stepObjectName = testStep.getStepObjectName();
                String stepDefinitionName = testStep.getStepDefinitionName();

                // Only validate if we have both step object and step definition names
                if (stepObjectName != null && !stepObjectName.isEmpty() && stepDefinitionName != null
                        && !stepDefinitionName.isEmpty()) {
                    // Extract component and object
                    String component = StepObjectRefFragments.getComponent(stepObjectName);
                    String object = StepObjectRefFragments.getObject(stepObjectName);

                    // Only validate if we have both component and object
                    if (!component.isEmpty() && !object.isEmpty()) {
                        ITestProject project = SheepDogUtility.getTestProjectParentForText(theText);
                        if (project != null) {
                            // Get the file extension
                            String fileExt = project.getFileExtension();

                            // Build the qualified name
                            String qualifiedName = component + "/" + object;
                            if (fileExt != null && !fileExt.isEmpty()) {
                                qualifiedName += fileExt;
                            }

                            // Check if the step object exists
                            IStepObject stepObject = project.getStepObject(qualifiedName);
                            if (stepObject != null) {
                                // Check if the step definition exists
                                IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                                if (stepDefinition != null) {
                                    // Get the step parameters
                                    List<IStepParameters> parameterList = stepDefinition.getStepParameterList();

                                    // Check if there's a "Content" parameter
                                    boolean hasContentParameter = false;
                                    for (IStepParameters param : parameterList) {
                                        if ("Content".equals(param.getName())) {
                                            hasContentParameter = true;
                                            break;
                                        }
                                    }

                                    if (!hasContentParameter) {
                                        message = TextIssueTypes.TEXT_NAME_WORKSPACE.description;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateNameWorkspace");
        return message;
    }
}
