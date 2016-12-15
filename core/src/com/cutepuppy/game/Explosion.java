package com.cutepuppy.game;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cutepuppy.game.Stages.GameStage;
import com.cutepuppy.game.open.Constants;

/*
 * Created by jeffbustercase on 11/12/16.
 */
public class Explosion implements Runnable {
    private GameStage stage;
    private float[] pos;
    public Explosion(GameStage stage, float xpos, float ypos){
        this.stage = stage;
        this.pos = new float[]{xpos, ypos};
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
        explosion.setPosition(pos[0], pos[1]);
        stage.addActor(explosion);
        Thread.sleep(500);
        explosion.remove();
        explosion.clear();
    }
}
