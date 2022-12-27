package pet.project.MenuScreenActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import pet.project.MenuScreen;
import pet.project.SurvIVEit;

public class Background extends Actor {
    Sprite background = new Sprite(new Texture(Gdx.files.internal("menuBackground.jpg")));
    float aspectRatio;

    public Background(SurvIVEit survObject) {
        setBounds(0,0,1440,3320);
        aspectRatio = (float) survObject.camera.viewportHeight / (float) getHeight();
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
