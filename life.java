import javax.swing.JFrame;


public class life extends JFrame{

    public life(){

        add(new lifeStuff());

        setSize(700, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new life();
    }

}
