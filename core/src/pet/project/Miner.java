package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.SortedIntList;

//requires:
// make getter for StepAnimation
public class Miner extends Actor {
    private static Miner miner;
    //bool of miner animation
    public boolean isAnimate = false;
    //time of animation start
    static float time_animation = 0f;
    public Queue <Boolean> queue = new Queue<>(2);
    public boolean shouldBeFlipped;
    //visible things
    private final TextureAtlas minerStepAtlas;
    public Animation <TextureRegion> minerStepAnim;

    private Miner(){
        setBounds(Interlayer.survObj.camera.viewportWidth / 9 * 4, 0,160,160);
        queue.addFirst(true);
        minerStepAtlas = new TextureAtlas("minerStepAtlas.atlas");
        minerStepAnim = new Animation<TextureRegion>(1f/30f,minerStepAtlas.getRegions(), Animation.PlayMode.REVERSED);

    }
    public static Miner getminer(){
        if(miner == null){
            miner = new Miner();
        }
        return miner;

    }

    public void act(float delta){
        super.act(delta);
        checkEnd();
        /*System.out.println(miner.getX() + " " + miner.getY());
        System.out.println(spriteMiner.getY());*/

    }
    public void draw(Batch batch, float alpha){
        super.draw(batch,alpha);
        batch.draw(minerStepAnim.getKeyFrame(time_animation,false),getX() ,getY());
    }

    public void startAnim(boolean side) {
        isAnimate = true;
        time_animation = 0;
        miner.queue.addFirst(side);
        if (queue.size > 2) {
            queue.removeLast();
        }
        if (queue.size == 2 && queue.get(0) != queue.get(1)) {
            for (TextureRegion atlas : minerStepAtlas.getRegions()) {
                atlas.flip(true, false);
            }
        }
    }
    public void checkEnd(){
        if( isAnimate){
            time_animation += GameScreen.delta;
        }
        if(miner.minerStepAnim.isAnimationFinished(time_animation)){
            isAnimate = false;
        }
    }
}
