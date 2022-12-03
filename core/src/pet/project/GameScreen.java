package pet.project;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    SurvIVEit survObject;
    MainScreen mainscreen;
    Stage stage;
    Miner miner;

    public GameScreen(MainScreen mainscreen){
        this.mainscreen = mainscreen;
        this.survObject = mainscreen.survObject;
    }

    @Override
    public void show() {
        stage = new Stage(survObject.view, survObject.batch);
        miner = Miner.getminer(survObject);
        System.out.println(stage.getHeight() + " " +  stage.getWidth());
        stage.addActor(miner);
        stage.getCamera().position.set(survObject.WORLD_WIDTH/2,survObject.WORLD_HEIGHT/2,0);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        /*survObject.camera.update();
        survObject.batch.setProjectionMatrix(survObject.camera.combined);*/
        stage.act(delta);
        stage.draw();
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

    }
}
