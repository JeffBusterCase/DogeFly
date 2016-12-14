package com.cutepuppy.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cutepuppy.game.utils.Dynamic;

/**
 * Created by jeffbustercase on 13/12/16.
 */
public class Attack extends Image {
    private Rectangle bounds;
    public Attack(Texture texture, float ypos) {
        super(texture);
        setSize(getWidth()*2, getHeight()*2);
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(getX(), ypos);
        setBounds(getX(), getY(), getWidth(), getHeight());
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Dynamic.currentStage.addActor(this);
        Dynamic.attacks.add(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        bounds.setPosition(getX(), getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }
    public void destroy(){
        remove();
        clear();
        Dynamic.attacks.removeValue(this, true);
    }
}
