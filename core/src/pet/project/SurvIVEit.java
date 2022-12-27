package pet.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SurvIVEit extends Game {
	// setting world's sizes.
	public final int WORLD_WIDTH = 1440 * 3, WORLD_HEIGHT = 3200 * 3;
	SpriteBatch batch;
	Viewport view;
	public OrthographicCamera camera;

	// launcher that indicates, if it is the first game start
	FirstLaunchNotifier ff;

	//real worls aspectRatio
	public float asp;


	// method that starts the whole project
	@Override
	public void create () {
		// sets input events handler
		Gdx.input.setInputProcessor(new MyInputProccessor());
		batch = new SpriteBatch();
		camera = new OrthographicCamera();

		//sets real aspectRatio
		asp = ((float) Gdx.graphics.getHeight())/ ((float) Gdx.graphics.getWidth());

		//sets camera sizes depends on aspectRatio
		camera.setToOrtho(false, WORLD_WIDTH / 3, (int) ((float) WORLD_WIDTH / 3 ) * asp);
		view = new StretchViewport(WORLD_WIDTH / 3, WORLD_HEIGHT/3, camera);

		//initializing launcher
		ff = FirstLaunchNotifier.getInstance();

		//starting screens
		setScreen(new MenuScreen(this));
		if(ff.getLaunchBoolean()){
			setScreen(new MenuScreen(this));
			ff.saveLaunchState(false);
		}
		else{
			//тут будет запуск обучения для нового игрока
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
