package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> listButtons = new ArrayList<>();
    private final int size;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            listButtons.add(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return new ArrayList<>(listButtons);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> enableList = new ArrayList<>(this.size);
        for (final int elem : listButtons) {
            enableList.add(elem != this.size);
        }
        return enableList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        final int nextElem = listButtons.get(elem) + 1;
        listButtons.set(elem, nextElem);
        return nextElem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return listButtons.stream().map(String::valueOf).collect(Collectors.joining("|", "<<", ">>"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        boolean quit = false;
        for (int i = 0; i < size - 1; i++) {
            if (listButtons.get(i).equals(listButtons.get(i + 1)) && listButtons.get(i) >= 1) {
                quit = true;
            } else {
                return false;
            }
        }
        return quit;
    }
}
