package com.cutepuppy.game.open;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.cutepuppy.game.Attack;
import com.cutepuppy.game.Enemy;
/*
 * Created by jeffbustercase on 09/12/16.
 */
public class Dynamic {
    public static boolean CAN_GENERATE_ENEMIES=true;
    public static int enemyid = 1;
    public static int currentLevel=1;
    public static Array<Attack> attacks = new Array<Attack>();
    public static Enemy enemy;
    public static Array<Enemy> enemies = new Array<Enemy>();
    public static Stage currentStage;
    public static Thread enemyGeneratorThread;
}
