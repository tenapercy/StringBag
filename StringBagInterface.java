
/**
 * An interface for a class that represents a bag of Strings. 
 * 
 * @author Tena Percy 
 * @version 9/13/2014
 */
public interface StringBagInterface
{
    void insert(String element);
    //Precondition: The StringBag is not full.
    //
    //Places element into this StringBag.
    
    boolean isFull();
    //Returns true if this StringBag is full, otherwise returns false.
    
    boolean isEmpty();
    //Returns true if this StringBag is empty, otherwise returns false.
    
    int size();
    //Returns the number of Strings in this StringBag.
    
    void clear();
    //Makes the StringBag empty.
    
    String getName();
    //Returns the name of this StringBag.
    
    String toString();
    //Returns a nicely formatted string representing this StringBag.
    
    int howMany(String element);
    //Returns an int value indicating how many times an element occurs.
    
    boolean uniqInsert(String element);
    //Precondition: This StringBag is not full
    //
    //Inserts element in StringBag unless element already exists.
    //If inserted returns true, otherwise returns false.
    
    boolean delete(String element);
    //Deletes one occurence of element from StringBag, if possible.
    //Returns true if a deletion is made, otherwise returns false.
    
    int deleteAll(String element);
    //Deletes all occurences of element from StringBag.
    //Returns the number of deletions that occured.
    
    String remove();
    //Precondition: The StringBag is not empty.
    //
    //Randomly selects an element from the StringBag and deletes it.
    //The randomly deleted element is returned.
    

  
    

}
