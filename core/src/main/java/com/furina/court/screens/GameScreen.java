package com.furina.court.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.furina.court.FurinaCourtGame;

/**
 * Game screen displaying the sky blue water.
 */
public class GameScreen implements Screen {
    private final FurinaCourtGame game;
    private final ShapeRenderer shapeRenderer;

    public GameScreen(FurinaCourtGame game) {
        this.game = game;
        this.shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        
        // Draw sky blue water
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0.53f, 0.81f, 0.92f, 1f); // Sky blue color
        shapeRenderer.rect(0, 0, 800, 600); // Full screen water
        shapeRenderer.end();
        
        // Press ESC to return to menu
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
