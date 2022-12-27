package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Miner extends Actor {
    public static Miner miner;
    Sprite spriteMiner;
    SurvIVEit survIVEitObj;
    TextureAtlas minerStepAtlas;
    Animation <TextureRegion> minerStepAnim;
    private Miner(SurvIVEit survIVEitObj){
        this.survIVEitObj = survIVEitObj;
        setBounds(survIVEitObj.camera.viewportWidth / 9 * 4, 0,160,160);
        spriteMiner = new Sprite(new Texture("miner.png"));
        minerStepAtlas = new TextureAtlas(Gdx.files.internal("minerStepAtlas.atlas"));

        minerStepAnim = new Animation<TextureRegion>(1f/15f,minerStepAtlas.getRegions(), Animation.PlayMode.REVERSED);

    }
    public static Miner getminer(SurvIVEit survIVEitObj){
        if(miner == null){
            miner = new Miner(survIVEitObj);
        }
        return miner;
    }

    public void act(float delta){
        spriteMiner.setBounds(getX(),getY() + 160,getWidth(),getHeight());
        System.out.println(miner.getX() + " " + miner.getY());
        System.out.println(spriteMiner.getY());

    }
    public void draw(Batch batch, float alpha){
        super.draw(batch,alpha);
        batch.draw(minerStepAnim.getKeyFrame(GameScreen.time_animation,false),getX() ,getY());;
        spriteMiner.draw(batch);
    }

}
