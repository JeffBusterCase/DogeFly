package com.cutepuppy.game.open;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by jeffbustercase on 15/12/16.
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    public AssetManager() {
        super();
    }
    public void loadDefaultGameAssets(){
        load("player/doge.png", Texture.class);
        load("harpoon.png", Texture.class);
        load("explosion.png", Texture.class);
    }
    public void loadMainMenuAssets(){
        load("backgrounds/menuBackground.png", Texture.class);
        load("buttons/start.png", Texture.class);
        load("buttons/quit.png", Texture.class);
    }
    public void loadLevel1Assets(){
        load("bird/bird-f1.png", Texture.class);[
        load("backgrounds/gameBackground.png", Texture.class);
    }
    public void loadLevel2Assets(){
        load("bird/bird-f1.png");
        load("falcon/falcon-f1.png", Texture.class);
        load("backgrounds/skyBackgroundTexture.png", Texture.class);
    }
    public void loadLostGameAssets(){
        load("buttons/menu.png");
        load("buttons/retry.png");
        load("backgrounds/endGameBackground.png", Texture.class);
    }
    public void loadWinGameAssets(){
        load("buttons/nextLevel.png", Texture.class);
        load("buttons/menu.png", Texture.class);
        load("backgrounds/winGameBackground.png", Texture.class);
    }
}
