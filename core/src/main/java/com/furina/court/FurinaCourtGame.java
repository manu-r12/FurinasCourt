package com.furina.court;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.furina.court.screens.MenuScreen;

/**
 * Main game class for Furina Court.
 * Extends {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class FurinaCourtGame extends ApplicationAdapter {
    private Screen currentScreen;

    @Override
    public void create() {
        currentScreen = new MenuScreen(this);
        currentScreen.show();
    }

    @Override
    public void render() {
        if (currentScreen != null) {
            currentScreen.render(1f / 60f);
        }
    }

    @Override
    public void resize(int width, int height) {
        if (currentScreen != null) {
            currentScreen.resize(width, height);
        }
    }

    @Override
    public void dispose() {
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

    public void setScreen(Screen screen) {
        if (currentScreen != null) {
            currentScreen.dispose();
        }
        currentScreen = screen;
        if (currentScreen != null) {
            currentScreen.show();
        }
    }
}