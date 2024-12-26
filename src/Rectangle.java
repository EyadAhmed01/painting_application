import java.awt.*;
import java.util.Map;

public class Rectangle extends Interfaces_overrides {
    private int w;
    int h;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getFillColor());
        g.fillRect(getPosition().x, getPosition().y,  w,  h);

        g.setColor(getColor());
        g.drawRect(getPosition().x, getPosition().y,  w,  h);
        g.setClip(426,31,830,602);

    }
}