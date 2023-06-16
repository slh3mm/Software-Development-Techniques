import java.util.ArrayList;
public class User {
    public static void main(String[] args) {}
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed;

    public void rateMeme(Meme meme, int rating) {
    }

    public Meme createMeme(BackgroundImage image, String caption) {
        return null;
    }

    public boolean deleteMeme(Meme meme) {
        return false;
    }

    public void shareMeme(Meme meme, Feed feed) {
    }

    public void rateNextMemeFromFeed(Feed feed, int ratingScore) {
    }

    public double calculateReputation() {
        return 0.0;
    }
    public String toString() {
        return "";
    }
    public boolean equals(Object object1){
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }

    public ArrayList<Meme> getMemesViewed() {
        return memesViewed;
    }

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

