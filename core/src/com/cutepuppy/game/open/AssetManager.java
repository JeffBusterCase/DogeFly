package com.cutepuppy.game.open;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
/*
 * Created by jeffbustercase on 15/12/16.
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    public AssetManager() {
        super();
        InternalFileHandleResolver resolver = new InternalFileHandleResolver();
        setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
    }
    public void loadDefaultGameAssets(){
        load("player/doge.png", Texture.class);
        load("harpoon.png", Texture.class);
        load("explosion.png", Texture.class);
        finishLoading();
    }
    public BitmapFont getFont(FreetypeFontLoader.FreeTypeFontLoaderParameter parameter){
        if(!isLoaded(parameter.fontFileName, BitmapFont.class)){
            load(parameter.fontFileName, BitmapFont.class, parameter);
            finishLoading();
        }
        return get(parameter.fontFileName, BitmapFont.class);
    }
    public void loadMainMenuAssets(){
        load("backgrounds/menuBackground.png", Texture.class);
        load("buttons/start.png", Texture.class);
        load("buttons/quit.png", Texture.class);
        finishLoading();
    }
    public void loadLevel1Assets(){
        load("bird/bird-f1.png", Texture.class);
        load("backgrounds/gameBackground.png", Texture.class);
        finishLoading();
    }
    public void loadLevel2Assets(){
        load("bird/bird-f1.png", Texture.class);
        load("falcon/falcon-f1.png", Texture.class);
        load("backgrounds/skyBackgroundTexture.png", Texture.class);
        finishLoading();
    }
    public void loadLostGameAssets(){
        load("buttons/menu.png", Texture.class);
        load("buttons/retry.png", Texture.class);
        load("backgrounds/endGameBackground.png", Texture.class);
        finishLoading();
    }
    public void loadWinGameAssets(){
        load("buttons/nextLevel.png", Texture.class);
        load("buttons/menu.png", Texture.class);
        load("backgrounds/winGameBackground.png", Texture.class);
        finishLoading();
    }
}
