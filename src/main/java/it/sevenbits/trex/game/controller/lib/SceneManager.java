package it.sevenbits.trex.game.controller.lib;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private final Map<String, IScene> scenes;
    private final Context context;
    private String currentScene;

    public SceneManager(final Context context) {
        this.context = context;
        this.scenes = new HashMap<>();
    }

    public void onRender() {
        if (!context.getScene().equals(currentScene)) {
            System.out.println("Transition from '" + context.getScene() + "' to '" + currentScene + "'");
            if (scenes.containsKey(currentScene)) {
                scenes.get(currentScene).onExit();
            }
            currentScene = context.getScene();
            scenes.get(currentScene).onCreate();
        }
        if (scenes.containsKey(currentScene)) {
            scenes.get(currentScene).onRender();
        } else {
            System.out.println("[WARNING] Can't update scene '" + currentScene + "': it doesn't exist.");
        }
    }

    public void onExit() {
        if (scenes.containsKey(currentScene)) {
            scenes.get(currentScene).onExit();
        }
    }

    public Context getContext() {
        return context;
    }

    public String getCurrentScene() {
        return currentScene;
    }

    /**
     * Функция для добавления новой сцены в менеджер
     *
     * @param name  имя сцены
     * @param scene указатель на сцену
     */
    public void put(final String name, final IScene scene) {
        scenes.put(name, scene);
    }
}
