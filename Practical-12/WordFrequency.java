
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine().toLowerCase();

        String[] words = paragraph.split("\\W+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        System.out.println("\nWord Frequencies (Highest First):");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }
}
