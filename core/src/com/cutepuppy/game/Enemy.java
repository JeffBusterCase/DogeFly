package com.cutepuppy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.cutepuppy.game.Stages.CompletedGameStage;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 09/12/16.
 */
public class Enemy extends DFActor {
    private int id;
    private int damage;
    private int health;
    private Rectangle bounds;

    Enemy(int id, int health){
        super();
        this.id = id;

        // Set values
        damage=0;
        this.health = health;

        // Adjust Batch Size
        setBatchSize(getBatchWidth()/4, getBatchHeight()/4);

        // Set Default Size
        setSize(getBatchWidth(), getBatchHeight());

        // For compare with others
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());

        // Set Position
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(Gdx.graphics.getWidth()+getWidth(), MathUtils.random(Gdx.graphics.getHeight()-(getHeight()/2)));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // If pass through limit, die.
        if(getX()<=-getWidth() || health <= 0) die();

        // Constant Movement
        setPosition(getX()-Constants.EnemySpeed, getY());

        // Show with the size of the current frame of the animation
        float width = getCurrentAnimation().getKeyFrame(delta).getRegionWidth();
        float height = getCurrentAnimation().getKeyFrame(delta).getRegionWidth();
        System.out.println("width: "+width+", height: "+height);
        setSize(width/4, height/4);
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        bounds.setPosition(getX()-(getHeight()/2), getY()-(getHeight()/2));
    }
    public void hit(int damage){
        health -= damage;
        if(health<=0) die();
    }
    public int getId() {
        return id;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Rectangle getBounds(){
        return bounds;
    }
    public void die(){
        remove();
        clear();
        Dynamic.enemies.removeValue(this, true);
        Dynamic.batch.removeActor(this);
        if(Dynamic.enemyid-2>=Constants.EnemiesThatMustBeKilledByLevel){
            Dynamic.CAN_GENERATE_ENEMIES = false;
            if(Dynamic.enemyGeneratorThread.isAlive())
                Dynamic.enemyGeneratorThread.interrupt();
            Dynamic.currentStage.finish();
            Dynamic.currentStage = new CompletedGameStage(Constants.viewport);
        }
    }
}
