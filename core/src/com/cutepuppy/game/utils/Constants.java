package com.cutepuppy.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.cutepuppy.game.DogeFly;

import java.io.InputStream;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public final class Constants {
    public static final int PlayerHealth = 100;
    public static final int HIT_DAMAGE = 10;
    public static final float EnemySpeed = 5f;
    public static final float PlayerSpeedPower = 4f;
    public static final long EnemyGenerationTime = 1000;
    public static final int EnemiesThatMustBeKilledByLevel = 20;

    public static final String currentDir = System.getProperty("user.dir");

    public static final Texture DogeTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/doge.png"));
    public static final Texture ExplosionTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/explosion.png"));
    public static final Texture BirdTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/bird/bird-f1.png"));
    public static final Texture FalconTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/falcon/falcon-f1.png"));
    public static final Texture ButtonStartTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/buttons/start.png"));
    public static final Texture ButtonNextLevelTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/buttons/nextLevel.png"));
    public static final Texture ButtonMenuTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/buttons/menu.png"));
    public static final Texture ButtonRetryTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/buttons/retry.png"));
    public static final Texture ButtonQuitTexture = new Texture(Gdx.files.absolute(currentDir+"/assets/buttons/quit.png"));
    public static final Texture[] BackgroundTextures = {new Texture(Gdx.files.absolute(currentDir+"/assets/gameBackground.png"))};
    public static final Texture[] MenuBackgroundTextures = {new Texture(Gdx.files.absolute(currentDir+"/assets/menuBackground.png"))};
    public static final Texture[] EndGameBackgroundTextures = {new Texture(Gdx.files.absolute(currentDir+"/assets/endGameBackground.png"))};
    public static final Texture[] WinBackgroundTextures = {new Texture(Gdx.files.absolute(currentDir+"/assets/winGameBackground.png"))};
}
