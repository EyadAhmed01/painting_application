import java.awt.*;
import java.util.Map;

public abstract class Interfaces_overrides implements Shape{

    private Point position;
    private Map<String, Double> properties;
    private Color color;
    private Color fillColor;
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return color;
    }

    @Override
    public abstract void draw(Graphics canvas) ;
}
