package it.sevenbits.trex.game.controller;

import it.sevenbits.trex.game.model.Obstacle;
import it.sevenbits.trex.game.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс менеджер препятствий
 */
public class ObstacleManager {
    private final Player player;
    private final List<Obstacle> obstacles;
    private final int worldWidth;
    private final double speedX;
    private boolean isHit = false;

    /**
     * Конструктор для менеджера препятсвий
     *
     * @param player     - объект игрока
     * @param groundY    - высота земли
     * @param worldWidth - ширина мира
     * @param speedX     - скорость игрока по x
     */
    public ObstacleManager(final Player player, final int groundY, final int worldWidth, final double speedX) {
        this.player = player;
        this.worldWidth = worldWidth;
        this.speedX = speedX;

        final int firstObstacleX = 30;
        final int secondObstacleX = 55;
        final int thirdObstacleX = 70;
        obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(firstObstacleX, groundY));
        obstacles.add(new Obstacle(secondObstacleX, groundY));
        obstacles.add(new Obstacle(thirdObstacleX, groundY));
    }

    /**
     * Функция обновления состояния препятсвий
     */
    public void update() {
        for (Obstacle o : obstacles) {
            o.setX((int) (o.getX() - speedX));
            if (o.getX() <= 0) {
                o.setX(worldWidth - 1);
            }
            if (player.getX() == o.getX() && player.getY() == o.getY()) {
                isHit = true;
            }
            o.update();
        }
    }

    public boolean isHit() {
        return isHit;
    }
}
