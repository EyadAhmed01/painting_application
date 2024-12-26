import java.awt.*;
import java.util.Map;

public class Square extends Interfaces_overrides {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getFillColor());
        g.fillRect(getPosition().x, getPosition().y,  side,  side);

        g.setColor(getColor());
        g.drawRect(getPosition().x, getPosition().y,  side,  side);
        g.setClip(426,31,830,602);

    }
}