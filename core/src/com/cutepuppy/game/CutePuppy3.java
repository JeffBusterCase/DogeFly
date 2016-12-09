package com.cutepuppy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

public class CutePuppy3 extends ApplicationAdapter {
    Stage stage;

    Doge doge;
    Image background;

    @Override
	public void create () {
        stage = new Stage(new ScreenViewport());

        // TODO: Replace img with pixelated img.
        doge = new Doge(Constants.dogeTexture);

        // TODO: Replace with pixelated background
        background = new Image(new Texture("./assets/background.jpg"));
        background.setSize(stage.getWidth(), stage.getHeight());

        stage.addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch (keycode){
                    case(Input.Keys.W):
                        Dynamic.W=true;
                        break;
                    case(Input.Keys.S):
                        Dynamic.S=true;
                        break;
                    case(Input.Keys.P):
                        Dynamic.P=true;
                        break;
                    case(Input.Keys.SPACE):
                        Dynamic.SPACE=true;
                        break;
                }
                return false;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {

                switch (keycode){
                    case(Input.Keys.W):
                        Dynamic.W=false;
                        break;
                    case(Input.Keys.S):
                        Dynamic.S=false;
                        break;
                    case(Input.Keys.P):
                        Dynamic.P=false;
                        break;
                    case(Input.Keys.SPACE):
                        Dynamic.SPACE=false;
                        break;
                }
                return false;
            }
        });

        stage.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                // Get Collision between enemy and player
                for(Enemy enemy : Dynamic.enemies){
                    if(doge.getBounds().contains(enemy.getBounds()))
                        enemy.die();
                }


                return false;
            }
        });

        stage.addActor(background);
		stage.addActor(doge);
        Gdx.input.setInputProcessor(stage);

        // Start Enemy Generator at background
        new Thread(new EnemyGenerator(stage)).start();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}
	
	@Override
	public void dispose (){
		stage.dispose();
	}
}
