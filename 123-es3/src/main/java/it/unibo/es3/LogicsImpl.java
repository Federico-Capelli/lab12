package it.unibo.es3;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Logic implementation.
 */
public class LogicsImpl implements Logics, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final Random RANDOM = new Random();

    private final int size;
    private final Set<Pair<Integer, Integer>> set = new HashSet<>();

    /**
     * @param size the size of the grid
     */
    public LogicsImpl(final int size) {
        this.size = size;
        while (set.size() < 3) {
            this.set.add(new Pair<>(RANDOM.nextInt(size), RANDOM.nextInt(size)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exit() {
        return this.set.size() == this.size * this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Pair<Integer, Integer>> position() {
        return new HashSet<>(set);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void advance() {
       final Set<Pair<Integer, Integer>> s = new HashSet<>();
       for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final var p = new Pair<>(i, j);
                if (set.stream().anyMatch(p2 -> neighbor(p, p2))) {
                    s.add(p);
                }
            }
        }
        set.addAll(s);
    }

    private boolean neighbor(final Pair<Integer, Integer> p, final Pair<Integer, Integer> p2) {
        final int dx = Math.abs(p.x() - p2.x());
        final int dy = Math.abs(p.y() - p2.y());

        return dx <= 1 && dy <= 1 && dx + dy != 0;
    }

}
