import java.util.Comparator;
import java.util.Collections;
import java.util.List;

public class CompareMemeByCreator implements Comparator<Meme> {
    @Override
    public int compare(Meme o1, Meme o2) {
        int returnVal = o1.getCreator().compareTo(o2.getCreator());
        if (returnVal != 0){
            return returnVal;
        }

        returnVal = -Double.compare(o1.calculateOverallRating(), o2.calculateOverallRating());
        if (returnVal != 0){
            return returnVal;
        }

        returnVal = o1.getCaption().compareTo(o2.getCaption());
        if (returnVal != 0){
            return returnVal;
        }

        returnVal = o1.getBackgroundImage().compareTo(o2.getBackgroundImage());
        if (returnVal != 0){
            return returnVal;
        }

        return -Boolean.compare(o1.getShared(), o2.getShared());
    }
}
