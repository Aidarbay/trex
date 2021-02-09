package it.sevenbits.trex.game.model;

import it.sevenbits.trex.game.view.Terminal;

/**
 * Клаа, описывающий модель земли
 */
public class Ground {
    private final char symbol;
    private final int width;
    private final int y;

    /**
     * Конструктор для класса земли
     *
     * @param symbol - сиволм отвечающий за землю
     * @param width  - щирина земли
     * @param y      - высота на которой расположена земля
     */
    public Ground(final char symbol, final int width, final int y) {
        this.symbol = symbol;
        this.width = width;
        this.y = y;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    /**
     * Фукнция обновления состояния земли, пока состоит только из вывода на экран
     */
    public void update() {
        for (int i = 0; i < width; i++) {
            Terminal.getInstance().write(symbol, i, y);
        }
    }
}
