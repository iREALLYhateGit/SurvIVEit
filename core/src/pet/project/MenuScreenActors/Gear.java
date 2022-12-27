package pet.project.MenuScreenActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

import pet.project.MenuScreen;

public class Gear extends Actor {
    public Sprite gear1 = new Sprite(new Texture(Gdx.files.internal("settingsGear.png")));
    Sprite gear2 = new Sprite(new Texture(Gdx.files.internal("settingsGear.png")));
    public static final int X = 1100;
    public static final int Y = 200;
    public static final float ORIGIN_WIDTH = 88;
    public static final float ORIGIN_HEIGHT = 88;

    public Gear() {
        setOrigin(Align.center);
        setScale(MenuScreen.SCALE);
        setBounds(X,Y,ORIGIN_WIDTH * getScaleX(),ORIGIN_HEIGHT * getScaleY());
        setRotation(1);
        startPos(gear2);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        gear1.setBounds(getX(), getY(),getWidth(), getHeight());
        //System.out.println("хуй хуй хуй " + getX() + "[eq [eq " + getY());
        gear2.setBounds(getX() + (int)  ((float) getWidth() * Math.sqrt(1f/2f)) - 2,
                getY() + (int) ((float) (getHeight()) * Math.sqrt(1f/2f)) - 2,getWidth(),getHeight());
        //System.out.println("пизда пизда пизда пизда " + gear2.getX() + "[eq [eq " + gear2.getY());
        gear1.rotate(getRotation());
        gear2.rotate(-getRotation());
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        gear1.draw(batch);
        gear2.draw(batch);
    }
    private void startPos(Sprite gear){
        gear1.setOrigin(ORIGIN_WIDTH / 2f * getScaleX(),ORIGIN_HEIGHT / 2f * getScaleY());
        gear2.setOrigin(ORIGIN_WIDTH / 2f * getScaleX(),ORIGIN_HEIGHT / 2f * getScaleY());
        gear.rotate(15);
    }
}
