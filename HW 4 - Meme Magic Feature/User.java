import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.ArrayList;


public class User implements Comparable<User>{
    //User Fields
    private String userName;
    private ArrayList<Meme> memesCreated;
    private TreeSet<Meme> memesViewed;

    //Overloaded Constructor
    public User(String userName){
        this.setUserName(userName);
        this.setMemesCreated(new ArrayList<Meme>());
        this.setMemesViewed(new TreeSet<Meme>());
    }

    //Default Constructor
    public User(){
        this.setUserName("");
        this.setMemesCreated(new ArrayList<Meme>());
        this.setMemesViewed(new TreeSet<Meme>());
    }
    //Main Method
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");

        //compareTo
        System.out.println(user1.compareTo(user2));
        System.out.println(user1.compareTo(user1));
    }

    //rateMeme
    public boolean rateMeme(Meme meme, int score) {
        if(meme != null) {
            getMemesViewed().add(meme);
            Rating newRating = new Rating(this, score);
            meme.addRating(newRating);
            return true;
        }
        return false;
    }

    //createMeme
    public Meme createMeme(BackgroundImage cImage, String cCaption) {
        if (cImage == null || cCaption == null || this.getMemesCreated() == null){
            return null;
        }
        Meme cMeme = new Meme();
        cMeme.setBackgroundImage(cImage);
        cMeme.setCaption(cCaption);
        cMeme.setCreator(this);

        this.getMemesCreated().add(cMeme);
        return cMeme;
    }

    //deleteMeme
    public boolean deleteMeme(Meme meme) {
        if(getMemesCreated() == null || getMemesCreated().size() == 0){
            return false;
        }
        for (Meme indexMeme : getMemesCreated()){
            if (!indexMeme.getShared() && meme.equals(indexMeme)){
                meme.getCreator().getMemesCreated().remove(indexMeme);
                return true;
            }
        }
        return false;
    }

    //shareMeme
    public boolean shareMeme(Meme meme, Feed feed) {
        if(meme != null && feed != null) {
            meme.setShared(true);
            feed.getMemes().add(meme);
            return true;
        }
        return false;
    }

    //rateNextMemeFromFeed
    public boolean rateNextMemeFromFeed(Feed theFeed, int ratingScore){
        if(this.getMemesViewed() == null || theFeed == null || theFeed.getMemes() == null || theFeed.getMemes().size() == 0){
            return false;
        }
        Rating tempRating = new Rating(this, ratingScore);
        Meme tempMeme = theFeed.getNewMeme(this);
        if (tempMeme == null){
            return false;
        }
        tempMeme.addRating(tempRating);
        getMemesViewed().add(tempMeme);

        return true;
    }

    //calculateReputation
    public double calculateReputation() {
        double rep = 0.0;
        if (getMemesCreated() == null || getMemesCreated().size() == 0) {
            return 0.0;
        }
        for (int i = 0; i < getMemesCreated().size(); i++){
            rep += getMemesCreated().get(i).calculateOverallRating();
        }
        return rep / getMemesCreated().size();
    }

//OVERRIDDEN METHODS
    //toString
    @Override
    public String toString() {
        if(getMemesViewed() != null && getMemesViewed().size() != 0){
            return getUserName() + " has rated " + "(" + getMemesViewed().size() + ") memes, " + "(" +calculateReputation()+ ")";
        }
        else {
            return getUserName()+ " has rated (0) memes, " + "(" + calculateReputation()+ ")";
        }
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        else if(o instanceof User){
            User tempUser = (User) o;
            if(this.getUserName().equals(tempUser.userName)){
                return true;
            }
        }
        return super.equals(o);
    }

    //compareTo
    @Override
    public int compareTo(User o) {
        int returnVal = this.userName.compareTo(o.userName);
        if (returnVal != 0){
            return returnVal;
        }
        return -Integer.compare(this.memesCreated.size(), o.memesCreated.size());
    }

    //GETTERS
    public String getUserName() {
        return userName;
    }

    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }

    public ArrayList<Meme> getMemesViewed() {
        ArrayList<Meme> memesV = new ArrayList<Meme>();
        memesV.addAll(memesViewed);
        return memesV;
    }

    //SETTERS
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMemesCreated(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }

    public void setMemesViewed(TreeSet<Meme> memesViewed) {
        this.memesViewed = memesViewed;
    }

}

