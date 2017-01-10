package com.cutepuppy.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.cutepuppy.game.Stages.GameStage;
import com.cutepuppy.game.open.Dynamic;

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
        // Explosion Sound
        Sound explosionSFX;
        try {
            explosionSFX = Dynamic.assetManager.get("audio/explosion.wav", Sound.class);
        } catch( GdxRuntimeException ex) {
            System.out.println(GameStage.class.toString());
            if (Dynamic.currentStage.getClass()!=GameStage.class)
                System.out.println("WARNING: Tried to get already unloaded data.("+
                        Dynamic.currentStage.getClass().toString()+
                        ")");
            else ex.printStackTrace();
            return;
        }


        // Explosion Image
        Image explosion = new Image(Dynamic.assetManager.get("explosion.png", Texture.class));
        explosion.setSize(explosion.getWidth()/4, explosion.getHeight()/4);
        explosion.setPosition(pos[0], pos[1]);
        stage.addActor(explosion);
        explosionSFX.play();
        Thread.sleep(500);
        explosion.remove();
        explosion.clear();
    }
}
