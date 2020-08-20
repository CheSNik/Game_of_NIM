import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


/**
 * Lab 3 P6.6
 * @author Sergei Chekhonin
 * This program simulates game of Nim
 */

public class Main {


    /**
     * marblesInPile - stores amount of marbles in a pile
     */
    public static int marblesInPile;

    public static void main(String[] args) {
        final int low = 10;
        final int high = 101;
        /***
         * stores turn of players. 0 - CPU's turn, 1 - Human's turn
         */
        boolean Turn;
        /***
         * defines if CPU is smart. 0 - CPU is Silly, 1 - CPU is smart
         */
        boolean isCpuSmart;


        //This block initialize printWriter and dateFormatter
        PrintWriter out = null;
        try {
            out = new PrintWriter("Lab3_P6.6output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // instantiation a Random object
        Random r = new Random();
        marblesInPile = r.nextInt(high-low) + low;
        Turn = r.nextBoolean();
        isCpuSmart = r.nextBoolean();

        //Instantiate CPU, Human, JFrame objects
        Player player = null; //using interface
        Player cpuSmart  = new Smart();
        Player cpuSilly = new Silly();
        Player human = new Human();
        final JFrame frame = new JFrame();

        out.println(dtf.format(now));
        out.println("Let's start game of Nim");
        out.println("It is randomly chosen "+ Integer.toString(marblesInPile) + " marbles for a pile");
        JOptionPane.showMessageDialog(frame,
                "It is randomly chosen "+ Integer.toString(marblesInPile) + " marbles for a pile",
                "The Game of NIM",
                JOptionPane.PLAIN_MESSAGE);
        //set the player according to turn
        if (Turn) {
            player = human;
        }
        else {
            if (isCpuSmart)
                player = cpuSmart;
            else
                player = cpuSilly;
        }

        while (marblesInPile > 0)
        {

            //printout message
            out.println("Turn is for "+ player.Name());
            out.println("It is left "+ marblesInPile +" marbles in a pile");
            JOptionPane.showMessageDialog(frame,
                    "Turn is for "+ player.Name(),
                    "The Game of NIM",
                    JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(frame,
                    "It is left "+ marblesInPile +" marbles in a pile",
                    "The Game of NIM",
                    JOptionPane.PLAIN_MESSAGE);

            //call method to take off marbles from pail
            int playerTook = player.marblesToTake();

            //change number of marbles in a pile after take off
            marblesInPile = marblesInPile - playerTook;

            //printout message
            out.println(player.Name() + " took "+ Integer.toString(playerTook) + " marbles from pail" );
            if (player == cpuSilly || player == cpuSmart) {
                JOptionPane.showMessageDialog(frame,
                        "CPU took "+ Integer.toString(playerTook) + "marbles from pail",
                        "The Game of NIM",
                        JOptionPane.PLAIN_MESSAGE);
            }

            //printout if the game is over
            if (marblesInPile == 0)
            {
                out.println("Player " + player.Name()+ "loose!");
                JOptionPane.showMessageDialog(frame,
                        "Player " + player.Name()+ " looses!",
                        "The Game of NIM",
                        JOptionPane.PLAIN_MESSAGE);
            }

            //change players turn
            if (player == human) {
                if (isCpuSmart)
                    player = cpuSmart;
                else
                    player = cpuSilly;
            }
            else
                player = human;



        }

        out.close();
        System.exit(0);
    }


}
