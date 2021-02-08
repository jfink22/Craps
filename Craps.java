
/**
 * Write a description of class Craps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Craps
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Die d1 = new Die();
        Die d2 = new Die();
        
        boolean exit = false;
        
        System.out.println("Would you like to know the rules of the game? (yes/no)");
        String rule = in.nextLine();
        if (rule.equals("yes"))
        {
            System.out.println("A player rolls two six-sided dice and adds the two numbers together");
            System.out.println("If the roll adds up to a 7 or 11, they win, if it adds up to a 2, 3, or 12, they lose.");
            System.out.println("If the roll adds up to any other number not listed, that number becomes the 'point.'");
            System.out.println("The following rolls, the player tries to roll the value of the 'point' to win without rolling a 7, in which case they lose.");
        }
        else
        {
            System.out.println("Enjoy the game!");
        }
        while (exit != true)
        {
            int roll = 1;
        int total = d1.roll() + d2.roll();
        if (total == 7 || total == 11)
        {
            System.out.println("You rolled a " + total);
            System.out.println("You won the game!");
        }
        else if (total == 2 || total == 3 || total == 12)
        {
            System.out.println("You rolled a " + total);
            System.out.println("You lost the game!");
        }
        else
        {
            int point = total;
            total = d1.roll() + d2.roll();
            System.out.println("hit <Enter> to roll");
            String cont = in.nextLine();
            while (total != 7 && total != point && cont.equals(""))
            {
                total = d1.roll() + d2.roll();
                System.out.println("Roll #" + roll);
                System.out.println("You rolled a " + total);
                roll++;
                System.out.println("hit <Enter> to roll again");
                cont = in.nextLine();
            }
            if (total == point)
            {
                System.out.println("You rolled a " + total);
                System.out.println("You won the game!");
            }
            else
            {
                System.out.println("You rolled a " + total);
                System.out.println("You lost the game!");
            }
        }
        System.out.println("Would you like to play again? (yes/no)");
        String game = in.nextLine();
        if (game.equals("no"))
        {
            exit = true;
        }
    }
    }
}
