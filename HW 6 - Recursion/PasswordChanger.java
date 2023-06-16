public class PasswordChanger implements PWCInterface{
    public static void main(String[] args){
        PasswordChanger PC = new PasswordChanger();
        String emptyString = "";

        //containsDigit
        String pword1 = "nothing here";
        String pword2 = "here's 1";
        System.out.println("containsDigit:");
        System.out.println(PC.containsDigit(pword1));
        System.out.println(PC.containsDigit(pword2));
        System.out.println(PC.containsDigit(emptyString));
        System.out.println();

        //equalsOld
        System.out.println("equalsOld:");
        String pword3 = "myPassword";
        String pword4 = "notmyPassword";
        System.out.println(PC.equalsOld(pword3, pword4));
        System.out.println(PC.equalsOld(pword3, pword3));
        System.out.println(PC.equalsOld(emptyString, pword3));
        System.out.println();

        //reverseOfOld
        System.out.println("reverseOfOld:");
        String pword5 = "racecar";
        String pword6 = "not a racecar";
        System.out.println(PC.reverseOfOld(pword5, pword6));
        System.out.println(PC.reverseOfOld(pword5, pword5));
        System.out.println(PC.reverseOfOld(emptyString, pword5));
        System.out.println();

        //numberDifferences
        System.out.println("numberDifferences:");
        String pword7 = "fubini's theorem";
        String pword8 = "fubini";
        System.out.println(PC.numberDifferences(pword7, pword8));
        System.out.println(PC.numberDifferences(pword7, pword7));
        System.out.println(PC.numberDifferences(emptyString, pword7));
        System.out.println();

        //differentEnough
        System.out.println("differentEnough:");
        String pword9 = "Matthew";
        String pword10 = "Matt";
        System.out.println(PC.differentEnough(pword9, pword10, 3));
        System.out.println(PC.differentEnough(pword9, pword10, 5));
        System.out.println(PC.differentEnough(emptyString, pword10, 1));
        System.out.println();

        //validPasswordChange
        System.out.println("validPasswordChange:");
        String pword11 = "Matthew";
        String pword12 = "Matt";
        System.out.println(PC.validPasswordChange(pword11, pword12));
        System.out.println(PC.validPasswordChange(pword12, pword12));
        System.out.println(PC.validPasswordChange(pword11, emptyString));
        System.out.println();
    }
    @Override
    public boolean containsDigit(String password) {
        if (password.length() == 0){
            return false;
        }
        if ( Character.isDigit(password.charAt(0)) ){
            return true;
        }
        return containsDigit(password.substring(1));
    }

    @Override
    public boolean equalsOld(String oldPassword, String newPassword) {
        if ( oldPassword.length() == 0 && newPassword.length() == 0 ){
            return true;
        }

        if(oldPassword.length() != newPassword.length()){
            return false;
        }

        if ( oldPassword.charAt(0) == newPassword.charAt(0) ){
            String nP = newPassword.substring(1);
            String oP = oldPassword.substring(1);
                return equalsOld(oP, nP);
        }

        return false;
    }

    @Override
    public boolean reverseOfOld(String oldPassword, String newPassword) {
        if (oldPassword.length() == 0 && newPassword.length() == 0 ){
            return true;
        }
        if(oldPassword.length() != newPassword.length()){
            return false;
        }
        if ( oldPassword.charAt(0) == newPassword.charAt(newPassword.length() - 1) ){
            String nP = newPassword.substring(0, newPassword.length() - 1);
            String oP = oldPassword.substring(1);
            return reverseOfOld(oP, nP);
        }
        return false;
    }

    @Override
    public int numberDifferences(String oldPassword, String newPassword) {
        if ( oldPassword.length() == 0 && newPassword.length() == 0 ){
            return 0;
        }

        if ( oldPassword.length() == 0 || newPassword.length() == 0 ){
            return Math.abs(oldPassword.length() - newPassword.length());
        }

        String nP = newPassword.substring(1);
        String oP = oldPassword.substring(1);

        if ( oldPassword.charAt(0) != newPassword.charAt(0) ){
            return numberDifferences(oP, nP) + 1;
        }


        return numberDifferences(oP, nP);
    }

    @Override
    public boolean differentEnough(String oldPassword, String newPassword, int quality) {
        return numberDifferences(oldPassword, newPassword) >= quality;
    }

    @Override
    public boolean validPasswordChange(String oldPassword, String newPassword) {
        return containsDigit(newPassword) && !reverseOfOld(oldPassword,newPassword) && !equalsOld(oldPassword, newPassword) && differentEnough(oldPassword, newPassword, newPassword.length() / 2);
    }
}
