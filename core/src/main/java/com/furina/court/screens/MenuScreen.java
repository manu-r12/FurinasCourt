package com.furina.court.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.furina.court.FurinaCourtGame;

/**
 * Menu screen with Start and Settings options.
 */
public class MenuScreen implements Screen {
    private final FurinaCourtGame game;
    private final ShapeRenderer shapeRenderer;
    private final SpriteBatch batch;
    private final BitmapFont font;
    
    private Button startButton;
    private Button settingsButton;

    public MenuScreen(FurinaCourtGame game) {
        this.game = game;
        this.shapeRenderer = new ShapeRenderer();
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        
        // Initialize buttons
        this.startButton = new Button(250, 300, 300, 80, "Start");
        this.settingsButton = new Button(250, 150, 300, 80, "Settings");
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        
        // Draw background
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0.2f, 0.2f, 0.3f, 1f);
        shapeRenderer.rect(0, 0, 800, 600);
        shapeRenderer.end();
        
        // Handle input
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.graphics.getHeight() - Gdx.input.getY();
            
            if (startButton.isClicked(x, y)) {
                game.setScreen(new GameScreen(game));
            } else if (settingsButton.isClicked(x, y)) {
                // Settings functionality can be added later
                System.out.println("Settings clicked");
            }
        }
        
        // Draw buttons
        batch.begin();
        startButton.draw(batch, shapeRenderer, font);
        settingsButton.draw(batch, shapeRenderer, font);
        batch.end();
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
        batch.dispose();
        font.dispose();
    }

    /**
     * Simple button class for menu buttons.
     */
    private static class Button {
        float x, y, width, height;
        String label;
        boolean hovered;

        Button(float x, float y, float width, float height, String label) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.label = label;
        }

        boolean isClicked(float mouseX, float mouseY) {
            return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
        }

        void draw(SpriteBatch batch, ShapeRenderer shapeRenderer, BitmapFont font) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(0.3f, 0.5f, 0.8f, 1f);
            shapeRenderer.rect(x, y, width, height);
            shapeRenderer.end();
            
            // Draw border
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(0.8f, 0.8f, 0.8f, 1f);
            shapeRenderer.rect(x, y, width, height);
            shapeRenderer.end();
            
            // Draw text
            font.setColor(Color.WHITE);
            GlyphLayout layout = new GlyphLayout(font, label);
            font.draw(batch, label, x + width / 2 - layout.width / 2, y + height / 2 + layout.height / 2);
        }
    }
}
