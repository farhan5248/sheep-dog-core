package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.StepObjectRefFragments;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestStepIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepObjectNameOnly");

        if (theTestStep != null) {
            String stepObjectName = theTestStep.getStepObjectName();
            if (stepObjectName == null || stepObjectName.isEmpty()) {
                logger.debug("Exiting validateStepObjectNameOnly");
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            }
        }

        logger.debug("Exiting validateStepObjectNameOnly");
        return "";
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepDefinitionNameOnly(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepDefinitionNameOnly");

        if (theTestStep != null) {
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
                logger.debug("Exiting validateStepDefinitionNameOnly");
                return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
            }
        }

        logger.debug("Exiting validateStepDefinitionNameOnly");
        return "";
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepObjectNameWorkspace");
        String message = "";

        if (theTestStep != null && theTestStep.getStepObjectName() != null
                && !theTestStep.getStepObjectName().isEmpty()) {
            // Get the step object name
            String stepObjectName = theTestStep.getStepObjectName();

            // Extract component and object
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);

            // Only validate if we have both component and object
            if (!component.isEmpty() && !object.isEmpty()) {
                // Navigate to the project
                ITestStepContainer container = theTestStep.getParent();
                if (container != null) {
                    ITestSuite suite = container.getParent();
                    if (suite != null) {
                        ITestProject project = suite.getParent();
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
                            if (stepObject == null) {
                                message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateStepObjectNameWorkspace");
        return message;
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepDefinitionNameWorkspace");
        String message = "";

        if (theTestStep != null && theTestStep.getStepObjectName() != null
                && !theTestStep.getStepObjectName().isEmpty() && theTestStep.getStepDefinitionName() != null
                && !theTestStep.getStepDefinitionName().isEmpty()) {
            // Get the step object name and step definition name
            String stepObjectName = theTestStep.getStepObjectName();
            String stepDefinitionName = theTestStep.getStepDefinitionName();

            // Extract component and object
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);

            // Only validate if we have both component and object
            if (!component.isEmpty() && !object.isEmpty()) {
                // Navigate to the project
                ITestStepContainer container = theTestStep.getParent();
                if (container != null) {
                    ITestSuite suite = container.getParent();
                    if (suite != null) {
                        ITestProject project = suite.getParent();
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
                                // Check if the step definition exists in the step object
                                if (stepObject.getStepDefinition(stepDefinitionName) == null) {
                                    message = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return message;
    }

}
