package pet.project;

import  com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class GameScreen implements Screen {

    //original amount of dirt blocks
    public static final int KOLVOZZEMLI = 9*30;

    private boolean isAction = false;

    //objects of this stage; miner; lists of snake, dirt and snakeShots objects
    private Stage stage;           //show method initializing
    private final Miner miner;           //constructor initializing
    private  ArrayList<Snake> snakezzzz = new ArrayList<>();
    private ArrayList<Ground> groundzzzz = new ArrayList<>();
    private ArrayList<SnakeShhhoot> shotzz = new ArrayList<>();

    //bool of miner animation
    private boolean start = false;
    //time of animation start and animation lastStarted time
    static float time_animation = 0f;
    static float lastTime = 0f;
    {
        miner = Miner.getminer();
    }

    @Override
    public void show() {

        stage = new Stage(Interlayer.survObj.view, Interlayer.survObj.batch);
        // i don't know if this string should exist//stage.getCamera().position.set(survObj.camera.viewportWidth / 2, survObj.camera.viewportHeight /2,0);
        // i don't know if this string should exist//lastTime = TimeUtils.millis();

        // sets input events handler on this stage
        Gdx.input.setInputProcessor(stage);


        //adds "dirt" actors and sets it's position
        for (int i = 0; i < KOLVOZZEMLI; i++){
            groundzzzz.add(new Ground());
            //visibility of initial dirt block, placed under the miner
            /*if(i == 4){
                groundzzzz.get(i).setVisible(false);
            }*/
            groundzzzz.get(i).setPosition(160 * (i % 9 ),160* (int) ((int) i / (int) 9));
            stage.addActor(groundzzzz.get(i));
        }

        //adds "snakes' shots" actors and sets their positions
        for (int i = 0; i < 10; i++){
            snakezzzz.add(new Snake());
            snakezzzz.get(i).setPosition(160 * i, 160 * i);
            //for(int m = 0; m < 10; m++){
                shotzz.add(new SnakeShhhoot(snakezzzz.get(i)));
                shotzz.get(i).setPosition(snakezzzz.get(i).getX(),snakezzzz.get(i).getY()); //было m
                stage.addActor(shotzz.get(i)); //было m
           // }
            stage.addActor(snakezzzz.get(i));
        }
        //adds "miner" actor
        stage.addActor(miner);


        // snake's shots should be over the miner
        for(SnakeShhhoot snake : shotzz){
            snake.setZIndex(miner.getZIndex()); //setZIndex defines the position of elements in Z coordinate (objects overlaps).
        }

        //adds moves for my miner (start with simple one)
        stage.addListener(new ActorGestureListener(){
            @Override
            public void fling(InputEvent event, float velocityX, float velocityY, int button) {
                super.fling(event, velocityX, velocityY, button);
                if(true){
                    if (velocityX > 0){
                        miner.addAction(Actions.moveBy(160, 0, miner.minerStepAnim.getAnimationDuration()));
                    }
                    else if (velocityX < 0){
                        miner.addAction(Actions.moveBy(-160, 0, miner.minerStepAnim.getAnimationDuration()));
                    }
                }
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);

        //fixates touch and starts miner's animation
        if(Gdx.input.isTouched() && isAction == false){
            lastTime = TimeUtils.millis();
            isAction = true;
        }
        if(isAction){
            time_animation += delta;
        }
        //if animation is finished -> time animation resets and miner can move again
        if(miner.minerStepAnim.isAnimationFinished(time_animation)){
            time_animation = 0f;
            isAction = false;
        }
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
        stage.dispose();
        Interlayer.survObj.dispose();
    }
}
