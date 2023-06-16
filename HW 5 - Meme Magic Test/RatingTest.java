import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class RatingTest {

    @Test
    public void testToString() {
        Meme meme1 = new Meme();
        Rating rating1 = new Rating();
        User user1 = new User();
        TreeSet<Meme> treeSet1 = new TreeSet<Meme>();
        ArrayList<Meme> arrayList1 = new ArrayList<Meme>();
        Rating rating2 = new Rating(user1, 1);

        user1.setUserName("USERNAME1");
        arrayList1.add(meme1);
        meme1.setCreator(user1);
        treeSet1.add(meme1);
        user1.setMemesViewed(treeSet1);
        rating1.setUser(user1);
        user1.setMemesCreated(arrayList1);
    }

    @Test
    public void equalsTest() {
        User user = new User("user");
        Rating rating0 = new Rating(user, 3);
        Rating rating1 = new Rating(user, 1);
        Rating ratingn1 = new Rating(user, -1);

        rating0.toString();
        rating1.toString();
        ratingn1.toString();

        rating0.equals(rating1);
        rating1.equals(rating1);
        rating0.equals(null);

        rating1.getScore();
        rating1.getUser();
    }

    @Test
    public void toStringTest() {
        User user = new User("user");
        Rating rating0 = new Rating(user, 3);
        Rating rating1 = new Rating(user, 1);
        Rating ratingn1 = new Rating(user, -1);

        rating0.toString();
        rating1.toString();
        ratingn1.toString();
    }
}