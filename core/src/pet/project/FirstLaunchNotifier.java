package pet.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class FirstLaunchNotifier {
    private static FirstLaunchNotifier instance;
    private Preferences prefs;
    private boolean launchBoolean;

    private static final String PREF_NAME = "Prefs";
    private static final String LAUNCH_KEY = "launch";

    private FirstLaunchNotifier(){
        prefs= Gdx.app.getPreferences(PREF_NAME);
        launchBoolean = prefs.getBoolean(LAUNCH_KEY, true);
    }

    public static FirstLaunchNotifier getInstance(){

        if( instance == null ){
            instance = new FirstLaunchNotifier();
        }
        return instance;
    }

    public void saveLaunchState(boolean state) {
        launchBoolean = state;
        prefs.putBoolean(LAUNCH_KEY, launchBoolean);
        prefs.flush();
    }

    public boolean getLaunchBoolean() {
        return launchBoolean;
    }
}
