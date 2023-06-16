import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderableFeedTest {

    @Test
    public void sortByCaptionTest() {
        //User Objects
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
        meme2.setBackgroundImage(backgroundImage2);
        meme2.setCaption("Caption2");
        meme2.setCreator(user2);
        meme2.setShared(true);

        //Feed Object
        Feed thefeed1 = new Feed();
        ArrayList<Meme> thefeedmemes1 = new ArrayList<Meme>();
        thefeedmemes1.add(meme1);
        thefeedmemes1.add(meme2);
        thefeed1.setMemes(thefeedmemes1);

        user1.getMemesCreated().add(meme1);
        user1.getMemesViewed().add(meme1);

        OrderableFeed OF = new OrderableFeed();
        OF.sortByCreator();
        OF.sortByCaption();
        OF.sortByRating();
    }

    @Test
    public void sortByRating() {
    }

    @Test
    public void sortByCreator() {
    }

}