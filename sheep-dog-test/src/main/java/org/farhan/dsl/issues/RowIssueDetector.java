package org.farhan.dsl.issues;

import java.util.List;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
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
public class RowIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theRow the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateCellListWorkspace(IRow theRow) throws Exception {
        logger.debug("Entering validateCellListWorkspace");
        String message = "";

        if (theRow != null) {
            // Get the table containing this row
            ITable table = theRow.getParent();
            if (table != null) {
                // Get the test step containing the table
                Object parent = table.getParent();
                if (parent instanceof ITestStep) {
                    ITestStep testStep = (ITestStep) parent;
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
                            ITestProject project = SheepDogUtility.getTestProjectParentForRow(theRow);
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

                                        // Get the header row (first row in table)
                                        List<IRow> rowList = table.getRowList();
                                        if (rowList != null && !rowList.isEmpty()) {
                                            IRow headerRow = rowList.get(0);

                                            // Check if header row cell names match step parameter names
                                            List<ICell> headerCells = headerRow.getCellList();
                                            if (headerCells != null && !parameterList.isEmpty()) {
                                                // Check if all header cells have corresponding parameters
                                                for (ICell headerCell : headerCells) {
                                                    String cellName = headerCell.getName();
                                                    if (cellName != null && !cellName.isEmpty()) {
                                                        boolean found = false;
                                                        for (IStepParameters param : parameterList) {
                                                            if (cellName.equals(param.getName())) {
                                                                found = true;
                                                                break;
                                                            }
                                                        }
                                                        if (!found) {
                                                            message = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateCellListWorkspace");
        return message;
    }

}
