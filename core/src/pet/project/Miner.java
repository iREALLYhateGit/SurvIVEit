package pet.project;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Miner extends Actor {
    public static Miner miner;
    Texture imgMiner;
    Sprite spriteMiner;
    SurvIVEit survIVEitObj;
    private Miner(SurvIVEit survIVEitObj){
        this.survIVEitObj = survIVEitObj;
        setBounds(survIVEitObj.camera.position.x,survIVEitObj.camera.position.y,150,150);
        imgMiner = new Texture("miner.png");
        spriteMiner = new Sprite(imgMiner);
    }
    public static Miner getminer(SurvIVEit survIVEitObj){
        if(miner == null){
            miner = new Miner(survIVEitObj);
        }
        return miner;
    }

    public void act(float delta){
        spriteMiner.setBounds(getX(),getY(),getWidth(),getHeight());
    }
    public void draw(Batch batch, float alpha){
        //super.draw(batch,alpha);
        spriteMiner.draw(batch);
    }

}
