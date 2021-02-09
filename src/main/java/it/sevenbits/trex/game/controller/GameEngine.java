package it.sevenbits.trex.game.controller;

import it.sevenbits.trex.game.controller.lib.SceneManager;
import it.sevenbits.trex.game.model.Ground;
import it.sevenbits.trex.game.model.Player;
import it.sevenbits.trex.game.view.SceneRenderer;

import java.awt.event.KeyEvent;

public class GameEngine {
    private SceneRenderer renderer;
    private SceneManager sceneManager;
    private Player player;
    private ObstacleManager obstacleManager;
    private Ground ground;
    private boolean isExit = false;
    public GameEngine() {

    }
    public void handleEvent(final KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if(sceneManager.getCurrentScene().equals("game")) {

                }
                break;
            case KeyEvent.VK_ESCAPE:
                this.isExit = true;
                break;
            case KeyEvent.VK_ENTER:
                if(sceneManager.getCurrentScene().equals("game_over")) {
                    sceneManager.getContext().setScene("title");
                } else if (sceneManager.getCurrentScene().equals("title")) {
                    sceneManager.getContext().setScene("game");
                }
                break;
            default:
                break;
        }
    }
}
