package com.cutepuppy.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public class EnemyGenerator implements Runnable {
    Stage stage;
    public EnemyGenerator(Stage stage){
        super();
        this.stage = stage;
        Dynamic.enemyid=2;
    }

    @Override
    public void run() {
        try {
            main();
        } catch( InterruptedException ex) { ex.printStackTrace(); }
    }
    private void main() throws InterruptedException {
        do {
            switch (MathUtils.random(Dynamic.currentLevel-1)){
                case 1:
                    generateFalcon();
                default:
                    generateBird();
            }
            Thread.sleep(Constants.EnemyGenerationTime);
        } while(Dynamic.CAN_GENERATE_ENEMIES);
    }
    private void generateFalcon(){
        Dynamic.enemy = new Enemy(Constants.FalconTexture, Dynamic.enemyid++);
        Dynamic.enemy.setDamage(20);
        stage.addActor(Dynamic.enemy);
        Dynamic.enemies.add(Dynamic.enemy);
    }
    private void generateBird(){
        Dynamic.enemy = new Enemy(Constants.BirdTexture, Dynamic.enemyid++);
        Dynamic.enemy.setDamage(5);
        stage.addActor(Dynamic.enemy);
        Dynamic.enemies.add(Dynamic.enemy);
    }
}
