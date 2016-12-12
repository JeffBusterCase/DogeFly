package com.cutepuppy.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.cutepuppy.game.DogeFly;

import java.io.*;

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

    public static final Texture DogeTexture = new Texture("./assets/doge.png");
    public static final Texture ExplosionTexture = new Texture("./assets/explosion.png");
    public static final Texture BirdTexture = new Texture("./assets/bird/bird-f1.png");
    public static final Texture FalconTexture = new Texture("./assets/falcon/falcon-f1.png");
    public static final Texture ButtonStartTexture = new Texture("./assets/buttons/start.png");
    public static final Texture ButtonNextLevelTexture = new Texture("./assets/buttons/nextLevel.png");
    public static final Texture ButtonMenuTexture = new Texture("./assets/buttons/menu.png");
    public static final Texture ButtonRetryTexture = new Texture("./assets/buttons/retry.png");
    public static final Texture ButtonQuitTexture = new Texture("./assets/buttons/quit.png");
    public static final Texture[] BackgroundTextures = {new Texture("./assets/gameBackground.png")};
    public static final Texture[] MenuBackgroundTextures = {new Texture("./assets/menuBackground.png")};
    public static final Texture[] EndGameBackgroundTextures = {new Texture("./assets/endGameBackground.png")};
    public static final Texture[] WinBackgroundTextures = {new Texture("./assets/winGameBackground.png")};
//    public static final FileHandle getFileFromJar(String filename){
//        InputStream is = DogeFly.class.getClass().getResourceAsStream("/assets/test");
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//        String testFileData = "";
//        String line;
//        try {
//            while ((line = br.readLine()) != null) {
//                testFileData+=line;
//            }
//        } catch(IOException ex){ex.printStackTrace();}
//        finally {
//            try {
//                br.close();
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
