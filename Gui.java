import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gui extends JPanel implements Runnable, MouseListener {
    private int ancho,alto;
    JFileChooser jFileChooser=new JFileChooser();

    public Gui(){
        super();
        this.alto=this.ancho=720;
        this.setPreferredSize(new Dimension(this.ancho,this.alto));
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        setPreferredSize(new Dimension(ancho, alto));
        addMouseListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setFont(setFont(40));
        g.setColor(Color.white);
        g.drawString("Canciones a Excel", (int) (this.ancho * .30), (int) (this.alto * .10));


        g.setFont(setFont(20));
        g.setColor(Color.white);
        g.drawRect((int) (this.ancho * .27), (int) (this.alto * .40),380,50);
        g.drawString("Selecionar carpeta", (int) (this.ancho * .40), (int) (this.alto * .45));

    }


    public Font setFont(int size){
        Font nuevoFont = new Font("Arial", Font.BOLD, size);
        FontMetrics metr = this.getFontMetrics(nuevoFont);
        return nuevoFont;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((int)(this.ancho*.27)<e.getX() && e.getX()<((int)(this.ancho*.27)+380) && (int)(this.ancho*.40)<e.getY() && e.getY()<((int)(this.ancho*.40)+50)){
            try {
                JfilechooserMethod();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void JfilechooserMethod() throws Exception{
        if(jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            java.io.File file = jFileChooser.getCurrentDirectory();
            //String carpeta= file.getCanonicalPath();
            String carpeta= file.getAbsolutePath();
            //System.out.println(carpeta);
            getFiles prueba=new getFiles();
            prueba.getFiles(carpeta);

        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

    }
}
