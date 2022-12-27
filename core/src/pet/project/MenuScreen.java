package pet.project;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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

    //buttons "play" and "settings" size parameters
    private final int START_BUTTON_WIDTH = 300;
    private final int START_BUTTON_HEIGHT = 100;
    private final int SETTINGS_BUTTON_SIZE = 150;

    //scaling parameter *Button * scale = real button in world*
    public static final float SCALE = 1.7f;


    //stage that represents the area where all the other objects move
    private final Stage stage = new Stage(Interlayer.survObj.view, Interlayer.survObj.batch);

    //startButton
    private Button startBut;
    private Button settingsBut;
    //skin for startButton
    private Skin playSkin;
    private Skin settingsSkin;

    //actor for main menu background
    private Actor background;
    //actor for setting's gears
    private Actor gear;

    @Override
    public void show() {
        playSkin = new Skin(Gdx.files.internal("gop.json"));
        settingsSkin = new Skin(Gdx.files.internal("settingsButton.json"));

        background = new Background();
        gear = new Gear();

        Interlayer.survObj.camera.position.set(Interlayer.survObj.camera.viewportWidth / 2, Interlayer.survObj.camera.viewportHeight / 2, 0);

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
        startBut.setBounds((float) Interlayer.survObj.camera.viewportWidth / 2, Interlayer.survObj.camera.viewportHeight / 3,
                START_BUTTON_WIDTH,START_BUTTON_HEIGHT);

        startBut.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Interlayer.survObj.setScreen(Interlayer.interlayer.gameScreen);
            }
        });
        stage.addActor(background);
        stage.addActor(startBut);
        stage.addActor(settingsBut);
        stage.addActor(gear);
        gear.setTouchable(Touchable.disabled);
        // sets input events handler
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
        stage.dispose();
        playSkin.dispose();
        settingsSkin.dispose();
    }
}
