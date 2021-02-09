package it.sevenbits.trex.game.model.scenes;

import it.sevenbits.trex.game.controller.Controls;
import it.sevenbits.trex.game.model.Ground;
import it.sevenbits.trex.game.controller.ObstacleManager;
import it.sevenbits.trex.game.model.Player;
import it.sevenbits.trex.game.controller.lib.Context;
import it.sevenbits.trex.game.controller.lib.IScene;

public class GameScene implements IScene {
    private static final int WIDTH = 80;
    private static final int GROUND_Y = 15;
    private static final double GRAVITY = 0.3;
    private static final double GRAVITY_MULTIPLIER = 3.0;
    private static final int START_PLAYER_X = 2;
    private static final double MAX_JUMP_HEIGHT = 5;
    private static final double OBSTACLE_SPEED = 0.1;

    private final Controls controls;
    private final Context context;
    private Ground ground;
    private Player player;
    private ObstacleManager obstacleManager;

    public GameScene(final Context context, final Controls controls) {
        this.context = context;
        this.controls = controls;
    }

    @Override
    public void onCreate() {
        ground = new Ground('^', WIDTH, GROUND_Y);
        player = new Player(controls, START_PLAYER_X, GROUND_Y - 1, GROUND_Y - 1, MAX_JUMP_HEIGHT, GRAVITY * GRAVITY_MULTIPLIER, GRAVITY);
        obstacleManager = new ObstacleManager(player, GROUND_Y - 1, WIDTH, OBSTACLE_SPEED);
    }

    @Override
    public void onRender() {
        obstacleManager.update();
        if (obstacleManager.isHit()) {
            context.setScene("game_over");
            return;
        }
        player.update();
        ground.update();
    }

    @Override
    public void onExit() {}
}
