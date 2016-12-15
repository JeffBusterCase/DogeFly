package com.cutepuppy.game.open;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by jeffbustercase on 15/12/16.
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    public static final Texture DogeTexture = new Texture("./assets/player/doge.png");
    public static final Texture HarpoonTexture = new Texture("./assets/harpoon.png");
    public static final Texture ExplosionTexture = new Texture("./assets/explosion.png");
    public static final Texture BirdTexture = new Texture("./assets/bird/bird-f1.png");
    public static final Texture FalconTexture = new Texture("./assets/falcon/falcon-f1.png");
    public static final Texture ButtonStartTexture = new Texture("./assets/buttons/start.png");
    public static final Texture ButtonNextLevelTexture = new Texture("./assets/buttons/nextLevel.png");
    public static final Texture ButtonMenuTexture = new Texture("./assets/buttons/menu.png");
    public static final Texture ButtonRetryTexture = new Texture("./assets/buttons/retry.png");
    public static final Texture ButtonQuitTexture = new Texture("./assets/buttons/quit.png");
    public static final Texture[] BackgroundTextures = {new Texture("./assets/backgrounds/gameBackground.png")};
    public static final Texture[] SkyBackgroundTextures = {new Texture("./assets/backgrounds/skyBackgroundTexture.png")};
    public static final Texture[] MenuBackgroundTextures = {new Texture("./assets/backgrounds/menuBackground.png")};
    public static final Texture[] EndGameBackgroundTextures = {new Texture("./assets/backgrounds/endGameBackground.png")};
    public static final Texture[] WinBackgroundTextures = {new Texture("./assets/backgrounds/winGameBackground.png")};
    public AssetManager() {
        super();

        // TODO: Organizar dentro dos apropriados metodos


    }
    public void loadMainMenuAssets(){

    }
    public void loadLevel1Assets(){

    }
    public void loadLevel2Assets(){

    }
    public void loadLostGameAssets(){

    }
    public void loadWinGameAssets(){

    }
}
