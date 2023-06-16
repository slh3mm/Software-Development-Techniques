import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class FeedTest {

    @Test
    public void toStringTest() {
        Feed feed1 = new Feed();
        Feed feed2 = new Feed();
        ArrayList<Meme> memes = new ArrayList<Meme>();
        Meme meme1 = new Meme();
        User user1 = new User("user1");

        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        memes.add(meme1);
        feed1.setMemes(memes);
        feed1.toString();
    }

    @Test
    public void getNewMemeTest() {
        User user1 = new User();
        User user2 = new User();

        //Background Image Objects
        BackgroundImage backgroundImage1 = new BackgroundImage();
        backgroundImage1.setImageFileName("ImageFileName1");
        backgroundImage1.setTitle("Title1");
        backgroundImage1.setDescription("Description1");

        BackgroundImage backgroundImage2 = new BackgroundImage();
        backgroundImage2.setImageFileName("ImageFileName2");
        backgroundImage2.setTitle("Title2");
        backgroundImage2.setDescription("Description2");

        //Meme Objects
        Meme meme1 = new Meme();
        meme1.setBackgroundImage(backgroundImage1);
        meme1.setCaption("Caption1");
        meme1.setCreator(user1);
        meme1.setShared(false);

        Meme meme2 = new Meme();
        meme1.setBackgroundImage(backgroundImage2);
        meme1.setCaption("Caption2");
        meme1.setCreator(user2);
        meme1.setShared(true);

        Feed feed1 = new Feed();
        Feed feed2 = new Feed();

        ArrayList<Meme> memes = new ArrayList<Meme>();
        ArrayList<Meme> memesC = new ArrayList<Meme>();
        TreeSet<Meme> memesV = new TreeSet<Meme>();
        ArrayList<Meme> memesN = null;

        memesC.add(meme1);
        memesV.add(meme1);

        memes.add(meme1);
        memes.add(meme2);
        user1.setMemesCreated(memesC);
        user1.setMemesViewed(memesV);

        feed1.setMemes(memes);
        feed1.getNewMeme(user1);
        feed1.getMeme();
    }

    @Test
    public void getMemes() {
    }

    @Test
    public void getMeme() {
    }

    @Test
    public void setMemes() {
    }

    @Test
    public void setMeme() {
    }
}