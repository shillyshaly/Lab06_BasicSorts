import java.util.*;

/**
 * This class creates all permutations of the given string
 *
 * @author YOUR NAME
 * @version 3/3/2020
 */
public class UniqueAnagrams
{
    private ArrayList<String> anagrams;

    public UniqueAnagrams()
    {
        this.anagrams = new ArrayList<>();
    }

    public void permutations(String word)
    {
        permutations("", word);
        System.out.println("Possible anagrams = " + this.anagrams);

        TreeSet<String> toTest = new TreeSet(this.anagrams);
        System.out.println("Expected unique and sorted anagrams = " + toTest);
        System.out.println();

        sort(); // duplicates will be removed during the sorting process
    }

    private void permutations(String prefix, String suffix)
    {
        int numOfChars = suffix.length();
        if (numOfChars == 1)
        {
            //System.out.println(prefix + suffix);
            this.anagrams.add(prefix + suffix);
        }
        else
        {
            //TODO Project2
        }
    }

    private void sort()
    {
        //TODO Project2

        // calls getIndexOfSmallestAndRemoveDuplicates(index, this.anagrams.size());
        // calls swap(index, indexOfNextSmallest);
    }

    private int getIndexOfSmallestAndRemoveDuplicates(int first, int last)
    {
        //TODO Project2

        // as the smallest is being found removes duplicates

        return 0; // THIS IS A STUB
    }

    private void swap(int i, int j)
    {
        //TODO Project2
    }

    private void display()
    {
        System.out.println("Computed unique and sorted anagrams = " + this.anagrams);
    }

    public static void main(String[] args)
    {
        UniqueAnagrams uniqueAnagrams = new UniqueAnagrams();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a word");
        String word = keyboard.next();

        uniqueAnagrams.permutations(word);
        uniqueAnagrams.display();
    }
}
