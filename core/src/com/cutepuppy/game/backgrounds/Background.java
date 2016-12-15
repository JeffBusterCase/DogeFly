package com.cutepuppy.game.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by jeffbustercase on 09/12/16.
 */
public class Background extends Image {
    public Background(Texture texture) {
        super(texture);
        // TODO: uses animation. so interate over textures

        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
