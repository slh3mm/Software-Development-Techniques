import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Feed {
    //Feed Fields
    private ArrayList<Meme> memes;
    private Meme meme;

    //Main Method
    public static void main(String[] args) {
        //Creator Objects
        User creator1 = new User();
        User creator2 = new User();

        //Background Image Objects
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        BackgroundImage backgroundImage2 = new BackgroundImage();
        backgroundImage2.setImageFileName("ImageFileName2");
        backgroundImage2.setTitle("Title2");
        backgroundImage2.setDescription("Description2");

        //First Meme Object
        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(creator1);
        meme1.setShared(false);

        //Second Meme Object
        Meme meme2 = new Meme();
        meme2.setBackgroundImage(backgroundImage2);
        meme2.setCaption("Caption2");
        meme2.setCreator(creator2);
        meme2.setShared(true);

        Feed feed1 = new Feed();
        ArrayList<Meme> feedmemes1 = new ArrayList<Meme>();
        feedmemes1.add(meme1);
        feedmemes1.add(meme2);
        feedmemes1.add(meme1);
        feedmemes1.add(meme2);
        feedmemes1.add(meme1);
        feedmemes1.add(meme2);

        ArrayList<Meme> feedmemes2 = new ArrayList<Meme>();
        feedmemes1.add(meme2);
        feedmemes1.add(meme2);
        feedmemes1.add(meme1);
        feedmemes1.add(meme1);
        feedmemes1.add(meme2);
        feedmemes1.add(meme2);

        //sortByCaption
        OrderableFeed ofeed1 = new OrderableFeed();

        ofeed1.setMemes(feedmemes1);
        ofeed1.sortByCaption();
        System.out.println(ofeed1.getMemes());

        ofeed1.setMemes(feedmemes2);
        ofeed1.sortByCaption();
        System.out.println(ofeed1.getMemes());

        //sortByRating
        ofeed1.setMemes(feedmemes1);
        ofeed1.sortByRating();
        System.out.println(ofeed1.getMemes());

        ofeed1.setMemes(feedmemes2);
        ofeed1.sortByRating();
        System.out.println(ofeed1.getMemes());

        //sortByCreator
        ofeed1.setMemes(feedmemes1);
        ofeed1.sortByCreator();
        System.out.println(ofeed1.getMemes());

        ofeed1.setMemes(feedmemes2);
        ofeed1.sortByCreator();
        System.out.println(ofeed1.getMemes());
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
