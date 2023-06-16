import java.util.ArrayList;

public class User {
    //User Fields
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed;

    //Main Method
    public static void main(String[] args) {
    }

    //rateMeme
    public void rateMeme(Meme meme, int rating) {
    }

    //createMeme
    public Meme createMeme(BackgroundImage image, String caption) {
        return null;
    }

    //deleteMeme
    public boolean deleteMeme(Meme meme) {
        return false;
    }

    //shareMeme
    public void shareMeme(Meme meme, Feed feed) {
    }

    //rateNextMemeFromFeed
    public void rateNextMemeFromFeed(Feed feed, int ratingScore) {
    }

    //calculateReputation
    public double calculateReputation() {
        return 0.0;
    }

    //toString
    @Override
    public String toString() {
        return "";
    }

    //equals
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    //GETTERS
    public String getUserName() {
        return userName;
    }

    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }

    public ArrayList<Meme> getMemesViewed() {
        return memesViewed;
    }

    //SETTERS
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMemesCreated(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }

    public void setMemesViewed(ArrayList<Meme> memesViewed) {
        this.memesViewed = memesViewed;
    }

}

