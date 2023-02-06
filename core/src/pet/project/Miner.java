package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

//requires:
// make getter for StepAnimation
public class Miner extends Actor {
    private static Miner miner;
    //visible things
    private final TextureAtlas minerStepAtlas;
    public Animation <TextureRegion> minerStepAnim;

    private Miner(){
        setBounds(Interlayer.survObj.camera.viewportWidth / 9 * 4, 0,160,160);

        minerStepAtlas = new TextureAtlas("minerStepAtlas.atlas");

        minerStepAnim = new Animation<TextureRegion>(1f/15f,minerStepAtlas.getRegions(), Animation.PlayMode.REVERSED);

        //adds listener to movements
        /*addListener(new ActorGestureListener(){
            @Override
            public void fling(InputEvent event, float velocityX, float velocityY, int button) {
                super.fling(event, velocityX, velocityY, button);
                if(velocityX > 0){
                    miner.setX(miner.getX() + 1000);
                }
            }
        });*/

    }
    public static Miner getminer(){
        if(miner == null){
            miner = new Miner();
        }
        return miner;
    }

    public void act(float delta){
        super.act(delta);
        /*System.out.println(miner.getX() + " " + miner.getY());
        System.out.println(spriteMiner.getY());*/

    }
    public void draw(Batch batch, float alpha){
        super.draw(batch,alpha);
        batch.draw(minerStepAnim.getKeyFrame(GameScreen.time_animation,false),getX() ,getY());
    }
}
