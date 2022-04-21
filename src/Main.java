import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main
{

    static ArrayList<String> menuList = new ArrayList<>();

    public static void main(String[] args)
    {
    Scanner in = new Scanner(System.in);

    boolean done = false;
    boolean userQuit = false;

    String menuChoice = "";
    String userInput = "";


    int listNum;

    do
    {
        System.out.print("\n Please choose one of the following options ");
        menuChoice = SafeInput.getRegExString(in, "\n A – Add an item to the list \n D – Delete an item from the list \n P – Print the list \n Q – Quit the program", "[aAdDpPqQ]");

        switch(menuChoice)
        {
            case "A": case "a":
                userInput = SafeInput.getNonZeroLenString(in, "Enter an item to add to the list: ");
                menuList.add(userInput);
                System.out.println(userInput + " has been added to the list! ");
                break;
            case "D": case "d":
                if (menuList.size() > 0)
                {
                    displayArrayList();
                    listNum = SafeInput.getRangedInt(in,"Please enter the number corresponding to the list item you want to delete: ",1, menuList.size());
                    listNum = listNum - 1; // Subtract because not asking computer scientists
                    System.out.println("The following item has been deleted from the list: " + menuList.get(listNum));
                    menuList.remove(listNum);
                }
                else
                {
                    System.out.println("\n There is currently nothing in the list to delete");
                }
                break;
            case "P": case "p":
                displayArrayList();
                break;
            case "Q": case "q":
                userQuit = SafeInput.getYNConfirm(in,"Are you sure you want to quit?: ");
                if (userQuit)
                {
                    System.out.println("Quitting program");
                    System.exit(0);
                }
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
            System.out.println("\n The current list looks like: ");
            for (String i : menuList)
            {
                counter++;
                System.out.println(counter + ". " + i);
            }
        }
    }
}
