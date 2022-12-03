package pet.project;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class MainScreen implements Screen {
    SurvIVEit survObject;
    Long Lasttime;
    Texture menuText ;
    public MainScreen(SurvIVEit survObject){
        this.survObject = survObject;
    }

    @Override
    public void show() {
        Lasttime = TimeUtils.millis();
        menuText = new Texture("shakta.png");
    }

    @Override
    public void render(float delta) {
        if(TimeUtils.millis() - Lasttime > 1000){
            survObject.setScreen(new GameScreen(this));
        }
        survObject.camera.update();
        survObject.batch.setProjectionMatrix(survObject.camera.combined);
        survObject.batch.begin();
        survObject.batch.draw(menuText,0,0);
        survObject.batch.end();
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
