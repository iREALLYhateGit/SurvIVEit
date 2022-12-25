package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
    SurvIVEit survObject;
    MainScreen mainscreen;
    Stage stage;
    Miner miner;
    protected static float m = 1600;
    long lastTime;
    boolean goo = false;
    protected static float time_animation = 0f;

    public GameScreen(MainScreen mainscreen){
        this.mainscreen = mainscreen;
        this.survObject = mainscreen.survObject;
        miner = Miner.getminer(survObject);
    }

    @Override
    public void show() {
        stage = new Stage(survObject.view, survObject.batch);
        stage.addActor(miner);
        stage.getCamera().position.set(2000,2000,0);
        lastTime = TimeUtils.millis();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isTouched()){
            survObject.ff.saveLaunchState(true);
            goo = true;
            lastTime = TimeUtils.millis();
        }
        if(goo){
            m+= 160f / 60f;
            System.out.println(Gdx.graphics.getFramesPerSecond());
            time_animation += delta;
        }
        ScreenUtils.clear(Color.WHITE);
        if(m > 2000){
            m = 2000;
        }
        stage.act(delta);

        if(goo){
            stage.draw();
        }
        /*else{
            //survObject.batch.draw(survObject.minerStepAnim.getKeyFrame(0,false),0,160);
        }*/
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
        survObject.dispose();
    }
}
