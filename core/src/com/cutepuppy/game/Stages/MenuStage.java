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
public class MenuStage extends Stage {
    Image buttonStart, buttonQuit;
    public MenuStage(ScreenViewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);

        Background background = new Background(Constants.MenuBackgroundTextures);

        buttonStart = new Image(Constants.ButtonStartTexture);
        buttonQuit = new Image(Constants.ButtonQuitTexture);

        buttonStart.setSize(buttonStart.getWidth()/4, buttonStart.getHeight()/4);
        buttonQuit.setSize(buttonQuit.getWidth()/4, buttonQuit.getHeight()/4);

        buttonStart.setOrigin(buttonStart.getWidth()/2, buttonStart.getHeight()/2);
        buttonQuit.setOrigin(buttonQuit.getWidth()/2, buttonQuit.getHeight()/2);

        buttonStart.setPosition((getWidth()/2)-buttonStart.getWidth()/2, (getHeight()/2)-getHeight()/8);
        buttonQuit.setPosition((getWidth()/2)-buttonQuit.getWidth()/2, (getHeight()/2)-getHeight()/4);

        buttonStart.addListener(new ClickListener(){
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
        addActor(buttonStart);
        addActor(buttonQuit);
    }
}
