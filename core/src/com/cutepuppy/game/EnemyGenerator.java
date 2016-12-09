package com.cutepuppy.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cutepuppy.game.utils.*;

/**
 * Created by jeffbustercase on 09/12/16.
 */
class EnemyGenerator implements Runnable {
    Stage stage;
    EnemyGenerator(Stage stage){
        super();
        this.stage = stage;
    }
    @Override
    public void run() {
        try {
            main();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    private void main() throws InterruptedException {
         do {
             stage.addActor(new Enemy(Constants.birdTexture, Dynamic.enemyid++));
             Thread.sleep(Constants.EnemyGenerationTime);
         } while(Dynamic.CAN_GENERATE_ENEMIES);
    }
}
