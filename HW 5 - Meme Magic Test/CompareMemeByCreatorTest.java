import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompareMemeByCreatorTest {

    @Test
    public void compareTest() {
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
        meme1.setBackgroundImage(backgroundImage2);
        meme1.setCaption("Caption2");
        meme1.setCreator(user2);
        meme1.setShared(true);

        CompareMemeByCreator CMBC = new CompareMemeByCreator();
        CMBC.compare(meme1, meme2);
        CMBC.compare(meme1,meme1);


    }
}