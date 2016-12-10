package com.cutepuppy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.cutepuppy.game.Stages.MenuStage;
import com.cutepuppy.game.utils.Dynamic;

public class DogeFly extends ApplicationAdapter {
    @Override
	public void create () {
        Dynamic.currentStage = new MenuStage(new ScreenViewport());
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
