import org.junit.Test;

import static org.junit.Assert.*;

public class BackgroundImageTest {

    @Test
    public void toStringTest(){
        //input
        String testTitle = "TITLE";
        String testDescription = "DESCRIPTION";

        //expected
        String expectedToString = testTitle + " <" + testDescription + ">";

        //actual
        BackgroundImage actualToString = new BackgroundImage();
        actualToString.setDescription(testDescription);
        actualToString.setTitle(testTitle);

        //test
        String desc = actualToString.getDescription();
        String titl = actualToString.getTitle();
        String fn = actualToString.getImageFileName();
        assertEquals(expectedToString, actualToString.toString());
        assertEquals(desc, actualToString.getDescription());
        assertEquals(titl, actualToString.getTitle());
        assertEquals(fn, actualToString.getImageFileName());
    }

    @Test
    public void equalsTest(){
        //input
        BackgroundImage backgroundImage1 = new BackgroundImage();
        BackgroundImage backgroundImage2 = new BackgroundImage();
        BackgroundImage bIMNUll = null;
        Meme meme = new Meme();

        String imageFileName1 = "NAME1";
        String imageFileName2 = "NAME2";
        String description1 = "DESC1";
        String description2 = "DESC1";
        String title1 = "TITLE1";
        String title2 = "TITLE1";

        backgroundImage1.setTitle(imageFileName1);
        backgroundImage1.setDescription(description1);
        backgroundImage1.setTitle(title1);
        backgroundImage2.setImageFileName(imageFileName2);
        backgroundImage2.setDescription(description2);
        backgroundImage2.setTitle(title1);

        backgroundImage1.equals(backgroundImage1);
        backgroundImage1.equals(backgroundImage2);
        backgroundImage1.equals(bIMNUll);
        backgroundImage1.equals(meme);
    }


    @Test
    public void compareToTest() {
        //input
        BackgroundImage backgroundImage1 = new BackgroundImage();
        BackgroundImage backgroundImage2 = new BackgroundImage();

        String imageFileName1 = "NAME1";
        String imageFileName2 = "NAME2";
        String description1 = "DESC1";
        String description2 = "DESC2";
        String title1 = "TITLE1";
        String title2 = "TITLE2";

        backgroundImage1.setTitle(imageFileName1);
        backgroundImage1.setDescription(description1);
        backgroundImage1.setTitle(title1);
        backgroundImage2.setImageFileName(imageFileName2);
        backgroundImage2.setDescription(description2);
        backgroundImage2.setTitle(title1);

        //expected
        int expected1;

        //actual

        //test
    }

    @Test
    public void defaultConstructorTest(){
        BackgroundImage bimage = new BackgroundImage("FN", "TITL", "DESC");
    }

    @Test
    public void overloadedConstructorTest(){
        BackgroundImage bimage = new BackgroundImage();
        bimage.setImageFileName("FN");
        bimage.setTitle("TITLE");
        bimage.setDescription("DESC");
    }
}