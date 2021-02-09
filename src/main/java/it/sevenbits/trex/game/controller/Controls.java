package it.sevenbits.trex.game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Класс для обработки упрвления
 */
public class Controls implements KeyListener {
    private boolean isJump = false;
    private boolean isExit = false;
    private boolean isSubmit = false;

    /**
     * Геттер для флага isJump
     *
     * @return возвращает значение флага isJump
     */
    public boolean isJump() {
        return this.isJump;
    }

    /**
     * Геттер для флага isExit
     *
     * @return возвращает значение флага isExit
     */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Геттер для флага isSubmit
     *
     * @return возвращает значение флага isSubmit
     */
    public boolean isSubmit() {
        return this.isSubmit;
    }

    /**
     * Сброс флагов нажатых клавиш
     */
    public void resetControl() {
        this.isJump = false;
        this.isExit = false;
        this.isSubmit = false;
    }

    /**
     * Функция обработки события нажатой клавиши
     *
     * @param keyEvent - событие, нажатой клавиши
     */
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                this.isJump = true;
                break;
            case KeyEvent.VK_ESCAPE:
                this.isExit = true;
                break;
            case KeyEvent.VK_ENTER:
                this.isSubmit = true;
                break;
            default:
                break;
        }
    }

    /**
     * Функция обработки события ввода с клавиши
     *
     * @param keyEvent - событие, ввода с клавиши
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
    }

    /**
     * Функция обработки события отпуска клавиши
     *
     * @param keyEvent - событие, отпуска клавиши
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }
}
