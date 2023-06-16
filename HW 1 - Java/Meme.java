public class Meme {
    public static void main(String[] args) {}
    private User creator;
    private BackgroundImage backgroundImage;
    private Rating[] ratings;
    private String caption;
    private String captionVerticalAlign;
    private boolean shared;

    public boolean addRating(Rating myRating){
        return false;
    }
    public double calculateOverallRating(){
        return 0.0;
    }
    public String toString() {
        return null;
    }
    public boolean equals(Object object3) {
        return false;
    }

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

    public boolean getShared() {
        return shared;
    }

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

    public void setCaptionVerticalAlign(String captionVerticalAlign) {
        this.captionVerticalAlign = captionVerticalAlign;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
