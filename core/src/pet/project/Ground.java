package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ground extends Actor {
    private final Sprite groundSkin = new Sprite(new Texture(Gdx.files.internal("ground1.png")));

    public Ground() {
        setSize(160,160);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        groundSkin.setBounds(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        groundSkin.draw(batch);
    }
}
