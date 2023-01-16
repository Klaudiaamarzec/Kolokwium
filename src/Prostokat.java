import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Prostokat extends Figura
{
    /**
     * @param buf
     * @param del
     * @param w
     * @param h
     */

    /*protected int punktSX;  //punkt startowy x,y
    protected int punktSY;
    protected int punktKX;  //punkt koncowy x,y
    protected int punktKY;*/

    public Prostokat(Graphics2D buf, int del, int w, int h)
    {
        super(buf,del,w,h);
        shape = new Rectangle2D.Float(0,0,20,10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}