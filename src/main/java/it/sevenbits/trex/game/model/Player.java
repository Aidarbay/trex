package it.sevenbits.trex.game.model;

import it.sevenbits.trex.game.controller.Controls;
import it.sevenbits.trex.game.view.Terminal;

/**
 * Класс, описывающий модель Игрок
 */
public class Player {
    /**
     * Константа, которая отвечает за символ игрока
     */
    public static final char SYMBOL = '@';

    private double speedY = 0;
    private final Controls control;
    private final int x;
    private double y;
    private final int groundY;
    private final double maxJumpHeight;
    private final double maxSpeedY;
    private final double gravity;

    /**
     * Конструктор класса Player
     *
     * @param control       - класс управления
     * @param x             - координаты по х
     * @param y             - координаты по у
     * @param groundY       - высота на которой находится земля для игрока
     * @param maxJumpHeight - макисмальная высота прыжка
     * @param maxSpeedY     - скорость взлета игрока после прыжка
     * @param gravity       - гравитация
     */
    public Player(final Controls control,
           final int x,
           final double y,
           final int groundY,
           final double maxJumpHeight,
           final double maxSpeedY,
           final double gravity) {
        this.x = x;
        this.y = y;
        this.control = control;
        this.groundY = groundY;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSpeedY = maxSpeedY;
        this.gravity = gravity;
    }

    /**
     * Проверка на нахождение игрока в воздухе
     *
     * @return true, если игрок в воздухе, иначе false
     */
    private boolean isFlying() {
        return y < groundY;
    }

    /**
     * Функция обработки движений игроком
     */
    private void move() {
        if (control.isJump() && !isFlying()) {
            speedY = maxSpeedY;
        }
        if (y >= groundY) {
            y = groundY;
        }
        if (y <= groundY - maxJumpHeight) {
            speedY = 0;
        }
        y -= speedY;
        y += gravity;
    }

    /**
     * Функция отображения игрока игроком
     */
    private void render() {
        Terminal.getInstance().write(SYMBOL, x, (int) y);
    }

    /**
     * Функция обновления состояния игрока
     */
    public void update() {
        move();
        render();
    }

    /**
     * Геттер для координаты x
     *
     * @return координату x игрока
     */
    public int getX() {
        return this.x;
    }

    /**
     * Геттер для координаты y
     *
     * @return координату y игрока
     */
    public int getY() {
        return (int) this.y;
    }
}
