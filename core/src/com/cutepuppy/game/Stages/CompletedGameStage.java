package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

/*
 * Created by jeffbustercase on 11/12/16.
 */
public class CompletedGameStage extends Stage {
    public CompletedGameStage(Viewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);

        Background background = new Background(Constants.WinBackgroundTextures);

        // TODO: Show spec of the game

        Image buttonNextLevel = new Image(Constants.ButtonNextLevelTexture);
        Image buttonMenu = new Image(Constants.ButtonMenuTexture);

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
                Dynamic.currentStage = new GameStage(new ScreenViewport());
            }
        });
        buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Dynamic.currentStage = new MenuStage(new ScreenViewport());
            }
        });

        addActor(background);
        addActor(buttonNextLevel);
        addActor(buttonMenu);
    }
}
