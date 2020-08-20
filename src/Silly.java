import java.util.Random;

public class Silly implements Player {

    String name = "SillyCpu";
    /***
     *
     * @return marbles to take off
     */
    public int marblesToTake() {
        int marbles=0;
        if (Main.marblesInPile !=1)
        {
            Random r = new Random();
             marbles= r.nextInt((Main.marblesInPile)/2) + 1;
        }
        else marbles =1;

        return marbles;
    }

    /***
     *
     * @return name
     */
    public String Name() {
        return name;
    }
}
