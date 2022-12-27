package pet.project.MenuScreenActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import pet.project.Interlayer;

public class Background extends Actor {
    private final Sprite background = new Sprite(new Texture(Gdx.files.internal("menuBackground.jpg")));
    private float aspectRatio;

    public Background() {
        setBounds(0,0,1440,3320);
        aspectRatio = Interlayer.survObj.camera.viewportHeight / getHeight();
        if(aspectRatio > 1f){
            setScale(aspectRatio);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        background.setBounds(getX(),getY(),getWidth(),getHeight());
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        background.draw(batch);
    }
}
