import javax.swing.*;

public class Main extends JFrame {
    public Main(){
        super("Canciones A Excel");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Gui prueba=new Gui();
        this.add(prueba);

        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        Main prueba=new Main();
    }
}
