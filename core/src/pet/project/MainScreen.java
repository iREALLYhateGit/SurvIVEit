package pet.project;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.sql.Time;

public class MainScreen implements Screen {
    SurvIVEit survObject;
    Stage stage;


    public MainScreen(SurvIVEit survObject){
        this.survObject = survObject;
    }

    @Override
    public void show() {
        stage = new Stage(survObject.view, survObject.batch);
        //stage.addActor();
        //survObject.setScreen(new GameScreen(this));
    }

    @Override
    public void render(float delta) {

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
        survObject.dispose();
    }
}
