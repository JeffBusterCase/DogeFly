package com.cutepuppy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cutepuppy.game.utils.*;

/**
 * Created by jeffbustercase on 06/12/16.
 */
public class Doge extends Image {
    private boolean superPower;
    private Rectangle bounds;
    public static final int id = 0;
    public Doge(Texture texture) {
        super(texture);
        superPower = false;
        setSize(getWidth()/4, getHeight()/4);
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth()/4, getHeight()/4);
        setPosition(100f, Gdx.graphics.getHeight()/2);
        setScale(-getScaleX(), getScaleY());
    }
    @Override
    public void act(float delta) {
        super.act(delta);

        if(Dynamic.W)
            setPosition(getX(), getY()+ Constants.PlayerSpeedPower);
        else if(Dynamic.S)
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
    }
    private void activateSuperPower() {
        /* TODO: Do thing to activate super power (i.e. show super power img and make constant damage to enemies in line) */
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public int getId(){return id;}
}
