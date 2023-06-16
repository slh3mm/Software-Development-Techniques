import java.util.ArrayList;

public class Feed {
    //Feed Fields
    private ArrayList<Meme> memes;
    private Meme object5;

    //Main Method
    public static void main(String[] args) {
    }

    //toString
    @Override
    public String toString() {
        return "";
    }

    //GETTERS
    public Meme getNewMeme(User user) {
        return null;
    }

    public ArrayList<Meme> getMemes() {
        return memes;
    }

    public Meme getObject5() {
        return object5;
    }

    //SETTERS
    public void setMemes(ArrayList<Meme> memes) {
        this.memes = memes;
    }

    public void setObject5(Meme object5) {
        this.object5 = object5;
    }
}
