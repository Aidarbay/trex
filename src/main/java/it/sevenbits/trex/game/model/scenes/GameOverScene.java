package it.sevenbits.trex.game.model.scenes;

import it.sevenbits.trex.game.controller.Controls;
import it.sevenbits.trex.game.view.Terminal;
import it.sevenbits.trex.game.controller.lib.Context;
import it.sevenbits.trex.game.controller.lib.IScene;

public class GameOverScene implements IScene {
    private final Context context;
    private final Controls controls;

    public GameOverScene(final Context context, final Controls controls) {
        this.context = context;
        this.controls = controls;
    }

    @Override
    public void onCreate() {}

    @Override
    public void onRender() {
        Terminal.getInstance().write("Game over", 0, 0);
        Terminal.getInstance().write("Score is ?", 0, 1);
        Terminal.getInstance().write("Press Enter to go to main menu", 0, 2);
        if (controls.isSubmit()) {
            context.setScene("title");
        }
    }

    @Override
    public void onExit() {}
}
