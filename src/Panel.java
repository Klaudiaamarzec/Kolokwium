import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Panel  extends JPanel implements ActionListener
{
    // bufor
    Image image;
    // wykreslacz ekranowy
    Graphics2D device;
    // wykreslacz bufora
    Graphics2D buffer;
    //Odpowiada za prędkość obiektów
    private int delay;

    Timer timer;
    protected Random rand = new Random();
    Point punktS, punktK;
    HashMap<Point,Point> punkty = new HashMap<>(); //punkty 1.startowy 2.koncowy
    //ArrayList<Point> punktyS = new ArrayList<>(); //punkty startowe
    //ArrayList<Point> punktyK = new ArrayList<>(); //punkty koncowe

    public Panel()
    {
        super();
        delay = rand.nextInt(101);
        setBackground(Color.WHITE);
        timer = new Timer(delay, this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);
                //MousePressed- przyscisk myszy zostaje wcisniety
                //wspolrzedne punktu startowego
                punktS = new Point(e.getX(), e.getY());
                //punktyS.add(punktS);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                //MouseReleased - przycisk myszy zostaje zwolniony
                //wspolrzedne punktu koncowego
                punktK = new Point(e.getX(), e.getY());
                //punktyK.add(punktK);
                //Jezeli puscimy myszke to powstaje figura
                addFig();
            }
        });
    }

    void addFig()
    {
        delay = rand.nextInt(101);
        punkty.put(punktS, punktK);
        int x,y;
        int dlugosc;
        int szerokosc;

        for(Map.Entry<Point,Point> o : punkty.entrySet())
        {
            Point punktS = o.getKey();
            Point punktK = o.getValue();
            x=punktS.x;
            y=punktS.y;
            szerokosc = punktS.x + punktK.x;
            dlugosc = punktS.y + punktK.y;
        }

        punkty.clear(); //Czyszczenie zeby byl tylko 1 punkt ciagle w kolekcji

        Figura fig = new Prostokat(buffer, delay, getWidth(), getHeight());
        //lista.add(fig);
        timer.addActionListener(fig);
        new Thread(fig).start();
    }

    public void initialize()
    {
        int width = getWidth();
        int height = getHeight();

        image = createImage(width, height);
        buffer = (Graphics2D) image.getGraphics();
        buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        device = (Graphics2D) getGraphics();
        device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    void animate()
    {
        if(timer.isRunning())
            timer.stop();
        else
            timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        device.drawImage(image, 0, 0, null);
        buffer.clearRect(0, 0, getWidth(), getHeight());
    }

    /*@Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
    }*/
}
