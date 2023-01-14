import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordPreprocess {
    private static void analyze_words() {
        int longest_word_length = 0, total = 0;
        String word = "";
        ArrayList<String> longest_words = new ArrayList<String>();
        int counts[] = new int[24]; // the longest word has 24 letters

        try {
            File f = new File("asset/word_list.txt");
            Scanner input = new Scanner(f);

            while (input.hasNextLine()) {
                word = input.nextLine();

                if (word.length() == 24) {
                    longest_words.add(word);
                }

                total++;
                counts[word.length()-1]++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Total number of words: " + total);

        int i = 1;
        for (int count: counts){
            System.out.println("Words with length " + i + " = " + count + " ");
            i++;
        }

        for (String longest: longest_words){
            System.out.println(longest);
        }
    }

    public static void main(String[] args) {
        analyze_words();
    }
}
