import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meme implements Comparable<Meme>  {
    //Meme Fields
    private User creator;
    private BackgroundImage backgroundImage;
    private Rating[] ratings;
    private String caption;
    private String captionVerticalAlign;
    private boolean shared;

    //Meme Default Constructor
    public Meme() {
        this.setCreator(new User());
        this.setBackgroundImage(new BackgroundImage());
        this.setRatings(new Rating[10]);
        this.setCaption("");
        this.setCaptionVerticalAlign("bottom");
        this.setShared(false);
    }

    //Meme Overloaded Constructor
    public Meme(BackgroundImage backgroundImage, String caption, User creator){
        this.setBackgroundImage(backgroundImage);
        this.setCaption(caption);
        this.setCaptionVerticalAlign("bottom");
        this.setRatings(new Rating[10]);
        this.setCreator(creator);
        this.setShared(false);
    }

    //Main Method
    public static void main(String[] args) {

    }

    //addRating
    public boolean addRating(Rating myRating){
        Rating[] newRatings = new Rating[10];
        if (this.ratings != null) {
            for (int i = 0; i < ratings.length; i++) {
                if (this.ratings[i] == null) {
                    this.ratings[i] = myRating;
                    return true;
                }
            }
            for (int k = 0; k < ratings.length - 1; k++) {
                newRatings[k] = this.ratings[k + 1];
                if (k == ratings.length - 2) {
                    newRatings[ratings.length - 1] = myRating;
                }
            }
            this.setRatings(newRatings);
        }
        return true;
    }

    //calculateOverallRating
    public double calculateOverallRating(){
        double ratingSum = 0.0;
        if (ratings != null){
            for (Rating m : ratings) {
                if (m != null){
                    ratingSum = ratingSum + m.getScore();
                }
            }
        }
        return ratingSum;
    }

//OVERRIDDEN METHODS
    //toString
    @Override
    public String toString(){
        int n = 0;
        int p = 0;
        for (int i = 0; i < ratings.length; i++){
            if (this.ratings[i] != null){
                if (this.ratings[i].getScore() == -1){
                    n = n + 1;
                }
                else if (this.ratings[i].getScore() == 1){
                    p = p + 1;
                }
            }
        }
        String returnString = this.backgroundImage + " '" + this.caption + "' " +
                calculateOverallRating() + " [+1: " + p + ", -1: " + n +"] - created by "
                + this.getCreator().getUserName();
        return returnString;
    }

    //equals
    @Override
    public boolean equals(Object myObj){
        if(myObj == null){
            return false;
        }
        else if (myObj instanceof Meme){
            Meme myMeme = (Meme) myObj;
            if(this.getCreator().equals(myMeme.creator) &&
                    this.getBackgroundImage().equals(myMeme.backgroundImage) &&
                    this.getCaption().equals(myMeme.caption)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    //compareTo
    @Override
    public int compareTo(Meme o) {
        int returnVal = this.caption.compareTo(o.caption);
        if (returnVal != 0) {
            return returnVal;
        }
        returnVal = this.backgroundImage.compareTo(o.backgroundImage);
        if (returnVal != 0) {
            return returnVal;
        }
        returnVal = -Double.compare(this.calculateOverallRating(), o.calculateOverallRating());
        if (returnVal != 0){
            return returnVal;
        }
        return -Boolean.compare(this.shared, o.shared);

    }
    //GETTERS
    public User getCreator() {
        return creator;
    }

    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    public Rating[] getRatings() {
        return ratings;
    }

    public String getCaption() {
        return caption;
    }

    public String getCaptionVerticalAlign() {
        return captionVerticalAlign;
    }
    public boolean getShared(){
        return shared;
    }


    //SETTERS
    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public void setRatings(Rating[] ratings) {
        this.ratings = ratings;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
        boolean value = false;
        if (captionVerticalAlign.equals("top") || captionVerticalAlign.equals("middle") || captionVerticalAlign.equals("bottom")){
            value = true;
            this.captionVerticalAlign = captionVerticalAlign;
        }
        return value;
    }

    public void setShared(boolean shared){
        this.shared = shared;
    }
}

