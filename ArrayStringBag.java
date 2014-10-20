import java.util.Random;
/**
 * Implements StringBagInterface using an array to hold the strings.
 * 
 * @author Tena Percy 
 * @version 9/13/14
 */
public class ArrayStringBag implements StringBagInterface
{
    protected String name;          //name of this StringBag
    protected String[] log;         //array that holds strings
    protected int lastIndex = -1;   //index of last String in array
    protected Random gen = new Random();

    public ArrayStringBag(String name, int maxSize) 
    //Precondition: maxSize > 0;
    //
    //Instantiates and returns a reference to an empty ArrayStringBag
    //object with name "name" and room for maxSize elements
    {
        log = new String[maxSize];
        this.name = name;
    }

    public ArrayStringBag(String name)
    //Instantiates and returns a reference to an empty ArrayStringBag
    //object with name "name" and room for 100 strings.
    {
        log = new String[100];
        this.name = name;
    }

    public void insert(String element)
    //Precondition: The StringBag is not full.
    //
    //Places element into this StringBag.
    {
        lastIndex++;
        log[lastIndex] = element;
    }

    public boolean isFull()
    //Returns true if StringBag is full, otherwise returns false.
    {
        if (lastIndex == (log.length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public int size()
    //Returns the number of Strings in this StringBag.
    {
        return (lastIndex + 1);
    }

    public void clear()
    //Makes this StringBag empty
    {
        for (int i = 0; i <= lastIndex; i++) {
            log[i] = null;
        }
        lastIndex = -1;
    }

    public String getName() 
    //Returns the name of this StringBag.
    {
        return name;
    }

    public String toString()
    //Returns a nicely formatted string representing this StringBag.
    {
        String bagString = "Strings: " + name + "\n\n";

        for (int i = 0; i <= lastIndex; i++) {
            bagString = bagString + (i+1) + ". " + log[i] + "\n";
        }

        return bagString;
    }

    public boolean isEmpty()
    //Returns true if this StringBag is empty, otherwise returns false.
    {
        if (lastIndex == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int howMany(String element)
    //Returns an int value indicating how many times element occurs in
    //this StringBag.
    //
    //I tried searching to see if there is a method you can call on an array
    //to see if you can count duplicates, but I found nothing. So I iterated
    //through the collection and for each match incremented a local variable
    //count.
    {
        int location = 0;
        int count = 0;
        while(location <= lastIndex) {
            //if they match
            if (element.equalsIgnoreCase(log[location])){ 
                count++;
            }
            location++;
        }
        return count;
    }

    public boolean delete(String element)
    //Deletes one occurence of element from this StringBag, if possible.
    //Returns true if a deletion is made, otherwise returns false.
    //
    //This was tough. I struggled with how to avoid having a hole in the array.
    //Once I implemented this, I still was unsure until I did my testing. I
    //thought there was a delete method for arrays, but after a quick google
    //I found that was only for lists.
    {
        int location = 0;
        while (location <= lastIndex) {
            //if they match
            if (element.equalsIgnoreCase(log[location])) {
                log[location] = log[lastIndex];
                lastIndex--;
                return true;
            } else {
                location++;
            }
        }
        return false;
    }

    public int deleteAll(String element)
    //Deletes all occurences of element in this StringBag.
    //It returns the number of deletions that occured.
    //
    //Just like with the delete method I struggled with how to avoid a hole.
    //I also tried to find a way to just call the delete() method once I found
    //the matches, but kept getting errors. I also tried iterating backwards 
    //with the for loop, but that did not work. I was getting results that were
    //indicative of it working, but the element would still exist in the array. I 
    //feel like there is probably a more efficient way to do this.
    {
        int location = 0;
        int matches = 0;
        while (location <= lastIndex) {
            //find 1st match
            if(element.equalsIgnoreCase(log[location])) {
                for (int i = 0; i <= lastIndex; i++) {
                    if(log[i].equalsIgnoreCase(element)) {
                        log[i] = log[lastIndex];
                        matches++;
                        lastIndex--;
                    } 
                }

            } else {
                location++;
            }
        }
        return matches;
    }

    public String remove()
    //Precondition: The StringBag is not empty.
    //
    //Randomly selects an element from the StringBag and deletes it.
    //The randomly deleted element is returned
    //
    //This was pretty easy to implement. I tried originally to call delete(s) once I
    //had the random String, but I would get null pointer exception. I did not know
    //whether or not to test isEmpty since it is given as a precondition.
    {
        if (!isEmpty()) {
            int random = gen.nextInt(log.length);
            String s = log[random];
            log[random] = log[lastIndex];
            lastIndex--;
            return s;
        } else {
            return "The StringBag is empty";
        }
    }

    public boolean uniqInsert(String element)
    //Precondition: This StringBag is not full.
    //
    //Inserts element in StringBag unless element already exists.
    //Returns true if inserted, otherwise returns false.
    //
    //I did not really think of any other ways to implement this method.
    {
        int location = 0;
        while (location <= lastIndex) {
            if (element.equalsIgnoreCase(log[location])){
                return false;
            } else {
                location++;
            }
        }
        insert(element);
        return true;
    }

}
