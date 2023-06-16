import java.util.Comparator;

public class CompareMemeByRating implements Comparator<Meme> {
    @Override
    public int compare(Meme o1, Meme o2) {
        int returnVal = -Double.compare(o1.calculateOverallRating(), o2.calculateOverallRating());
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

        return o1.getCreator().compareTo(o2.getCreator());
    }
}
