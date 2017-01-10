package com.cutepuppy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.cutepuppy.game.Stages.MenuStage;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

public class DogeFly extends ApplicationAdapter {
    private float delta, elapsedTime;
    @Override
	public void create () {
        Dynamic.currentStage = new MenuStage(Constants.viewport);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        delta = Gdx.graphics.getDeltaTime();
        try { Dynamic.currentStage.act(delta); } catch (NullPointerException ex){
            System.out.println("WARNING : NullPointerException on `Gdx.graphics.getDeltaTime();`(Skipping stage action)");
            return;
        }
        elapsedTime+=delta;
        Dynamic.currentStage.draw();
        try {Dynamic.batch.draw(elapsedTime);} catch (NullPointerException ex){
            System.out.println("WARNING: NullPointeException on Batch Draw");
        }
	}

	@Override
	public void dispose (){
		Dynamic.currentStage.dispose();
        Dynamic.batch.dispose();
		Dynamic.assetManager.dispose();
	}
}
