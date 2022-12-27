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
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {
    //object of main class
    SurvIVEit survObject;

    //stage that represents the area where all the other objects move
    Stage stage;

    //startButton
    Button startBut;
    Button settingsBut;
    //skin for startButton
    Skin playSkin;
    Skin settingsSkin;

    //actor for main menu background
    Actor actor;
    //actor for setting's gears
    Actor gear;


    public MenuScreen(SurvIVEit survObject){
        this.survObject = survObject;
    }

    @Override
    public void show() {
        playSkin = new Skin(Gdx.files.internal("gop.json"));
        settingsSkin = new Skin(Gdx.files.internal("settingsButton.json"));
        actor = new Actor(){
            Sprite background = new Sprite(new Texture(Gdx.files.internal("menuBackground.jpg")));

            @Override
            public void act(float delta) {
                super.act(delta);
                background.setBounds(0,0,1440,3200);
            }
            @Override
            public void draw(Batch batch, float parentAlpha) {
                super.draw(batch, parentAlpha);
                background.draw(batch);
            }
        };
        gear = new Actor(){
            public Sprite background = new Sprite(new Texture(Gdx.files.internal("settingsGear.png")));
            Sprite background2 = new Sprite(new Texture(Gdx.files.internal("settingsGear.png")));

            @Override
            public void act(float delta) {
                if(getRotation() == 0){
                    background2.rotate(15);
                }
                super.act(delta);
                setBounds(1100,150,88,88);
                setScale(1.5f);
                background.setScale(1.5f);
                background2.setScale(1.5f);
                background.setBounds(gear.getX(), gear.getY(),gear.getWidth(), gear.getHeight());
                background2.setBounds(gear.getX() + (int) ( getWidth() * getScaleX() * Math.sqrt(1f/2f) - 2), gear.getY() + (int) ((float) (getHeight()) * getScaleY()* Math.sqrt(1f/2f)) - 2,gear.getWidth(), gear.getHeight());
                setRotation(1);
                background.rotate(getRotation());
                background2.rotate(-getRotation());
            }
            @Override
            public void draw(Batch batch, float parentAlpha) {
                super.draw(batch, parentAlpha);
                background.draw(batch);
                background2.draw(batch);
            }
        };
        survObject.camera.position.set(survObject.camera.viewportWidth / 2, survObject.camera.viewportHeight / 2, 0);
        stage = new Stage(survObject.view, survObject.batch);
        startBut = new ImageButton(playSkin);
        settingsBut = new Button(settingsSkin);
        startBut.setTransform(true);
        settingsBut.setTransform(true);
        startBut.scaleBy(1.2f);
        settingsBut.scaleBy(1f);
        settingsBut.setBounds(1035,90,150,150);
        startBut.setBounds(survObject.camera.viewportWidth / 2 - 300,survObject.camera.viewportHeight / 2 - 100/2,300,100);

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
        stage.addActor(actor);
        stage.addActor(startBut);
        stage.addActor(settingsBut);
        stage.addActor(gear);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        stage.act(delta);
        stage.draw();
        if(startBut.isTouchable()){
            System.out.println("click");
        }
        System.out.println(survObject.camera.position.x + "  " +  survObject.camera.position.y);
        System.out.println(startBut.getRotation());
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        survObject.dispose();
    }
}
