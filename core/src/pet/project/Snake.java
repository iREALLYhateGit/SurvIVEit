package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Snake extends Actor {

    private final Sprite snakeSkin = new Sprite(new Texture(Gdx.files.internal("monster.png")));
    private final Sound snakeDeath = Gdx.audio.newSound(Gdx.files.internal("zmey.mp3"));
    private boolean isAlive;
    Snake() {
        //Так как змеи должны рисоваться в рандомном месте, но внутри(вместо) блока земли, то координаты x и y выставляем рандомно
        setSize(160,160);
        snakeSkin.rotate(-90);
        isAlive = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        snakeSkin.setBounds(getX(),getY(),getWidth(),getHeight());
        if(!isAlive){
            snakeDeath.play();
        }
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        snakeSkin.draw(batch);
    }
}
