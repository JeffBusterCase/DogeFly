package com.cutepuppy.game.utils;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public final class Constants {
    public static final int PlayerHealth = 100;
    public static final int HIT_DAMAGE = 10;
    public static final float EnemySpeed = 5f;
    public static final float PlayerSpeedPower = 4f;
    public static final long EnemyGenerationTime = 1000;

    public static final Texture dogeTexture = new Texture("./assets/doge.png");
    public static final Texture birdTexture = new Texture("./assets/bird/bird-f1.png");
    public static final Texture ButtonStartTexture = new Texture("./assets/buttons/start.png");
    public static final Texture ButtonMenuTexture = new Texture("./assets/buttons/menu.png");
    public static final Texture ButtonRetryTexture = new Texture("./assets/buttons/retry.png");
    public static final Texture ButtonQuitTexture = new Texture("./assets/buttons/quit.png");
    public static final Texture[] BackgroundTextures = {new Texture("./assets/gameBackground.jpg")};
    public static final Texture[] MenuBackgroundTextures = {new Texture("./assets/menuBackground.jpg")};
    public static final Texture[] EndGameBackgroundTextures = {new Texture("./assets/endGameBackground.jpg")};
}
