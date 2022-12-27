package pet.project;

//here we can collect all the objects of screens. I mean, we don't need to produce lot's of screens. One object for every Screen.
public class Interlayer {
    static Interlayer interlayer;
    public static SurvIVEit survObj;
    public final MenuScreen menuScreen;
    public final GameScreen gameScreen;
    private Interlayer(SurvIVEit survObj){
        Interlayer.survObj = survObj;
        this.menuScreen = new MenuScreen();
        this.gameScreen = new GameScreen();
    }

    public static Interlayer getInterlayer(SurvIVEit survObj) {
        if(interlayer == null){
            interlayer = new Interlayer(survObj);
        }
        return interlayer;
    }
}
