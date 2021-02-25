
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


/* 

COMMENTS FROM THE INSTRUCTOR:

I love the clean look of this code, Jonathan--very easy to look through
and understand. You didn't get a chance to implement the default (Y/n)
option as described in the assignment handout. More importantly, there
are some interesting issues that make the game not follow the rules of
craps consistently. Here's a listing from my game play, with some comments:

    Would you like to know the rules of the game? (yes/no)

    Enjoy the game!
    hit <Enter> to roll

    Roll #1
    You rolled a 7          7 on first roll means I should have won!
    hit <Enter> to roll again

    You rolled a 7
    You lost the game!
    Would you like to play again? (yes/no)

    You rolled a 2
    You lost the game!
    Would you like to play again? (yes/no)

    You rolled a 7          7 on this first roll and I *did* win!
    You won the game!
    Would you like to play again? (yes/no)

    hit <Enter> to roll

    You rolled a 6          6 on the first roll wins??! No!
    You won the game!
    Would you like to play again? (yes/no)

So, the program runs, but the rules aren't correctly implemented. Some
work to do still!

SCORE: 11/15

*/

