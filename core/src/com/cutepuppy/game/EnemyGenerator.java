package com.cutepuppy.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public class EnemyGenerator implements Runnable {
    private Stage stage;
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
        Dynamic.enemy = new Enemy(Dynamic.enemyid++, 22);
        Dynamic.enemy.setDamage(20);
        Dynamic.enemy.setAnimations(1f/6f, new String[][]{
                {"falcon/falcon-f0.png", "falcon/falcon-f1.png", "falcon/falcon-f2.png", "falcon/falcon-f1.png"}
        });
        Dynamic.enemy.setAnimationState(0);
        stage.addActor(Dynamic.enemy);
        Dynamic.batch.addActor(Dynamic.enemy);
        Dynamic.enemies.add(Dynamic.enemy);
    }
    private void generateBird(){
        Dynamic.enemy = new Enemy(Dynamic.enemyid++, 11);
        Dynamic.enemy.setDamage(5);
        Dynamic.enemy.setAnimations(1f/6f, new String[][]{
                {"bird/bird-f0.png", "bird/bird-f1.png", "bird/bird-f2.png", "bird/bird-f1.png"}
        });
        Dynamic.enemy.setAnimationState(0);
        stage.addActor(Dynamic.enemy);
        Dynamic.batch.addActor(Dynamic.enemy);
        Dynamic.enemies.add(Dynamic.enemy);
        System.out.println("Width of this actor: "+Dynamic.enemy.getBounds().toString());
    }
}
