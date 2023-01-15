import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordPreprocess {
    private static void analyze_words(ArrayList<String> words) {
        int total = 0;
        ArrayList<String> longest_words = new ArrayList<>();
        int[] counts = new int[24]; // longest word has 24 letters

        for (String word: words) {
            if (word.length() == 24) {
                longest_words.add(word);
            }
            total++;
            counts[word.length() - 1]++;
        }

        System.out.println("Total number of words: " + total);

        int i = 1;
        for (int count : counts) {
            System.out.println("Words with length " + i + " = " + count + " ");
            i++;
        }

        System.out.println("\n---The longest words---");
        for (String longest : longest_words) {
            System.out.println(longest);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> at_least_five = new ArrayList<>();
        String word;

        try {
            File f = new File("asset/word_list.txt");
            Scanner input = new Scanner(f);

            while (input.hasNextLine()) {
                word = input.nextLine();
                if (word.length() >= 5) {
                    at_least_five.add(word);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        analyze_words(at_least_five);
    }
}
