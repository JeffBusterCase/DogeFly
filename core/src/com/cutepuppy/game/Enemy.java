package com.cutepuppy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cutepuppy.game.utils.Constants;
import com.cutepuppy.game.utils.Dynamic;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public class Enemy extends Image {
    private int id;
    private Rectangle bounds;
    public Enemy(Texture texture, int id){
        super(texture);
        this.id = id;
        // Adjust Position
        setSize(getWidth()/4, getHeight()/4);
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(Gdx.graphics.getWidth()+getWidth(), MathUtils.random(0f, Gdx.graphics.getHeight()-(getHeight()/2)));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // If pass through limit, die.
        if(getX()<=0) die();

        // Constant Movement
        setPosition(getX()-Constants.EnemySpeed, getY());
    }

    public int getId() {
        return id;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void die(){
        Dynamic.enemies.removeValue(this, true);
        remove();
    }
}
