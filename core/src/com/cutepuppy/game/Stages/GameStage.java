package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.*;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;


/*
 * Created by jeffbustercase on 09/12/16.
 */
public class GameStage extends Stage {
    private Doge doge;
    private Label dogeHealthLabel, enemiesYetLabel;
    GameStage(ScreenViewport viewport) {
        super(viewport);
        Dynamic.W = false;
        Dynamic.S = false;
        Dynamic.CAN_GENERATE_ENEMIES = true;

        Gdx.input.setInputProcessor(this);
        Label.LabelStyle ls = new Label.LabelStyle(new BitmapFont(),  Color.BLACK);
        enemiesYetLabel = new Label("Enemies : "+(Dynamic.enemyid-2),
               ls);
        enemiesYetLabel.setBounds(enemiesYetLabel.getX(), enemiesYetLabel.getY(),
                enemiesYetLabel.getWidth(), enemiesYetLabel.getHeight());

        enemiesYetLabel.setOrigin(enemiesYetLabel.getWidth()/2, enemiesYetLabel.getHeight()/2);
        enemiesYetLabel.setPosition(getWidth()/2, getHeight()-enemiesYetLabel.getHeight()*2);

        doge = new Doge(Constants.DogeTexture);

        dogeHealthLabel = new Label("Health : "+doge.getHealth(), ls);

        dogeHealthLabel.setBounds(dogeHealthLabel.getX(), dogeHealthLabel.getY(), dogeHealthLabel.getWidth(), dogeHealthLabel.getHeight());
        dogeHealthLabel.setOrigin(dogeHealthLabel.getWidth()/2, dogeHealthLabel.getHeight()/2);
        dogeHealthLabel.setPosition(getWidth()/2, getHeight()-(enemiesYetLabel.getHeight()*2)-dogeHealthLabel.getHeight());

        Background background;

        // Background Selection
        switch (Dynamic.currentLevel){
            case (2):
                background = new Background(Constants.SkyBackgroundTextures);
                break;
            default:
                background = new Background(Constants.BackgroundTextures);
        }

        background.setSize(getWidth(), getHeight());

        addActor(background);
        addActor(doge);
        addActor(enemiesYetLabel);
        addActor(dogeHealthLabel);

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
                }
                return false;
            }
        });

        // Start Enemy Generator at background
        Dynamic.enemyGeneratorThread = new Thread(new EnemyGenerator(this));
        Dynamic.enemyGeneratorThread.start();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        getCurrentInputKey();


        for (Attack attack : Dynamic.attacks){
            attack.setPosition(attack.getX()+Constants.AttackVel, attack.getY());
            for (Enemy enemy : Dynamic.enemies)
                if(attack.getBounds().overlaps(enemy.getBounds())){
                    new Thread(new Explosion(this, enemy.getX(), enemy.getY())).start();
                    enemy.die();
                    attack.destroy();
                    break;
                }
        }

        for (Enemy enemy : Dynamic.enemies) {
            if (doge.getBounds().overlaps(enemy.getBounds())) {
                doge.setHealth(doge.getHealth()-Constants.HIT_DAMAGE);
                dogeHealthLabel.setText("Health : "+doge.getHealth());
                new Thread(new Explosion(this, enemy.getX(), enemy.getY())).start();
                enemy.die();
            }
        }

        enemiesYetLabel.setText("Enemies : "+(Dynamic.enemyid-2));
    }
    private void getCurrentInputKey(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.P))
            doge.throwHarpoon();
        else if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            doge.activateSuperPower();
    }
}
