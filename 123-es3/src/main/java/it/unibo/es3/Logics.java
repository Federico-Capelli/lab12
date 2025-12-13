package it.unibo.es3;

import java.util.Set;

/**
 * Logic interface.
 */
public interface Logics {

    /**
     * @return true if game is over
     */
    boolean exit();

    /**
     * Advance the game.
     */
    void advance();

    /**
     * @return the position of the cells that are active
     */
    Set<Pair<Integer, Integer>> position();

}
