package com.cutepuppy.game;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cutepuppy.game.Stages.GameStage;
import com.cutepuppy.game.utils.Constants;

/*
 * Created by jeffbustercase on 11/12/16.
 */
public class Explosion implements Runnable {
    private GameStage stage;
    private Enemy enemy;
    public Explosion(GameStage stage, Enemy enemy){
        this.stage = stage;
        this.enemy = enemy;
    }
    @Override
    public void run() {
        try {
            main();
        } catch(InterruptedException ex){ex.printStackTrace();}
    }
    private void main() throws InterruptedException {
        Image explosion = new Image(Constants.ExplosionTexture);
        explosion.setSize(explosion.getWidth()/4, explosion.getHeight()/4);
        explosion.setPosition(
                enemy.getX(),
                enemy.getY()
        );
        stage.addActor(explosion);
        Thread.sleep(500);
        explosion.remove();
        explosion.clear();
    }
}
