package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cutepuppy.game.AnimationBatch;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 11/12/16.
 */
public class CompletedGameStage extends DFStage {
    public CompletedGameStage(final Viewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);

        Dynamic.batch = new AnimationBatch();

        Dynamic.assetManager.loadCompletedGameStageAssets();
        Dynamic.assetManager.finishLoading();

        Dynamic.currentSoundtrack = Dynamic.assetManager.get("audio/winGameMusic.mp3", Music.class);
        Dynamic.currentSoundtrack.setLooping(true);
        Dynamic.currentSoundtrack.setPosition(Dynamic.currentSoundtrack.getPosition()+10f);

        Background background = new Background(Dynamic.assetManager.get("backgrounds/winGameBackground.png", Texture.class));

        // TODO: Show spec of the game

        Image buttonNextLevel = new Image(Dynamic.assetManager.get("buttons/nextLevel.png", Texture.class));
        Image buttonMenu = new Image(Dynamic.assetManager.get("buttons/menu.png", Texture.class));

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
                finish();
                if(Dynamic.currentLevel>Constants.LEVELS){
                    Dynamic.currentStage = new MenuStage(Constants.viewport);
                    return;
                }
                Dynamic.currentStage = new GameStage(Constants.viewport);
            }
        });
        buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                finish();
                Dynamic.currentStage = new MenuStage(Constants.viewport);
            }
        });

        addActor(background);
        addActor(buttonNextLevel);
        addActor(buttonMenu);

        // Level Completed Sound Effect
        Sound levelCompletedSFX = Dynamic.assetManager.get("audio/levelCompleted.wav", Sound.class);
        levelCompletedSFX.play();
    }
    public void finish(){
        Dynamic.currentSoundtrack.stop();
        Dynamic.assetManager.disposeCompletedGameStageAssets();
        dispose();
    }
}
