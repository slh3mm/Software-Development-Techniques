import java.util.ArrayList;

public class User {
    //User Fields
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed;

    //Overloaded Constructor
    public User(String userName){
        this.setUserName(userName);
        this.setMemesCreated(new ArrayList<Meme>());
        this.setMemesViewed(new ArrayList<Meme>());
    }

    //Default Constructor
    public User(){
        this.setUserName("");
        this.setMemesCreated(new ArrayList<Meme>());
        this.setMemesViewed(new ArrayList<Meme>());
    }
    //Main Method
    public static void main(String[] args) {
        //Users
        User user1 = new User();
        User user2 = new User("Matt");
        User user3 = new User("Trent");

        //BackgroundImages
        BackgroundImage userBim1 = new BackgroundImage();
        userBim1.setImageFileName("userFN1");
        userBim1.setTitle("userTITL1");
        userBim1.setDescription("userDESC1");

        BackgroundImage userBim2 = new BackgroundImage();
        userBim2.setImageFileName("userFN2");
        userBim2.setTitle("userTITL2");
        userBim2.setDescription("userDESC2");

        //Memes
        Meme userMeme1 = new Meme();
        userMeme1.setBackgroundImage(userBim1);
        userMeme1.setCaption("userCap1");
        userMeme1.setCreator(user1);

        Meme userMeme2 = new Meme();
        userMeme2.setBackgroundImage(userBim2);
        userMeme2.setCaption("userCap2");
        userMeme2.setCreator(user2);

        //User deleteMeme
        System.out.println("deleteMeme test 1: " + user1.deleteMeme(userMeme1));
        System.out.println("deleteMeme test 2: " + user1.deleteMeme(null));
        System.out.println("");

        //User calculateReputation
        User user5 = new User("Christian");

        BackgroundImage userBim5 = new BackgroundImage();
            userBim5.setImageFileName("userFN5");
            userBim5.setTitle("userTITL5");
            userBim5.setDescription("userDESC5");

        Rating rating5 = new Rating(user5, 1);
        Rating rating6 = new Rating(user2, -1);

        Meme userMeme5 = new Meme();
            userMeme5.setBackgroundImage(userBim5);
            userMeme5.setCaption("userCap5");
            userMeme5.setCreator(user5);
            userMeme5.addRating(rating5);

        userMeme2.addRating(rating6);

        user5.getMemesCreated().add(userMeme5);
        user5.getMemesCreated().add(userMeme1);
        user2.getMemesCreated().add(userMeme2);
        System.out.println("calcRep MemesCreated: " + user5.getMemesCreated());
        System.out.println("calcRep MemesCreated Size: " + user5.getMemesCreated().size());

        System.out.println("calcRep user5 rep " + user5.calculateReputation());
        System.out.println("calcRep user2 rep " + user2.calculateReputation());
        System.out.println("");

        //toString
        user2.getMemesViewed().add(userMeme1);
        System.out.println(user1.getMemesViewed().size());
        System.out.println(user1);
        System.out.println(user2);

        //deleteMeme
        user2.getMemesCreated().add(userMeme2);
        System.out.println(user2.getMemesCreated());

        System.out.println(user2.deleteMeme(userMeme1));
        System.out.println(user2.deleteMeme(userMeme2));
        System.out.println(user2.getMemesCreated());

        //rateNextMemeFromFeed
        Feed newFeed = new Feed();
        System.out.println("rateNextMemeFromFeed: " + user1.rateNextMemeFromFeed(null, 1));
        System.out.println("rateNextMemeFromFeed: " + user1.rateNextMemeFromFeed(newFeed, 1));

        //shareMeme
        Feed testFeed = new Feed();
        userMeme1.setShared(false);
        System.out.println("shareMeme: " + userMeme1.getShared());
        System.out.println("shareMeme: " + user1.shareMeme(userMeme1, testFeed));

        //rateMeme
        System.out.println();
        System.out.println(userMeme1);
        System.out.println(user1.getMemesViewed());
        System.out.println(user1.rateMeme(userMeme1, -1));
        System.out.println(user1.getMemesViewed());
        System.out.println();

        //User createMeme
        user1.getMemesCreated().add(userMeme1);
        System.out.println(user3.getMemesCreated());
        System.out.println("createMeme test 1: " + user3.createMeme(userBim1, "myCap1"));
        System.out.println("createMeme test 2: " + user3.createMeme(userBim2, "noCap"));
        System.out.println();
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

