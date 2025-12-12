package it.unibo.es2;

/**
 * Interface that define the logic.
 */
public interface Logics {

    /**
     * Hits the cell at the given row and column.
     *
     * @param row the row index
     * @param col the column index
     * @return true if the cell was not hit before, false otherwise
     */
    boolean hit(int row, int col);

    /**
     * Checks if any row is fully hit.
     *
     * @return true if any row is full, false otherwise
     */
    boolean isAnyRowFull();

    /**
     * Checks if any column is fully hit.
     *
     * @return true if any column is full, false otherwise
     */
    boolean isAnyColumnFull();
}
