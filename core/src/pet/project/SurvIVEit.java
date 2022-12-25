package pet.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SurvIVEit extends Game {
	public final int WORLD_WIDTH = 1440 * 3, WORLD_HEIGHT = 3200 * 3;
	SpriteBatch batch;
	Skin skin;
	Button but;
	TextureAtlas butAtlas;
	TextButton.TextButtonStyle style;
	Viewport view;
	OrthographicCamera camera;
	TextureAtlas minerStepAtlas;
	Animation <TextureRegion> minerStepAnim;
	FirstLaunchNotifier ff;
	float asp;
	@Override
	public void create () {
		Gdx.input.setInputProcessor(new MyInputProccessor());
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		asp = ((float) Gdx.graphics.getHeight())/ ((float) Gdx.graphics.getWidth());
		camera.setToOrtho(false, WORLD_WIDTH / 3, (int) ((float) WORLD_WIDTH / 3 ) * asp);
		view = new FillViewport(WORLD_WIDTH / 3, WORLD_HEIGHT/3, camera);

		minerStepAtlas = new TextureAtlas(Gdx.files.internal("minerStepAtlas.atlas"));
		butAtlas = new TextureAtlas(Gdx.files.internal("minerStepAtlas.atlas"));
		style = new TextButton.TextButtonStyle();

		//skin = new Skin(Gdx.files.internal("minerStepAtlas.atlas"));
		but = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ground3.png")))));
		but.setX(2000);
		but.setY(2000);
		but.setWidth(1000);
		but.setHeight(1000);

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
		minerStepAtlas.dispose();
	}
}
