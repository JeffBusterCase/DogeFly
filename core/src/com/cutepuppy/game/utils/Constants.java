package com.cutepuppy.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public final class Constants {
    public static final int PlayerHealth = 100;
    public static final int HIT_DAMAGE = 10;
    public static final float EnemySpeed = 5f;
    public static final float PlayerSpeedPower = 4f;
    public static final float AttackVel = 15f;
    public static final long EnemyGenerationTime = 1000;
    public static final int EnemiesThatMustBeKilledByLevel = 20;

    public static final ScreenViewport viewport = new ScreenViewport();

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
    public static int HarpoonStartQuantity = 10;
}
