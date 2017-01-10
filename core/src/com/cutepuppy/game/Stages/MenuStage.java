package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.AnimationBatch;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public class MenuStage extends Stage {
    public MenuStage(ScreenViewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);

        Dynamic.batch = new AnimationBatch();

        Dynamic.assetManager.loadMainMenuStageAssets();

        Dynamic.currentSoundtrack = Dynamic.assetManager.get("audio/mainMenuMusic.mp3", Music.class);
        Dynamic.currentSoundtrack.setLooping(true);
        Dynamic.currentSoundtrack.play();

        Background background = new Background(Dynamic.assetManager.get("backgrounds/menuBackground.png", Texture.class));

        Image buttonStart = new Image(Dynamic.assetManager.get("buttons/start.png", Texture.class));
        Image buttonQuit = new Image(Dynamic.assetManager.get("buttons/quit.png", Texture.class));

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
                finish();

                // Start new Game
                Dynamic.currentLevel = 1;
                Dynamic.currentStage = new GameStage(Constants.viewport);
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
    private void finish(){
        Dynamic.currentSoundtrack.stop();
        Dynamic.assetManager.disposeMainMenuStageAssets();
        dispose();
    }
}
