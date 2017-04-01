package com.cutepuppy.game.open;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;
import com.cutepuppy.game.AnimationBatch;
import com.cutepuppy.game.Attack;
import com.cutepuppy.game.Enemy;
import com.cutepuppy.game.Stages.DFStage;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public class Dynamic {
    public static DFStage currentStage;
    public static AnimationBatch batch;
    public static AssetManager assetManager = new AssetManager();
    public static Music currentSoundtrack;
    public static boolean CAN_GENERATE_ENEMIES=true;
    public static int enemyid = 1;
    public static int currentLevel=1;
    public static Array<Attack> attacks = new Array<Attack>();
    public static Enemy enemy;
    public static Array<Enemy> enemies = new Array<Enemy>();
    public static Thread enemyGeneratorThread;
}
