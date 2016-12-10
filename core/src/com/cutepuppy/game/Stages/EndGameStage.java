package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public class EndGameStage extends Stage {
    public EndGameStage(ScreenViewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);

        Background background = new Background(Constants.EndGameBackgroundTextures);
        background.setSize(getWidth(), getHeight());

        Image buttonMenu = new Image(Constants.ButtonMenuTexture);
        Image buttonRetry = new Image(Constants.ButtonRetryTexture);
        Image buttonQuit = new Image(Constants.ButtonQuitTexture);

        buttonMenu.setSize(buttonMenu.getWidth()/4, buttonMenu.getHeight()/4);
        buttonRetry.setSize(buttonRetry.getWidth()/4, buttonRetry.getHeight()/4);
        buttonQuit.setSize(buttonQuit.getWidth()/4, buttonQuit.getHeight()/4);

        buttonMenu.setOrigin(buttonMenu.getWidth()/2, buttonMenu.getHeight()/2);
        buttonRetry.setOrigin(buttonRetry.getWidth()/2, buttonRetry.getHeight()/2);
        buttonQuit.setOrigin(buttonQuit.getWidth()/2, buttonQuit.getHeight()/2);

        buttonMenu.setPosition((getWidth()/2)-(buttonMenu.getWidth()/2), (getHeight()/2)-buttonMenu.getHeight());
        buttonRetry.setPosition((getWidth()/2)-(buttonRetry.getWidth()/2), (getHeight()/2)-(buttonMenu.getHeight()*2)-10);
        buttonQuit.setPosition((getWidth()/2)-(buttonQuit.getWidth()/2), (getHeight()/2)-(buttonMenu.getHeight()*3)-20);

        buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Dynamic.currentStage = new MenuStage(new ScreenViewport());
            }
        });

        buttonRetry.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Dynamic.currentStage = new GameStage(new ScreenViewport());
            }
        });

        buttonQuit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

        addActor(background);
        addActor(buttonRetry);
        addActor(buttonMenu);
        addActor(buttonQuit);
    }
}
