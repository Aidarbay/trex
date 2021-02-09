package it.sevenbits.trex.game.model;

import it.sevenbits.trex.game.view.Terminal;

/**
 * Класс описывающий препятствие
 */
public class Obstacle {
    /**
     * Константа, которая отвечает за символ препятствия
     */
    public static final char SYMBOL = '#';

    private int x;
    private int y;

    /**
     * Конструктор класса препятствий
     *
     * @param x - координаты х
     * @param y - координаты у
     */
    public Obstacle(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Функция обновления состояния препятствия, сейчас состоит только из перерисовки
     */
    public void update() {
        Terminal.getInstance().write(SYMBOL, x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }
}
