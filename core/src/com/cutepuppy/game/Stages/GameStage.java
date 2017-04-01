package com.cutepuppy.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.*;
import com.cutepuppy.game.backgrounds.Background;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;


/*
 * Created by jeffbustercase on 09/12/16.
 */
public class GameStage extends DFStage {
    private Doge doge;
    private Label dogeHealthLabel, enemiesYetLabel, harpoonsQuantity;
    GameStage(ScreenViewport viewport) {
        super(viewport);

        Dynamic.CAN_GENERATE_ENEMIES = true;
        Dynamic.enemyid = 1;

        Gdx.input.setInputProcessor(this);

        Dynamic.batch = new AnimationBatch();

        // Load Default (For any level) assets
        Dynamic.assetManager.loadDefaultGameStageAssets();

        enemiesYetLabel = createLabel("Enemies : "+(Dynamic.enemyid-2), getWidth()/2, getHeight()-20, Color.BLACK);

        doge = new Doge(Dynamic.assetManager.get("player/doge.png", Texture.class));

        dogeHealthLabel = createLabel("Health : "+doge.getHealth(), getWidth()/2, getHeight()-(enemiesYetLabel.getHeight()*2)-20, Color.BLACK);

        harpoonsQuantity = createLabel("Harpoons : "+doge.getHarpoonQuantity(), getWidth()/2, getHeight()-(enemiesYetLabel.getHeight()*3)-20, Color.RED);

        Background background;
        
        
        // Level Textures loader and Background Selection depending on the current level
        switch (Dynamic.currentLevel){
            case (2):
                Dynamic.assetManager.loadLevel2Assets();
                Dynamic.currentSoundtrack = Dynamic.assetManager.get("audio/secondLevelMusic.mp3", Music.class);
                background = new Background(Dynamic.assetManager.get("backgrounds/skyBackgroundTexture.png", Texture.class));
                break;
            default:
                Dynamic.assetManager.loadLevel1Assets();
                Dynamic.currentSoundtrack = Dynamic.assetManager.get("audio/firstLevelMusic.mp3", Music.class);
                background = new Background(Dynamic.assetManager.get("backgrounds/gameBackground.png", Texture.class));
        }

        Dynamic.currentSoundtrack.setLooping(true);
        Dynamic.currentSoundtrack.play();

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
                    enemy.hit(attack.damage);
                    attack.destroy();
                    break;
                }
        }

        for (Enemy enemy : Dynamic.enemies) {
            if (doge.getBounds().overlaps(enemy.getBounds())) {
                doge.setHealth(doge.getHealth()-Constants.HIT_DAMAGE);
                doge.hit(enemy.getDamage());
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

        FreeTypeFontLoaderParameter fontParameter = new FreeTypeFontLoaderParameter();
        fontParameter.fontFileName = "fonts/emulogic/emulogic.ttf";
        fontParameter.fontParameters.size = 16;

        Label label = new Label(text, new Label.LabelStyle(Dynamic.assetManager.getFont(fontParameter), color));
        label.setBounds(label.getX(), label.getY(), label.getWidth(), label.getHeight());
        label.setOrigin(label.getWidth()/2, label.getHeight()/2);
        label.setPosition(x, y);
        return label;
    }
    public void finish(){
        Dynamic.CAN_GENERATE_ENEMIES = false;
        if(Dynamic.enemyGeneratorThread.isAlive())
            Dynamic.enemyGeneratorThread.interrupt();
        Dynamic.currentSoundtrack.stop();
        Dynamic.assetManager.disposeDefaultGameStageAssets();
        switch (Dynamic.currentLevel){
            case 2:
                Dynamic.assetManager.disposeLevel2Assets();
                break;
            default:
                Dynamic.assetManager.disposeLevel1Assets();
        }
        dispose();
    }
}
