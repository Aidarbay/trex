package it.sevenbits.trex;

import it.sevenbits.trex.game.controller.Controls;
import it.sevenbits.trex.game.view.Terminal;
import it.sevenbits.trex.game.model.scenes.GameOverScene;
import it.sevenbits.trex.game.model.scenes.GameScene;
import it.sevenbits.trex.game.model.scenes.TitleScene;
import it.sevenbits.trex.game.controller.lib.Context;
import it.sevenbits.trex.game.controller.lib.SceneManager;

/**
 * Главный класс, точка входа в игру
 */
public class Main {
    private static final long SLEEP_TIME = 35;

    /**
     * Старт нашего приложения
     *
     * @param args - аргументы командной строки
     */
    public static void main(final String[] args) {
        Controls controls = new Controls();
        Context context = new Context(); // создаем контекст на стеке в самом начале приложения
        SceneManager sceneManager = new SceneManager(context); // создаем менеджер сцен на стеке
        Terminal.init(controls);
        Terminal terminal = Terminal.getInstance();

        // Регистрируем сцены в менеджер
        sceneManager.put("title", new TitleScene(context, controls));
        sceneManager.put("game", new GameScene(context, controls));
        sceneManager.put("game_over", new GameOverScene(context, controls));

        // Выставляем текущую сцену
        context.setScene("title");

        // Ждем, пока пользователь не закроет окно
        while (true) {
            terminal.clear();

            if (controls.isExit()) {
                break;
            }

            sceneManager.onRender();
            controls.resetControl();
            terminal.repaint();

            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        terminal.dispose();
    }
}
