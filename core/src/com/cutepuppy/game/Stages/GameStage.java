package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.*;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;


/*
 * Created by jeffbustercase on 09/12/16.
 */
public class GameStage extends Stage {
    private Doge doge;
    private Label dogeHealthLabel, enemiesYetLabel, harpoonsQuantity;
    GameStage(ScreenViewport viewport) {
        super(viewport);

        Dynamic.CAN_GENERATE_ENEMIES = true;

        Gdx.input.setInputProcessor(this);
        enemiesYetLabel = createLabel("Enemies : "+(Dynamic.enemyid-2), getWidth()/2, getHeight()-20, Color.BLACK);
        
        // Load Default (For any level) assets
        Dynamic.AssetManager.loadDefaultGameAssets();
        
        doge = new Doge(Dynamic.AssetManager.get("player/doge.png", Texture.class));

        dogeHealthLabel = createLabel("Health : "+doge.getHealth(), getWidth()/2, getHeight()-(enemiesYetLabel.getHeight()*2)-20, Color.BLACK);

        harpoonsQuantity = createLabel("Harpoons : "+doge.getHarpoonQuantity(), getWidth()/2, getHeight()-(enemiesYetLabel.getHeight()*3)-20, Color.RED);

        Background background;
        
        
        // Level Textures loader and Background Selection depending on the current level
        switch (Dynamic.currentLevel){
            case (2):
                Dynamic.AssetManager.loadLevel2Assets();
                background = new Background(Dynamic.AssetManager.get("backgrounds/skyBackgroundTexture.png", Texture.class));
                break;
            default:
                Dynamic.AssetManager.loadLevel1Assets();
                background = new Background(Dynamic.AssetManager.get("backgrounds/gameBackground.png", Texture.class));
        }

        background.setSize(getWidth(), getHeight());

        addActor(background);
        addActor(doge);
        addActor(enemiesYetLabel);
        addActor(dogeHealthLabel);
        addActor(harpoonsQuantity);

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
        harpoonsQuantity.setText("Harpoons : "+(doge.getHarpoonQuantity()));
    }
    private void getCurrentInputKey(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.P))
            doge.throwHarpoon();
        else if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            doge.activateSuperPower();

        if(Gdx.input.isKeyPressed(Input.Keys.W))
            doge.setPosition(doge.getX(), doge.getY()+Constants.PlayerSpeedPower);
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            doge.setPosition(doge.getX(), doge.getY()-Constants.PlayerSpeedPower);
    }
    private static Label createLabel(String text, float x, float y, Color color){
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(
                Gdx.files.internal("./assets/fonts/emulogic/emulogic.ttf"));

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 16;

        Label label = new Label(text, new Label.LabelStyle(fontGenerator.generateFont(fontParameter),  color));
        label.setBounds(label.getX(), label.getY(), label.getWidth(), label.getHeight());
        label.setOrigin(label.getWidth()/2, label.getHeight()/2);
        label.setPosition(x, y);
        return label;
    }
}
