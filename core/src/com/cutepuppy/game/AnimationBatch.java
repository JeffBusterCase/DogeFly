package com.cutepuppy.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.cutepuppy.game.open.Constants;

/*
 * Created by jeffbustercase on 05/01/17.
 */
public class AnimationBatch extends SpriteBatch {
    Array<DFActor> actors;
    TextureRegion tmpTexReg;
    public AnimationBatch() {
        super();
        actors = new Array<DFActor>(Constants.ACTORS_LIMIT);
    }
    public void addActor(DFActor actor){
        actors.add(actor);
        //// Will throw if not finds a free space to add a new actor to the batch
        //throw new RuntimeException("Impossible to add new enemies due to a actor limit error.");
    }
    public void removeActor(DFActor actor){
        actors.removeValue(actor, true);
    }
    public void draw(float elapsedTime){
        begin();
        for(DFActor actor : actors){
            tmpTexReg = actor.getCurrentAnimation().getKeyFrame(elapsedTime, true);
            draw(tmpTexReg, actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
        }
        end();
    }
}
