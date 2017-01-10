package com.cutepuppy.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 05/01/17.
 */
public class DFActor extends Actor {
    private Animation[] animations;
    private int animationState;
    private float width, height;
    public void setBatchSize(float w, float h){
        width = w;
        height = h;
    }
    public float getBatchWidth(){return width;}
    public float getBatchHeight() {return height;}

    public Animation getCurrentAnimation(){
        return animations[animationState];
    }
    public void setAnimations(Animation[] animations){
        animations = animations;
    }
    public void setAnimations(float fps, String[][] animationsPerFile){
        animations = new Animation[animationsPerFile.length];
        TextureRegion[] texReg;
        for(int i=0;i<animationsPerFile.length;i++){
            texReg = new TextureRegion[animationsPerFile[i].length];
            for(int j=0;j<animationsPerFile[i].length;j++){
                texReg[j] = new TextureRegion(Dynamic.assetManager.get(animationsPerFile[i][j], Texture.class));
            }
            animations[i] = new Animation(fps, texReg);
        }
    }
    public void setAnimationState(int thisAnimation){
        animationState = thisAnimation;
    }
}
