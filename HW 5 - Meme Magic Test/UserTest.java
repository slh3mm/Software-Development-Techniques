import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void overloadedConstructorTest() {
        User user1 = new User("user1");
    }


    @Test
    public void createMemeTest() {
        BackgroundImage backgroundImage1 = new BackgroundImage();
        BackgroundImage backgroundImage2 = null;
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        User user1 = new User("user1");
        user1.createMeme(backgroundImage1, "CAP");
        user1.createMeme(backgroundImage2, "CAP2");
    }

    @Test
    public void deleteMemeTest() {
        ArrayList<Meme> memCreat = new ArrayList<Meme>();
        ArrayList<Meme> memCreat2 = new ArrayList<Meme>();
        Meme nullMeme = null;
        User user1 = new User("user1");
        User user2 = new User("user2");

        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        memCreat.add(meme1);
        user1.setMemesCreated(memCreat);
        user1.deleteMeme(meme1);

        user2.setMemesCreated(memCreat2);
        user2.deleteMeme(meme1);
    }

    @Test
    public void shareMemeTest() {
        User user1 = new User("user1");

        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        Feed feed = new Feed();
        user1.shareMeme(meme1, feed);
        user1.shareMeme(null, feed);

    }

    @Test
    public void rateNextMemeFromFeedTest() {
        Feed feed = new Feed();
        Feed nfeed = null;
        User user = new User();
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user);
        meme1.setShared(false);

        TreeSet<Meme> memView = new TreeSet<Meme>();
        user.rateNextMemeFromFeed(nfeed, 1);
        user.rateNextMemeFromFeed(feed,1);

        ArrayList<Meme> memes = new ArrayList<Meme>();
        memes.add(meme1);
        feed.setMemes(memes);
        user.rateNextMemeFromFeed(feed, -1);

        ArrayList<Meme> nmemes = new ArrayList<Meme>();
        Meme nmeme = null;
        nmemes.add(nmeme);

    }

    @Test
    public void calculateReputationTest() {
        User user1 = new User("User1");
        User user2 = new User("User2");
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        ArrayList<Meme> memesCreat = new ArrayList<Meme>();
        user1.setMemesCreated(memesCreat);
        user1.calculateReputation();

        memesCreat.add(meme1);
        user1.setMemesCreated(memesCreat);
        user1.calculateReputation();

    }

    @Test
    public void toStringTest() {
        User user1 = new User("User1");
        User user2 = new User("User2");
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        ArrayList<Meme> memesCreat = new ArrayList<Meme>();
        memesCreat.add(meme1);
        user1.setMemesCreated(memesCreat);
        user1.calculateReputation();
        user1.toString();
//        String userName = user1.getUserName();
//        Double rep = user1.calculateReputation();
//
//        assertEquals(userName, user1.toString());
//        assertEquals(rep, user1.toString());
    }

    @Test
    public void equalsTest() {
        User user1 = new User();
        user1.setUserName("user1");
        User user2 = new User("user2");
        User user3 = null;
        user1.equals(user1);
        user1.equals(user2);
        user1.equals(user3);
    }

    @Test
    public void compareToTest() {
        User user1 = new User("User1");
        User user2 = new User("User2");
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        ArrayList<Meme> memesCreat1 = new ArrayList<Meme>();
        ArrayList<Meme> memesCreat2 = new ArrayList<Meme>();
        memesCreat1.add(meme1);

        user1.setMemesCreated(memesCreat1);
        user2.setMemesCreated(memesCreat2);
        user1.compareTo(user2);
        user1.compareTo(user1);
    }
    @Test
    public void getUserNameTest() {
        User user1 = new User("user1");
        user1.getUserName();
    }

    @Test
    public void rateMemeTest(){
        User user1 = new User("User1");
        User user2 = new User("User2");
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        user1.rateMeme(meme1, 1);
        user1.rateMeme(null, 0);
    }
}