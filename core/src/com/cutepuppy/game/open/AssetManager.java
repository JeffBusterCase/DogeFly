package com.cutepuppy.game.open;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
/*
 * Created by jeffbustercase on 15/12/16.
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    AssetManager() {
        super();
        InternalFileHandleResolver resolver = new InternalFileHandleResolver();
        setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
    }
    public void loadDefaultGameStageAssets(){
        load("player/doge.png", Texture.class);
        load("harpoon.png", Texture.class);
        load("explosion.png", Texture.class);
        load("audio/explosion.wav", Sound.class);
        load("audio/throw.wav", Sound.class);
        finishLoading();
    }
    public void disposeDefaultGameStageAssets(){
        unload("player/doge.png");
        unload("harpoon.png");
        unload("explosion.png");
        unload("audio/explosion.wav");
        unload("audio/throw.wav");
    }
    public BitmapFont getFont(FreetypeFontLoader.FreeTypeFontLoaderParameter parameter){
        if(!isLoaded(parameter.fontFileName, BitmapFont.class)){
            load(parameter.fontFileName, BitmapFont.class, parameter);
            finishLoading();
        }
        return get(parameter.fontFileName, BitmapFont.class);
    }
    public void loadMainMenuStageAssets(){
        load("backgrounds/menuBackground.png", Texture.class);
        load("buttons/start.png", Texture.class);
        load("buttons/quit.png", Texture.class);
        load("audio/mainMenuMusic.mp3", Music.class);
        finishLoading();
    }

    public void disposeMainMenuStageAssets(){
        unload("backgrounds/menuBackground.png");
        unload("buttons/start.png");
        unload("buttons/quit.png");
        unload("audio/mainMenuMusic.mp3");
    }
    public void loadLevel1Assets(){
        load("bird/bird-f1.png", Texture.class);
        load("backgrounds/gameBackground.png", Texture.class);
        load("audio/firstLevelMusic.mp3", Music.class);
        finishLoading();
    }
    public void disposeLevel1Assets(){
        unload("bird/bird-f1.png");
        unload("backgrounds/gameBackground.png");
        unload("audio/firstLevelMusic.mp3");
    }
    public void loadLevel2Assets(){
        load("bird/bird-f1.png", Texture.class);
        load("falcon/falcon-f1.png", Texture.class);
        load("backgrounds/skyBackgroundTexture.png", Texture.class);
        load("audio/secondLevelMusic.mp3", Music.class);
        finishLoading();
    }
    public void disposeLevel2Assets(){
        unload("bird/bird-f1.png");
        unload("falcon/falcon-f1.png");
        unload("backgrounds/skyBackgroundTexture.png");
        unload("audio/secondLevelMusic.mp3");
    }
    public void loadLostGameStageAssets(){
        load("buttons/menu.png", Texture.class);
        load("buttons/retry.png", Texture.class);
        load("backgrounds/endGameBackground.png", Texture.class);
        load("audio/loseLevel.wav", Sound.class);
        load("audio/lostGameMusic.mp3", Music.class);
        finishLoading();
    }
    public void disposeLostGameStageAssets(){
        unload("buttons/menu.png");
        unload("buttons/retry.png");
        unload("backgrounds/endGameBackground.png");
        unload("audio/loseLevel.wav");
        unload("audio/lostGameMusic.mp3");
    }
    public void loadCompletedGameStageAssets(){
        load("buttons/nextLevel.png", Texture.class);
        load("buttons/menu.png", Texture.class);
        load("backgrounds/winGameBackground.png", Texture.class);
        load("audio/levelCompleted.wav", Sound.class);
        load("audio/winGameMusic.mp3", Music.class);
        finishLoading();
    }
    public void disposeCompletedGameStageAssets(){
        unload("buttons/nextLevel.png");
        unload("buttons/menu.png");
        unload("backgrounds/winGameBackground.png");
        unload("audio/levelCompleted.wav");
        unload("audio/winGameMusic.mp3");
    }
}
