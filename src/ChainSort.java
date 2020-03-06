import java.util.*;

/**
 * This class represents chains of linked nodes that
 * can be sorted by a Shell sort.
 *
 * @author Charles Hoot
 * @author Frank M. Carrano
 *         Modified by atb
 * @author YOUR NAME
 * @version 3/3/2020
 */
public class ChainSort<T extends Comparable<? super T>>
{
    private Node<T> firstNode; // reference to first node

    public ChainSort()
    {
        this.firstNode = null;
    }

    public void display()
    {
        Node<T> currentNode = this.firstNode;
        while (currentNode != null)
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    } // end display

    public boolean isEmpty()
    {
       return this.firstNode == null;
    } // end isEmpty

    public void addToBeginning(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = this.firstNode;
        this.firstNode = newNode;
    } // end addToBeginning

    public void shellSort(int chainSize)
    {
        //TODO Project3

        for (int space = chainSize / 2; space > 0; space = space / 2)
        {
            //     create sub-chains:
            //          set previousNode to the first node in the chain
            //          set currentNode to the first node in the chain
            //          with a for loop traverse nodes space times using currentNode
            //            to find the second node of the first sub-chain
            //
            //          with a while loop set up backward links for all sub-chains:
            //              set currentNode's previous pointer to the previousNode
            //              set previousNode to its next node and do the same with the currentNode


            System.out.println("\n\u001B[35m\u001B[1m----->Before partial sort with space " + space + " :\u001B[0m");
            display();
            // sort all the sub-chains:
            incrementalInsertionSort(space);
            System.out.println("\u001B[35m\u001B[1m----->After partial sort done with space " + space + " :\u001B[0m");
            display();
        }
    } // end shellSort

    /**
     * Task: Sorts equally spaced elements of a linked chain into
     * ascending order. Sub-chains created with a use of previous.
     *
     * @param space the space between the nodes of the
     *              elements to sort
     */
    private void incrementalInsertionSort( int space)
    {
        //TODO Project3

        // when sorting do not change pointers - simply swap the data if needed
    } // end incrementalInsertionSort


    private class Node<S>
    {
        private S data;
        private Node<S> next;
        private Node<S> previous; // ADDED for linking backwards for shell sort

        private Node(S dataPortion)
        {
            this.data = dataPortion;
            this.next = null;
            this.previous = null;
        }
    } // end Node

    // ************ TEST DRIVER *****************

    public static void main(String args[])
    {
        System.out.println("What size chain should be used?");
        int chainSize = getInt("   It should be an integer value greater than or equal to 1.");

        System.out.println("What seed value should be used?");
        int seed = getInt("   It should be an integer value greater than or equal to 1.");
        Random generator = new Random(seed);
        ChainSort<Integer> myChain = new ChainSort<>();

        for (int i = 0; i < chainSize; i++)
            myChain.addToBeginning(generator.nextInt(100));

        System.out.print("\nOriginal Chain Content: ");
        myChain.display();
        myChain.shellSort(chainSize);
        System.out.print("\nSorted Chain Content: ");
        myChain.display();
    }


    /**
     * Get an integer value
     *
     * @param rangePrompt String representing a message used to ask the user for input
     * @return an integer
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
    }
} // end ChainSort