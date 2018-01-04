package mobile.huaman.photoncodechallenge.photoncodechallengeactivity;

/**
 * Created by Pablo on 12/21/2017.
 */

public class test {

    public static void main(String[] args) {




        //singleton class  new instance

        //1. Method to tell you if a string is a palindrome
        first("Pablo");

    }
    private static void first(String wordCheck) {
        String[] a = new String[wordCheck.length()];

        String backwardsWord = "";
        for (int i = wordCheck.length() - 1; i >= 0; i--) {
            //System.out.println(wordCheck.charAt(i));
            backwardsWord += wordCheck.charAt(i);
        }

        //test if palindrome
        System.out.println("Word: "+ wordCheck);
        System.out.println("Backwards word: "+backwardsWord );
        if (backwardsWord.equals(wordCheck))
            System.out.println("is Palindrone");
        else
            System.out.println("is not Palindrone");
    }

}
