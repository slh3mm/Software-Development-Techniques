import org.junit.Test;

import static org.junit.Assert.*;

public class MemeTest {

    @Test
    public void addRating() {
    }

    @Test
    public void calculateOverallRating() {
    }

    @Test
    public void toStringTest() {
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

        BackgroundImage BIM = meme1.getBackgroundImage();
        String CAP = meme1.getCaption();
        User CREATOR = meme1.getCreator();
        Boolean SHARED = meme1.getShared();

        Rating ratingp1 = new Rating();
        ratingp1.setUser(creator1);
        ratingp1.setScore(1);
        Rating ratingn1 = new Rating();
        ratingn1.setScore(-1);


        Meme meme3 = meme1;
        meme3.addRating(ratingn1);
        meme3.addRating(ratingp1);

        meme1.toString();
        meme2.toString();

    }

    @Test
    public void equalsTest() {
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

        Meme nullMeme = null;

        meme1.equals(meme2);
        meme1.equals(meme1);
        meme1.equals(nullMeme);
        backgroundImage1.equals(meme1);
    }

    @Test
    public void compareTo() {
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

        System.out.println(meme1.compareTo(meme2));
        System.out.println(meme1.compareTo(meme1));
    }

    @Test
    public void defaultTest(){
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
        Meme meme1 = new Meme(backgroundImage1, "Caption1", creator1);
        meme1.getCreator();
        meme1.getBackgroundImage();
        meme1.getCaption();
        meme1.getShared();
        meme1.getRatings();
        meme1.getCaptionVerticalAlign();

    }

    @Test
    public void overloadedConstructorTest(){
        User user = new User("user");
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");
        Meme meme = new Meme(backgroundImage1,"Caption", user);
    }
}