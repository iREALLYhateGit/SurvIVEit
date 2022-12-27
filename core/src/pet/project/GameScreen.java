package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class GameScreen implements Screen {
    public static final int KOLVOZZEMLI = 9*30;
    SurvIVEit survObj;
    Stage stage;
    Miner miner;
    boolean start = false;
    ArrayList<Snake> snakezzzz = new ArrayList<>();
    ArrayList<Ground> groundzzzz = new ArrayList<>();
    ArrayList<SnakeShhhoot> shotzz = new ArrayList<>();
    long lastTime;
    protected static float time_animation = 0f;

    public GameScreen(SurvIVEit survObject){
        this.survObj = survObject;
        miner = Miner.getminer(survObject);
    }

    @Override
    public void show() {
        resize((int)survObj.camera.viewportWidth / 2, (int)survObj.camera.viewportHeight /2);
        stage = new Stage(survObj.view, survObj.batch);
        stage.getCamera().position.set(survObj.camera.viewportWidth / 2, survObj.camera.viewportHeight /2,0);
        lastTime = TimeUtils.millis();
        Gdx.input.setInputProcessor(new MyInputProccessor());

        for (int i = 0; i < KOLVOZZEMLI; i++){
            groundzzzz.add(new Ground());
            if(i == 4){
                groundzzzz.get(i).setVisible(false);
            }
            groundzzzz.get(i).setPosition(160 * (i % 9 ),160* (int) ((int) i / (int) 9));
            stage.addActor(groundzzzz.get(i));
        }

        for (int i = 0; i < 10; i++){
            snakezzzz.add(new Snake(survObj));
            snakezzzz.get(i).setPosition(160 * i, 160 * i);
            //for(int m = 0; m < 10; m++){
                shotzz.add(new SnakeShhhoot(snakezzzz.get(i)));
                shotzz.get(i).setPosition(snakezzzz.get(i).getX(),snakezzzz.get(i).getY()); //было m
                stage.addActor(shotzz.get(i)); //было m
           // }
            stage.addActor(snakezzzz.get(i));
        }
        stage.addActor(miner);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        if(Gdx.input.isTouched() && start == false){
            lastTime = TimeUtils.millis();
            start = true;
        }
        if(start){
            time_animation += delta;
        }
        if(miner.minerStepAnim.isAnimationFinished(time_animation)){
            miner.setX(survObj.camera.viewportWidth / 9 * 4);
            time_animation = 0f;
            start = false;
        }
        stage.act(delta);
        stage.draw();
        System.out.println(stage.getCamera().position.y - stage.getCamera().viewportHeight/2);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        survObj.dispose();
    }
}
