package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 11/12/16.
 */
public class CompletedGameStage extends Stage {
    public CompletedGameStage(final Viewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);
        
        Dynamic.AssetManager.loadWinGameAssets();
        Dynamic.AssetManager.finishLoading();
        
        Background background = new Background(Dynamic.AssetManager.get("backgrounds/winGameBackgroundTexture", Texture.class));

        // TODO: Show spec of the game

        Image buttonNextLevel = new Image(Dynamic.AssetManager.get("buttons/nextLevel.png", Texture.class));
        Image buttonMenu = new Image(Dynamic.AssetManager.get("buttons/menu.png", Texture.class));

        buttonNextLevel.setSize(buttonNextLevel.getWidth()/4, buttonNextLevel.getHeight()/4);
        buttonMenu.setSize(buttonMenu.getWidth()/4, buttonMenu.getHeight()/4);

        buttonNextLevel.setOrigin(buttonNextLevel.getWidth()/2, buttonNextLevel.getHeight()/2);
        buttonMenu.setOrigin(buttonMenu.getWidth()/2, buttonMenu.getHeight()/2);

        buttonNextLevel.setPosition((getWidth()/2)-buttonNextLevel.getWidth()/2, (getHeight()/2)-getHeight()/8);
        buttonMenu.setPosition((getWidth()/2)-buttonMenu.getWidth()/2, (getHeight()/2)-getHeight()/4);

        buttonNextLevel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Dynamic.currentLevel++;
                Dynamic.currentStage = new GameStage(Constants.viewport);
            }
        });
        buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Dynamic.currentStage = new MenuStage(Constants.viewport);
            }
        });

        addActor(background);
        addActor(buttonNextLevel);
        addActor(buttonMenu);
    }
}
