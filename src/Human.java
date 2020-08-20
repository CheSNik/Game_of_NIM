import javax.swing.*;

public class Human implements Player{

    String name = "Human";
    /***
     *
     * @return marbles to take off
     */
    public int marblesToTake() {
        boolean flag = true;
        int marbles =0;
        final JFrame frame = new JFrame();

        while (flag){
            String input = JOptionPane.showInputDialog("How many marbles you want to take off?");
            /**
             * stores input marbles to take off
             */
            marbles= Integer.parseInt(input);
            if (marbles <= Main.marblesInPile/2 && marbles!=0)
                flag = false;
            else {
                JOptionPane.showMessageDialog(frame,
                        "Please enter number less than half of a pile",
                        "The Game of NIM",
                        JOptionPane.PLAIN_MESSAGE);
            }


        }


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
