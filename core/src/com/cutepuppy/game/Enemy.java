package com.cutepuppy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cutepuppy.game.utils.Constants;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public class Enemy extends Image {
    private int id;
    public Enemy(Texture texture, int id){
        super(texture);
        this.id = id;
        // Adjust Position
        setOrigin(getWidth()/2, getHeight()/2);
        setSize(getWidth()/4, getHeight()/4);
        setPosition(Gdx.graphics.getWidth()+getWidth(), MathUtils.random(0f, Gdx.graphics.getHeight()-(getHeight()/2)));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // If pass through limit, die.
        if(getX()-(getWidth()/2)<= 0) this.remove();

        // Constant Movement
        setPosition(getX()-Constants.EnemySpeed, getY());
    }

    public int getId() {
        return id;
    }
}
