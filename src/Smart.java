import java.util.Random;

public class Smart implements Player {

    String name = "SmartCpu";
    /***
     *
     * @return marbles to take off
     */
    public int marblesToTake() {
        /***
         * stores marbles to take off bu a CPU
         */
        int marbles;

        //If checks is amount of matbles in a pile Is power of two minus one, than calls random take of
        if(IsPowerOfTwoMinusOne(Main.marblesInPile)){
            if(Main.marblesInPile != 1){
                Random r = new Random();
                marbles = r.nextInt((Main.marblesInPile)/2) + 1;
            }
            else marbles =1;

        }
        //else compute take off marbles to make amount in a pile power of two minus one
        else {
            int j=0;
                for (int i=1; i<6; i++)
                {
                    if ((Math.pow(2,i)-1)<Main.marblesInPile/2){
                        j=i;
                    }
                }
            marbles= (int)(Main.marblesInPile - Math.pow(2,j));
            }

        return marbles;
    }

    private boolean IsPowerOfTwoMinusOne(int marblesInPile)
    {
        marblesInPile+=1;
        return (marblesInPile != 0) && ((marblesInPile & (marblesInPile - 1)) == 0);
    }

    /***
     *
     * @return name
     */
     public String Name() {
        return name;
    }
}
