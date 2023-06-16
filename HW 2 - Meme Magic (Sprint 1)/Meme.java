public class Meme {
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
    }

    //Main Method
    public static void main(String[] args) {
        //BackgroundImages, Memes, and Ratings
        //First BackgroundImage Object
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
        User creator1 = new User();
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

        //User Object
        User anothaUser = new User();

        //First Rating Object
        Rating anothaRating = new Rating();
        anothaRating.setUser(anothaUser);
        anothaRating.setScore(1);

        //Second Rating Object
        Rating moreRatings = new Rating();
        moreRatings.setUser(anothaUser);
        anothaRating.setScore(-1);

        //toString test
        System.out.println(mem1);
        System.out.println(mem2);

        //equals test
        System.out.println(mem1.equals(mem2));
        System.out.println(mem2.equals(mem2));

        //calculateOverallRating test
        System.out.println(mem1.calculateOverallRating());
        System.out.println(mem2.calculateOverallRating());

        //addRating test
        System.out.println(mem1.addRating(anothaRating));
        System.out.println(mem2.addRating(moreRatings));

        //setCaptionVerticalAlign test
        System.out.println(mem1.setCaptionVerticalAlign("left"));
        System.out.println(mem1.setCaptionVerticalAlign("right"));
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
        return (this.backgroundImage + " '" + this.caption + "' " + calculateOverallRating() + " [+1: " + p + ", -1: " + n +"]" );
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
