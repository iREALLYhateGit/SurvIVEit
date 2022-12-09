package pet.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SurvIVEit extends Game {
	public final int WORLD_WIDTH = 3200 * 3, WORLD_HEIGHT = 1440 * 3;
	SpriteBatch batch;
	Viewport view;
	OrthographicCamera camera;
	TextureAtlas minerStepAtlas;
	Texture ty;
	Animation <TextureRegion> minerStepAnim;
	FirstLaunchNotifier ff;
	float asp;
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		view = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
		asp = ((float) Gdx.graphics.getHeight())/ ((float) Gdx.graphics.getWidth());

		camera.setToOrtho(false, (int) (((float) WORLD_HEIGHT) / 3 / asp), WORLD_HEIGHT / 3);
		minerStepAtlas = new TextureAtlas(Gdx.files.internal("minerStepAtlas.atlas"));
		ty = new Texture(Gdx.files.internal("shoot.png"));
		minerStepAnim = new Animation<TextureRegion>(1f/15f,minerStepAtlas.getRegions(), Animation.PlayMode.REVERSED);
		ff = FirstLaunchNotifier.getInstance();
		ff.saveLaunchState(true);
		if(ff.getLaunchBoolean()){
			setScreen(new MainScreen(this));
		}
		else{
			setScreen(new GameScreen(new MainScreen(this)));
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}


}
