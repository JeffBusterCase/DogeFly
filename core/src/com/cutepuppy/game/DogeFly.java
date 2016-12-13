package com.cutepuppy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.cutepuppy.game.Stages.MenuStage;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

public class DogeFly extends ApplicationAdapter {
    @Override
	public void create () {
        Dynamic.currentStage = new MenuStage(Constants.viewport);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Dynamic.currentStage.act(Gdx.graphics.getDeltaTime());
        Dynamic.currentStage.draw();
	}

	@Override
	public void dispose (){
		Dynamic.currentStage.dispose();
	}
}
