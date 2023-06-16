import java.util.ArrayList;

public class Feed {
    //Feed Fields
    private ArrayList<Meme> memes;
    private Meme meme;

    //Main Method
    public static void main(String[] args) {
        BackgroundImage newBIM1 = new BackgroundImage();
        newBIM1.setImageFileName("FNAME1");
        newBIM1.setTitle("TITL1");
        newBIM1.setDescription("DESC1");

        //Second BackgroundImage Object
        BackgroundImage newBIM2 = new BackgroundImage();
        newBIM2.setImageFileName("FNAME2");
        newBIM2.setTitle("TITL2");
        newBIM2.setDescription("DESC2");

        //New Creators
        User creator1 = new User("creator1");
        User creator2 = new User();

        //First Meme Object
        Meme mem1 = new Meme();
        mem1.setBackgroundImage(newBIM1);
        mem1.setCaption("CAP1");
        mem1.setCreator(creator2);

        //Second Meme Object
        Meme mem2 = new Meme();
        mem2.setBackgroundImage(newBIM2);
        mem2.setCaption("CAP2");
        mem2.setCreator(creator1);

        //Third Meme Object
        Meme mem3 = new Meme();
        mem3.setBackgroundImage(newBIM2);
        mem3.setCaption("CAP3");
        mem3.setCreator(creator1);

        //Fourth Meme Object
        Meme mem4 = new Meme();
        mem4.setBackgroundImage(newBIM1);
        mem4.setCaption("CAP4");
        mem4.setCreator(creator2);

        creator1.getMemesViewed().add(mem1);
        creator1.getMemesViewed().add(mem2);
        creator1.getMemesCreated().add(mem1);
        creator1.getMemesCreated().add(mem2);

        Feed feed1 = new Feed();

        //feed1.getMemes().add(mem1);
        feed1.getMemes().add(mem3);

        System.out.println(feed1.getNewMeme(creator1));

        //toString

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
