package pet.project;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

import pet.project.MenuScreenActors.Background;
import pet.project.MenuScreenActors.Gear;

public class MenuScreen implements Screen {
    //object of main class
    static SurvIVEit survObject;

    public final int START_BUTTON_WIDTH = 300;
    public final int START_BUTTON_HEIGHT = 100;
    public final int SETTINGS_BUTTON_SIZE = 150;

    public static final float SCALE = 1.7f;


    //stage that represents the area where all the other objects move
    public Stage stage;

    //startButton
    Button startBut;
    Button settingsBut;
    //skin for startButton
    Skin playSkin;
    Skin settingsSkin;

    //actor for main menu background
    Actor background;
    //actor for setting's gears
    Actor gear;


    public MenuScreen(SurvIVEit survObject){
        this.survObject = survObject;
    }

    @Override
    public void show() {
        playSkin = new Skin(Gdx.files.internal("gop.json"));
        settingsSkin = new Skin(Gdx.files.internal("settingsButton.json"));

        background = new Background(survObject);
        gear = new Gear();

        survObject.camera.position.set(survObject.camera.viewportWidth / 2, survObject.camera.viewportHeight / 2, 0);

        stage = new Stage(survObject.view, survObject.batch);

        startBut = new ImageButton(playSkin);
        settingsBut = new Button(settingsSkin);

        startBut.setTransform(true);
        settingsBut.setTransform(true);

        startBut.scaleBy(SCALE * 0.8f);
        settingsBut.scaleBy(SCALE * 0.7f);

        startBut.setOrigin(Align.center);
        settingsBut.setOrigin(Align.center);
        settingsBut.setBounds(Gear.X + 10 +  (int) ((float) Gear.ORIGIN_WIDTH * SCALE * Math.sqrt(1f/2f) / 2),
                Gear.Y + 10 + (int) ((float) Gear.ORIGIN_WIDTH * SCALE * Math.sqrt(1f/2f)/2),SETTINGS_BUTTON_SIZE,SETTINGS_BUTTON_SIZE);
        startBut.setBounds((float) survObject.camera.viewportWidth / 2,survObject.camera.viewportHeight / 3,
                START_BUTTON_WIDTH,START_BUTTON_HEIGHT);

        startBut.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                survObject.setScreen(new GameScreen(survObject));
            }
        });
        stage.addActor(background);
        stage.addActor(startBut);
        stage.addActor(settingsBut);
        stage.addActor(gear);
        stage.addActor(new Snake(survObject));
        gear.setTouchable(Touchable.disabled);
        Gdx.input.setInputProcessor(stage);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        playSkin.dispose();
        settingsSkin.dispose();
    }

    @Override
    public void dispose() {
        playSkin.dispose();
        settingsSkin.dispose();
    }
}
