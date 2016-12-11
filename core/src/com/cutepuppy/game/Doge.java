package com.cutepuppy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cutepuppy.game.Stages.EndGameStage;
import com.cutepuppy.game.utils.*;

/**
 * Created by jeffbustercase on 06/12/16.
 */
public class Doge extends Image {
    private int health;
    private boolean superPower;
    private Rectangle bounds;
    public static final int id = 0;
    public Doge(Texture texture) {
        super(texture);
        superPower = false;
        health = Constants.PlayerHealth;
        setSize(getWidth()/4, getHeight()/4);
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(100f, Gdx.graphics.getHeight()/2);
        setScale(-getScaleX(), getScaleY());
    }
    @Override
    public void act(float delta) {
        super.act(delta);

        if(Dynamic.W && getY()<=Gdx.graphics.getHeight())
            setPosition(getX(), getY()+ Constants.PlayerSpeedPower);
        else if(Dynamic.S && getY()>=0)
            setPosition(getX(), getY()-Constants.PlayerSpeedPower);

        if(Dynamic.P)
            System.out.println("Normal Power Activated");
        if(Dynamic.SPACE){
            if(!superPower){
                superPower=true;
                System.out.println("Super Power Activated");
                activateSuperPower();
            }
        }
        bounds.setPosition(getX()-(getWidth()/2), getY()-(getHeight()/2));
    }
    private void activateSuperPower() {
        /* TODO: Do thing to activate super power (i.e. show super power img and make constant damage to enemies in line) */
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public int getId(){return id;}
    public void collisionWith(Enemy enemy){
        health-=Constants.HIT_DAMAGE;
        System.out.println("Collision With enemy : "+enemy.getId()+", health now: "+health);
        if(health<=0) Dynamic.currentStage = new EndGameStage(new ScreenViewport());
    }
    public void tookDamageFrom(Enemy enemy) {
        health-=enemy.getDamage();
        if(health<=0) Dynamic.currentStage = new EndGameStage(new ScreenViewport());
    }
}
