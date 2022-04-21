import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    private static  ArrayList<String> menuList = new ArrayList<>();

    public static void main(String[] args)
    {

	ArrayList<String> menuList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    boolean done = false;
    boolean userQuit = false;

    String menuChoice = "";
    String userInput = "";

    int listNum;

    do
    {
        System.out.print("Please choose an option: ");
        menuChoice = SafeInput.getRegExString(in, "\n A – Add an item to the list \n D – Delete an item from the list \n P – Print the list \n Q – Quit the program","\n [aAdDpPqQ]");

        switch(menuChoice)
        {
            case "A":
                userInput = SafeInput.getNonZeroLenString(in, "Enter an item to add to the list: ");
                menuList.add(userInput);
                System.out.println(userInput + "has been added to the list! ");
                break;
            case "D":
                if (menuList.size() > 0)
                {

                }
                else
                {
                    System.out.println("There is currently nothing in the list to delete");
                }
                break;
            case "P":
                System.out.println("The current list looks like: ");
                displayArrayList();
                break;
            case "Q":
                userQuit = SafeInput.getYNConfirm(in,"Are you sure you want to quit?: ");
                break;
        }

    }while(!done); // deliberate infinite loop
    }


    private static void displayArrayList()
    {
        int counter = 0;

        if (menuList.size() == 0)
        {
            System.out.println("\n The list is empty!");
        }
        else
        {
            System.out.println(menuList);
            counter++;
            System.out.println("There are " + counter + "items in the list");
        }
    }
}
