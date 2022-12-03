package pet.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SurvIVEit extends Game {
	public final int WORLD_WIDTH = 2000, WORLD_HEIGHT = 1000;
	SpriteBatch batch;
	Viewport view;
	OrthographicCamera camera;
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		view = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
		camera.setToOrtho(false, 600,600);
		setScreen(new MainScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
