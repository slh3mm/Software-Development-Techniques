import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Feed {
    //Feed Fields
    private ArrayList<Meme> memes;
    private Meme meme;

    //Main Method
    public static void main(String[] args) {
    }

    //Default Cosntructor
    public Feed(){
        this.setMemes(new ArrayList<Meme>());
        this.setMeme(new Meme());
    }
    //toString
    @Override
    public String toString() {
        String returnString = "";
        if(this.getMemes() != null && this.getMemes().size() != 0){
            for (Meme feedMeme : this.getMemes()){
                if(feedMeme != null){
                    returnString = returnString + feedMeme.toString() + "\n";
                }
            }
        }
        return returnString;
    }

    //GETTERS
    public Meme getNewMeme(User user) {
        for(Meme indexMeme : getMemes()){
            if(!user.getMemesViewed().contains(indexMeme) &&
                    !user.getMemesCreated().contains(indexMeme)){
                return indexMeme;
            }
        }
        return null;
    }

    public ArrayList<Meme> getMemes() {
        return memes;
    }

    public Meme getMeme() {
        return meme;
    }

    //SETTERS
    public void setMemes(ArrayList<Meme> memes) {
        this.memes = memes;
    }

    public void setMeme(Meme meme) {
        this.meme = meme;
    }
}
