package com.cutepuppy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.cutepuppy.game.Stages.GameStage;
import com.cutepuppy.game.Stages.LostGameStage;
import com.cutepuppy.game.open.Constants;
import com.cutepuppy.game.open.Dynamic;

/*
 * Created by jeffbustercase on 06/12/16.
 */
public class Doge extends Image {
    private int health;
    private Rectangle bounds;

    // Attacks
    private int harpoonQuantity;
    private boolean canUseSuperPower;
    private final Array<Sound> hurtSFXs;
    public Doge(Texture texture) {
        super(texture);
        canUseSuperPower = false;
        health = Constants.PlayerHealth;
        harpoonQuantity = Constants.HarpoonStartQuantity;
        setSize(getWidth()*2, getHeight()*2);
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(100f, Gdx.graphics.getHeight()/2);
        setScale(-getScaleX(), getScaleY());
        hurtSFXs = new Array<Sound>(3);
        hurtSFXs.addAll(
                Dynamic.assetManager.get("audio/dog_hurt1.wav", Sound.class),
                Dynamic.assetManager.get("audio/dog_hurt2.wav", Sound.class),
                Dynamic.assetManager.get("audio/dog_hurt3.wav", Sound.class)
        );
    }
    @Override
    public void act(float delta) {
        super.act(delta);

        bounds.setPosition(getX()-(getWidth()/2), getY()-(getHeight()/2));
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void collisionWith(Enemy enemy){
        health-=Constants.HIT_DAMAGE;
        if(health<=0) die();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if(health<=0) die();
    }
    public void hit(int damage){
        this.health -= damage;
        if(health<=0) die();
        else
            hurtSFXs.random().play();// Play hit sound
    }
    public void throwHarpoon(){
        if (harpoonQuantity>0)  {
            new Attack(Dynamic.assetManager.get("harpoon.png", Texture.class), getY(), Constants.HARPOON_DAMAGE);
            harpoonQuantity--;
        }
    }
    public void activateSuperPower() {
        /* TODO: Do thing to activate super power (i.e. show super power img and make constant damage to enemies in line) */
    }
    public int getHarpoonQuantity(){
        return harpoonQuantity;
    }
    private void die(){
        Dynamic.currentStage.finish();
        Dynamic.currentStage = new LostGameStage(Constants.viewport);
    }
}
