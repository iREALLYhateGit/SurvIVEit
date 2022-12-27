package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SnakeShhhoot extends Actor {
    Sprite shootImg = new Sprite(new Texture(Gdx.files.internal("shoot.png")));
    Snake snake;

    //public boolean isAlive = true;
    public SnakeShhhoot(Snake snake) {
        setBounds(snake.getX() + 160, snake.getY(), 80,80);
        rotateBy(90);
        shootImg.rotate(90);
        this.snake = snake;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setPosition(getX() + 4, getY());
        if(getX() > getStage().getCamera().viewportWidth){
            setX(snake.getX());
        }
        shootImg.setBounds(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        shootImg.draw(batch);
    }
}
