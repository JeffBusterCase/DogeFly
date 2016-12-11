package com.cutepuppy.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cutepuppy.game.utils.*;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public class EnemyGenerator implements Runnable {
    Stage stage;
    private int level;
    public EnemyGenerator(Stage stage){
        super();
        this.stage = stage;
        Dynamic.enemyid=2;
    }

    @Override
    public void run() {
        try {
            switch (level) {
                case 2:
                    startLevel2();
                default:
                    startLevel1();
            }
        } catch( InterruptedException ex) { ex.printStackTrace(); }
    }

    private void startLevel1() throws InterruptedException {
         do {
             generateBird();
             Thread.sleep(Constants.EnemyGenerationTime);
         } while(Dynamic.CAN_GENERATE_ENEMIES);
    }
    private void startLevel2() throws InterruptedException {
        do {
            switch (MathUtils.random(2)){
                case 1:
                    generateFalcon();
                default:
                    generateBird();
            }
        } while(Dynamic.CAN_GENERATE_ENEMIES);
    }
    private void generateFalcon(){
        Dynamic.enemy = new Enemy(Constants.FalconTexture, Dynamic.enemyid++);
        Dynamic.enemy.setDamage(10);
        stage.addActor(Dynamic.enemy);
        Dynamic.enemies.add(Dynamic.enemy);
    }
    private void generateBird(){
        Dynamic.enemy = new Enemy(Constants.BirdTexture, Dynamic.enemyid++);
        Dynamic.enemy.setDamage(5);
        stage.addActor(Dynamic.enemy);
        Dynamic.enemies.add(Dynamic.enemy);
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
