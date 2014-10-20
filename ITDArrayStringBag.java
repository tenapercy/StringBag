/**
 * Interactive Test Driver for ArrayStringBag class.
 * 
 * @author Tena Percy
 */

import java.util.*;

public class ITDArrayStringBag
{
    public static void main(String[] args)
    {
        ArrayStringBag test = new ArrayStringBag("Tester");
        Scanner conIn = new Scanner(System.in);
        
        String skip;        //skip end of line after reading integer
        boolean keepGoing;  //flag for "choose operation" loop
        int constructor;    //indicates user's choice of constructor
        int operation;      //indicated user's choice of operation
        
        //Handle test name
        System.out.println("What is the name of this test?");
        String testName = conIn.nextLine();
        System.out.println("\n This is test " + testName + "\n");
        
        //Handle constructor
        System.out.println("Choose a constructor: \n");
        System.out.println("1: ArrayStringBag(String name)");
        System.out.println("2: ArrayStringBag(String name, int maxSize)\n");
        if(conIn.hasNextInt()) {
            constructor = conIn.nextInt();
        } else {
            System.out.println("Error: you must enter an integer.");
            System.out.println("Terminating Test.");
            return;
        }
        skip = conIn.nextLine();
        
        switch(constructor)
        {
            case 1:
                test = new ArrayStringBag(testName);
                break;
                
            case 2: 
                System.out.println("\nEnter a maximum size:");
                int maxSize;
                if(conIn.hasNextInt()) {
                    maxSize = conIn.nextInt();
                } else {
                    System.out.println("Error: you must enter an integer.");
                    System.out.println("Terminating test.");
                    return;
                }
                skip = conIn.nextLine();
                test = new ArrayStringBag(testName, maxSize);
                break;
                
                default:
                System.out.println("Error in constructor choice. Test Terminated.");
                return;
        }
        
        //Handle test cases
        keepGoing = true;
        while (keepGoing) 
        {
            System.out.println("\nChoose an operation:\n");
            System.out.println("1: insert(String element)");
            System.out.println("2: clear()");
            System.out.println("3: isEmpty()");
            System.out.println("4: isFull()");
            System.out.println("5: size()");
            System.out.println("6: getName()");
            System.out.println("7: howMany(String element)");
            System.out.println("8: uniqInsert(String element)");
            System.out.println("9: delete(String element)");
            System.out.println("10: deleteAll(String element)");
            System.out.println("11: remove()");
            System.out.println("12: show contents");
            System.out.println("13: stop Testing \n"); 
            if (conIn.hasNextInt()){
                operation = conIn.nextInt();
            } else {
                System.out.println("Error: you must enter an integer.");
                System.out.println("Terminating test.");
                return;
            } 
            skip = conIn.nextLine();
            
            switch(operation)
            {
                case 1:     //insert
                System.out.println("\nEnter a string to insert:");
                String insertString = conIn.nextLine();
                test.insert(insertString);
                break;
                
                case 2:     //clear
                test.clear();
                break;
                
                case 3:     //isEmpty
                System.out.println("\nResult: " + test.isEmpty());
                break;
                
                case 4:     //isFull
                System.out.println("\nResult: " + test.isFull());
                break;
                
                case 5:     //size
                System.out.println("\nResult: " + test.size());
                break;
                
                case 6:     //getName
                System.out.println("\nResult: " + test.getName());
                break;
                
                case 7:     //howMany
                System.out.println("\nEnter string to search for:");
                String searchString = conIn.nextLine();
                System.out.println("\nResult: " + test.howMany(searchString));
                break;
                
                case 8:     //uniqInsert
                System.out.println("\nEnter string to insert:");
                String uniqueString = conIn.nextLine();
                System.out.println("\nResult: " + test.uniqInsert(uniqueString));
                break;
                
                case 9:     //delete
                System.out.println("\nEnter string to delete:");
                String deleteString = conIn.nextLine();
                System.out.println("\nResult: " + test.delete(deleteString));
                break;
                
                case 10:    //deleteAll
                System.out.println("\nEnter string to delete all occurences:");
                String multiDelString = conIn.nextLine();
                System.out.println("\nResult: " + test.deleteAll(multiDelString));
                break;
                
                case 11:    //remove
                System.out.println("\nResult: " + test.remove());
                break;
                
                case 12:    //show contents
                System.out.println(test);
                break;
                
                case 13:    //stop testing
                keepGoing = false;
                break;
                
                default:
                System.out.println("\nError in operation choice. Test terminated.");

                    
            }
        }
        System.out.println("\nEnd of Interactive Test Driver");
    }
}