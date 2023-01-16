import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ramka extends JFrame
{

    JButton animate = new JButton("Animate");
    public Ramka()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int ww= 600, wh=460;
        setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel();
        panel.setBounds(30,30,520,360);
        contentPane.add(panel);

        animate.setBounds(20,400,100,20);
        contentPane.add(animate);

        animate.addActionListener(e -> panel.animate());

        SwingUtilities.invokeLater(panel::initialize);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            try
            {
                final Ramka frame = new Ramka();
                frame.setVisible(true);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
