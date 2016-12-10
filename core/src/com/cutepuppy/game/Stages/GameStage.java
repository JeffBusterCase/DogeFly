package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.Doge;
import com.cutepuppy.game.Enemy;
import com.cutepuppy.game.EnemyGenerator;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public class GameStage extends Stage {
    Doge doge;
    Background background;
    public GameStage(ScreenViewport viewport) {
        super(viewport);

        Gdx.input.setInputProcessor(this);

        // TODO: Replace img with pixelated img.
        doge = new Doge(Constants.dogeTexture);
        background = new Background(Constants.BackgroundTextures);

        background.setSize(getWidth(), getHeight());

        addActor(background);
        addActor(doge);

        addListener(new InputListener(){
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

        // Start Enemy Generator at background
        new Thread(new EnemyGenerator(this)).start();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        for(Enemy enemy : Dynamic.enemies){
            if(doge.getBounds().overlaps(enemy.getBounds())){
                doge.collisionWith(enemy);
                enemy.die();
            }
        }
    }
}
