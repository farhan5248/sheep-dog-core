package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class CellIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theCell the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameOnly(ICell theCell) throws Exception {
        logger.debug("Entering validateNameOnly");
        String name = theCell.getName();

        // Header row cells must start with capital, body row cells can be any case
        boolean isHeaderRow = isHeaderRow(theCell);

        if (name != null && !name.isEmpty()) {
            if (isHeaderRow && !Character.isUpperCase(name.charAt(0))) {
                logger.debug("Exiting validateNameOnly");
                return CellIssueTypes.CELL_NAME_ONLY.description;
            }
        }
        logger.debug("Exiting validateNameOnly");
        return "";
    }

    /**
     * Determines if a cell is in the header row of its table.
     * The header row is the first row in the table.
     *
     * @param theCell the cell to check
     * @return true if the cell is in the header row, false otherwise
     */
    private static boolean isHeaderRow(ICell theCell) {
        if (theCell == null) {
            return false;
        }
        var row = theCell.getParent();
        if (row == null) {
            return false;
        }
        var table = row.getParent();
        if (table == null) {
            return false;
        }
        var rowList = table.getRowList();
        if (rowList == null || rowList.isEmpty()) {
            return false;
        }
        // Header row is the first row (index 0)
        return row == rowList.get(0);
    }
}
