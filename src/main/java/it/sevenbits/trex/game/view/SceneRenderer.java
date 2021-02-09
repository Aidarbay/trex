package it.sevenbits.trex.game.view;

import it.sevenbits.trex.game.controller.lib.SceneManager;

public class SceneRenderer {

    private final SceneManager sceneManager;

    public SceneRenderer(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public void render() {
        if(sceneManager.getCurrentScene().equals("title")) {
            Terminal.getInstance().write("Trex Game", 0, 0);
            Terminal.getInstance().write("Press Enter to start", 0, 1);
        } else if (sceneManager.getCurrentScene().equals("game")) {

        } else if (sceneManager.getCurrentScene().equals("game_over")) {
            Terminal.getInstance().write("Game over", 0, 0);
            Terminal.getInstance().write("Score is ?", 0, 1);
            Terminal.getInstance().write("Press Enter to go to main menu", 0, 2);
        }
    }
}
