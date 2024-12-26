import java.awt.*;
import java.util.Map;

public class Circle extends Interfaces_overrides {
    private int radius;


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getFillColor());
        g.fillOval(getPosition().x, getPosition().y,  radius * 2,  radius * 2);

        g.setColor(getColor());
        g.drawOval(getPosition().x, getPosition().y,  radius * 2,  radius * 2);
        g.setClip(426,31,830,602);

    }
}