package it.sevenbits.trex.game.view;

import asciiPanel.AsciiPanel;
import it.sevenbits.trex.game.controller.Controls;

import javax.swing.JFrame;

/**
 * Класс терминала
 */
public final class Terminal extends JFrame {
    private static Terminal terminal = null;
    private final AsciiPanel asciiPanel = new AsciiPanel();

    private Terminal(final Controls controls) {
        super();
        this.add(asciiPanel);
        this.addKeyListener(controls);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void init(final Controls controls) {
        if (terminal == null) {
            terminal = new Terminal(controls);
        }
    }

    public static Terminal getInstance() {
        if (terminal == null) {
            throw new RuntimeException("Terminal wasn't initialize");
        }
        return terminal;
    }

    public void clear() {
        asciiPanel.clear();
    }

    public void write(final String string, final int x, final int y) {
        asciiPanel.write(string, x, y);
    }

    public void write(final char symbol, final int x, final int y) {
        asciiPanel.write(symbol, x, y);
    }
}
