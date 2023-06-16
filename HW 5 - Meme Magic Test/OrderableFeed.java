import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OrderableFeed extends Feed{
    public void sortByCaption(){
        Collections.sort(getMemes());
    }
    public void sortByRating(){
        Collections.sort(getMemes(), new CompareMemeByRating());
    }
    public void sortByCreator(){
        Collections.sort(getMemes(), new CompareMemeByCreator());
    }

    public static void main(String[] args) {

    }
}


