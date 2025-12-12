package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the logic interface.
 */
public class LogicsImpl implements Logics {

    private final List<List<Boolean>> list = new ArrayList<>();

    /**
     * @param size number of rows / cols
     */
    public LogicsImpl(final int size) {
       for (int i = 0; i < size; i++) {
            final List<Boolean> row = new ArrayList<>();
            this.list.add(row);
            for (int j = 0; j < size; j++) {
                row.add(false);
            }
       }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hit(final int row, final int col) {
        final Boolean val = list.get(row).get(col);
        this.list.get(row).set(col, !val);
        return !val;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnyRowFull() {
        return this.list.stream().anyMatch(l -> l.stream().allMatch(a -> a));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnyColumnFull() {
        for (int col = 0; col < list.size(); col++) {
            boolean full = true;
            for (final List<Boolean> row : list) {
                if (!row.get(col)) {
                    full = false;
                    break;
                }
            }
            if (full) {
                return true;
            }
        }
        return false;
    }

}
