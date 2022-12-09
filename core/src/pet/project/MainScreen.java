package pet.project;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.sql.Time;

public class MainScreen implements Screen {
    SurvIVEit survObject;
    Long Lasttime;
    Texture menuText ;
    Texture pop;
    float m = 0;
    long lastTime;
    boolean goo = false;
    private float time_animation = 0f;
    public MainScreen(SurvIVEit survObject){
        this.survObject = survObject;
    }

    @Override
    public void show() {
        Lasttime = TimeUtils.millis();
        menuText = new Texture("shakta.png");
        lastTime = TimeUtils.millis();
        pop = new Texture("ground1.png");
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
        if(m > 160){
            m = 160;
        }

            survObject.camera.update();
            survObject.batch.setProjectionMatrix(survObject.camera.combined);
            survObject.batch.begin();

            survObject.batch.draw(menuText,0,0, 160,160);
            survObject.batch.draw(pop,160,0, 160,160);
            //survObject.batch.draw(survObject.ty,260,100);
        if(goo){
            survObject.batch.draw(survObject.minerStepAnim.getKeyFrame(time_animation,false),m,160);
        }
        else{
            survObject.batch.draw(survObject.minerStepAnim.getKeyFrame(0,false),0,160);
        }
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
        survObject.minerStepAtlas.dispose();
    }
}
