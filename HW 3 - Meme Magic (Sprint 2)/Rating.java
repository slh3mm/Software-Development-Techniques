public class Rating {
    //Rating Fields
    private User user;
    private int score;

    //Rating Default Constructor
    public Rating(){
        this.setUser(new User());
    }

    //Rating Overloaded Constructor
    public Rating(User user, int score){
        this.setUser(user);
        if (score == -1 || score == 0 || score == 1){
            this.setScore(score);
        }
        else {
            this.setScore(0);
        }
    }

    //Main Method
    public static void main(String[] args) {
        //User Object
        User myUser = new User();

        //First Rating Object
        Rating rating1 = new Rating();
        rating1.setUser(myUser);
        rating1.setScore(-2);

        //Second Rating Object
        Rating rating2 = new Rating();
        rating2.setUser(myUser);
        rating2.setScore(-1);

        //toString test
        System.out.println(rating1);
        System.out.println(rating2);

        //equals test
        System.out.println(rating1.equals(rating2));
        System.out.println(rating1.equals(rating1));

        //setScore test
        System.out.println(rating1.setScore(12));
        System.out.println(rating1.setScore(1));
    }

    //toString
    @Override
    public String toString(){
       String type_of_rating = "";
        if (this.getScore() == 1){
           type_of_rating = "an upvote";
        }
        else if (this.getScore() == -1){
            type_of_rating = "a downvote";
        }
        else if (this.getScore() == 0){
            type_of_rating = "a pass";
        }
        return this.getUser().getUserName() + " rated as " + type_of_rating;
    }

    //equals
    @Override
    public boolean equals(Object myObj){
        if (myObj == null){
            return false;
        }
        else if (myObj instanceof Rating){
            Rating newObj = (Rating) myObj;
            if (this.score == newObj.score && this.user.equals(newObj.user)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    //GETTERS
    public int getScore() {
        return this.score;
    }
    public int getScore(int score) {
        return this.score;
    }
    public User getUser(){
        return this.user;
    }
    public User getUser(User user) {
        return this.user;
    }

    //SETTERS
    public void setUser(User user) {
        this.user = user;
    }
    public boolean setScore (int theScore){
        boolean value = false;
        if(theScore == -1 || theScore == 0 || theScore == 1){
            value = true;
            this.score = theScore;
        }
        return value;
    }

}
