package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<JButton, Pair<Integer, Integer>> cells = new HashMap<>();
    private final Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.logics = new LogicsImpl(width);
        // Create a panel with a grid layout
        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JPanel panel = new JPanel(new GridLayout(width, width));
        mainPanel.add(panel, BorderLayout.CENTER);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final JButton button = new JButton(" ");
                this.cells.put(button, new Pair<>(j, i));
                panel.add(button);
            }
        }
        this.updateView();

        final JButton expand = new JButton(">");
        mainPanel.add(expand, BorderLayout.SOUTH);
        expand.addActionListener(e -> {
            logics.advance();
            this.updateView();
            if (logics.exit()) {
                dispose();
            }
        });
        this.getContentPane().add(mainPanel);
        pack();
        this.setVisible(true);
    }

    private void updateView() {
        final Set<Pair<Integer, Integer>> position = logics.position();
        cells.forEach((p, p2) -> p.setText(position.contains(p2) ? "*" : " "));
    }
}
