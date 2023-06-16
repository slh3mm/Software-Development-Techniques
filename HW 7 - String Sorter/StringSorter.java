import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StringSorter {
    private Queue<String>[] arrOfQ;
    public static void main(String[] args){
       ArrayList<String> test1 = new ArrayList<String>();
       test1.add("apple");
       test1.add("app");
       test1.add("carrot");
       test1.add("bznana");
       test1.add("apricot");
       test1.add("buchannon");

       ArrayList<String> test2 = new ArrayList<String>();
       test2.add("cab");
       test2.add("abc");
       test2.add("dab");
       test2.add("ac");
       test2.add("abab");

       ArrayList<String> test3 = new ArrayList<String>();
       test3.add("abb");
       test3.add("aaa");
       test3.add("aba");
       test3.add("aab");
       test3.add("abc");
       test3.add("aac");


       StringSorter mytest1 = new StringSorter();
       test1 = mytest1.sort(test1);
       System.out.println(test1);

       StringSorter mytest2 = new StringSorter();
       test2 = mytest2.sort(test2);
       System.out.println(test2);

       StringSorter mytest3 = new StringSorter();
       test3 = mytest3.sort(test3);
       System.out.println(test3);
    }
    public StringSorter(){
        arrOfQ = new Queue[26];
        for (int i = 0; i < 26; i++){
            Queue<String> q = new LinkedList<String>();
            arrOfQ[i] = q;
        }
    }

    public ArrayList<String> sort(ArrayList<String> list){
        distribute(list, 0);
        return collect(0);
    }

    private ArrayList<String> collect(int n){
        ArrayList<String> returnArray = new ArrayList<String>();
        for (int i = 0; i < 26; i++){
            if (arrOfQ[i].size() == 1){
                returnArray.add(arrOfQ[i].remove());
            }
            else if (arrOfQ[i].size() != 0){
                StringSorter newSS = new StringSorter();
                ArrayList<String> newArrOfQ = new ArrayList<String>();
                for (String j : arrOfQ[i]){
                    newArrOfQ.add(j);
                }
                //arrOfQ[i].remove();
                newSS.distribute(newArrOfQ, n+1);
                returnArray.addAll(newSS.collect(n+1));
            }
        }
        return returnArray;
    }
    private void distribute(ArrayList<String> Words, int index){
        for (int i = 0; i < Words.size(); i++){
            String word = Words.get(i);
            if (index >= word.length()){
                arrOfQ[0].add(word);
            }
            else {
                int asciiVal = word.charAt(index);
                int pos = asciiVal - 97;
                arrOfQ[pos].add(word);
            }
        }
    }
}
