package it.sevenbits.trex.game.model.scenes;

import it.sevenbits.trex.game.controller.Controls;
import it.sevenbits.trex.game.view.Terminal;
import it.sevenbits.trex.game.controller.lib.Context;
import it.sevenbits.trex.game.controller.lib.IScene;

public class TitleScene implements IScene {
    private final Context context;
    private final Controls controls;

    public TitleScene(final Context context, final Controls controls) {
        this.context = context;
        this.controls = controls;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onRender() {
        Terminal.getInstance().write("Trex Game", 0, 0);
        Terminal.getInstance().write("Press Enter to start", 0, 1);
        if (controls.isSubmit()) {
            context.setScene("game");
        }
    }

    @Override
    public void onExit() {
    }
}
