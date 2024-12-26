import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class MainWin extends JFrame implements DrawingEngine {
    private JPanel Drawing;
    private JComboBox comboBox1;
    private JButton colorizeButton;
    private JButton deleteButton;
    private JButton circleButton;
    private JButton squareButton;
    private JButton rectButton;
    private JButton lineSegmentButton;
    private JPanel canvas;
    private JPanel circleProp;
    private JTextField xCircle;
    private JTextField circleRadius;
    private JTextField yCircle;
    private JButton circleDone;
    private JPanel squareProp;
    private JPanel rectProp;
    private JPanel lineProp;
    private JButton squareDone;
    private JButton rectDone;
    private JButton lineDone;
    private JTextField rectWidth;
    private JTextField rectHeight;
    private JTextField xRect;
    private JTextField yRect;
    private JTextField ySquare;
    private JTextField xSquare;
    private JTextField squareSide;
    private JTextField X1;
    private JTextField Y1;
    private JTextField X2;
    private JTextField Y2;
    private JColorChooser colorChooser;
    private JButton colorDn;
    private JButton resize;
    private JButton save;
    private JButton load;
    private JPanel editPanel;
    private JTextField newRadius;
    private JTextField newX;
    private JTextField newY;
    private JButton Edit;
    private JLabel newRadiusLabel;
    private JButton done;
    private JTextField newSqLength;
    private JLabel newSqLengthLbl;
    private JLabel newRectHeightLbl;
    private JLabel newRectWidthLbl;
    private JTextField newRectHeight;
    private JTextField newRectWidth;
    private JLabel newX1Label;
    private JLabel newX2Label;
    private JLabel newY1Label;
    private JLabel newY2Label;
    private JTextField newX1;
    private JTextField newX2;
    private JTextField newY1;
    private JTextField newY2;
    private JLabel yLabel;
    private JLabel xLabel;
    private JButton close;
    private JButton delAll;
    private JFileChooser fileChoose;
    private JPanel coloring;
    public ArrayList<Shape> shapes;
    public MainWin() {

        shapes = new ArrayList<>();
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPanel.setVisible(false);
                repaint();
                circleProp.setVisible(true);
                squareProp.setVisible(false);
                rectProp.setVisible(false);
                lineProp.setVisible(false);
            }
        });
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                editPanel.setVisible(false);
                squareProp.setVisible(true);
                circleProp.setVisible(false);
                rectProp.setVisible(false);
                lineProp.setVisible(false);
            }
        });
        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                editPanel.setVisible(false);
                rectProp.setVisible(true);
                circleProp.setVisible(false);
                squareProp.setVisible(false);
                lineProp.setVisible(false);
            }
        });
        lineSegmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                editPanel.setVisible(false);
                lineProp.setVisible(true);
                circleProp.setVisible(false);
                squareProp.setVisible(false);
                rectProp.setVisible(false);
            }
        });
        circleDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                repaint();
                editPanel.setVisible(false);

                if (isPositiveNumber(circleRadius.getText()) && isPositiveNumber(xCircle.getText()) && isPositiveNumber(circleRadius.getText())) {
                    System.out.println("Valid inputs. Proceeding with creation.");

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(circleDone);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid values for radius and position.");
                }
                doCircle(Integer.parseInt(circleRadius.getText()), Integer.parseInt(xCircle.getText()), Integer.parseInt(yCircle.getText()));
                circleProp.setVisible(false);
            }
        });
        lineDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();


                if (isPositiveNumber(X1.getText()) && isPositiveNumber(X2.getText()) && isPositiveNumber(Y1.getText()) && isPositiveNumber(Y2.getText())) {
                    System.out.println("Valid inputs. Proceeding with creation.");

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(squareDone);

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid values");
                }
                doLine(Integer.parseInt(X1.getText()), Integer.parseInt(X2.getText()), Integer.parseInt(Y1.getText()), Integer.parseInt(Y2.getText()));
                lineProp.setVisible(false);
            }
        });
        squareDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();


                if (isPositiveNumber(squareSide.getText()) && isPositiveNumber(xSquare.getText()) && isPositiveNumber(ySquare.getText())) {
                    System.out.println("Valid inputs. Proceeding with creation.");

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(squareDone);
//
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid values");
                }
                doSquare(Integer.parseInt(squareSide.getText()), Integer.parseInt(xSquare.getText()), Integer.parseInt(xSquare.getText()));
                squareProp.setVisible(false);
            }
        });
        rectDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();


                if (isPositiveNumber(rectHeight.getText()) && isPositiveNumber(rectWidth.getText()) && isPositiveNumber(xRect.getText()) && isPositiveNumber(yRect.getText())) {
                    System.out.println("Valid inputs. Proceeding with creation.");

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rectDone);
//
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid values");
                }
                doRect(Integer.parseInt(rectWidth.getText()), Integer.parseInt(rectHeight.getText()), Integer.parseInt(xRect.getText()), Integer.parseInt(yRect.getText()));
                rectProp.setVisible(false);
            }
        });
        colorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorChooser.setVisible(false);
                colorDn.setVisible(false);
                circleProp.setVisible(false);
                squareProp.setVisible(false);
                rectProp.setVisible(false);
                lineProp.setVisible(false);
                colorChooser.setVisible(true);
                colorDn.setVisible(true);

            }
        });
        colorDn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorChooser.setVisible(false);
            }
        });
        colorDn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorDn.setVisible(false);
                Color target = colorChooser.getColor();
                Shape shape = (Shape) comboBox1.getSelectedItem();
                shape.setColor(target);
                shape.setFillColor(target);
                repaint();

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shape shape = (Shape) comboBox1.getSelectedItem();
                shapes.remove(shape);
                comboBox1.removeItem(shape);
                repaint();

            }
        });
        resize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorChooser.setVisible(false);
                colorDn.setVisible(false);
                circleProp.setVisible(false);
                squareProp.setVisible(false);
                rectProp.setVisible(false);
                lineProp.setVisible(false);
                repaint();
                comboBox1.getName();
                if (comboBox1.getSelectedItem() != null) {
                    String[] typeA = comboBox1.getSelectedItem().toString().split("@");
                    System.out.println(typeA[0]);
                    if (typeA[0].equals("Rectangle")) {

                        editPanel.setVisible(true);
                        newX1.setVisible(false);
                        newX2.setVisible(false);
                        newY1.setVisible(false);
                        newY2.setVisible(false);
                        newRectHeight.setVisible(true);
                        newRectWidth.setVisible(true);
                        newRectHeightLbl.setVisible(true);
                        newRectWidthLbl.setVisible(true);

                        newRadius.setVisible(false);
                        newRadiusLabel.setVisible(false);
                        newSqLength.setVisible(false);
                        newSqLengthLbl.setVisible(false);
                        newX1.setVisible(false);
                        newX2.setVisible(false);
                        newY1.setVisible(false);
                        newY2.setVisible(false);
                        newX1Label.setVisible(false);
                        newX2Label.setVisible(false);
                        newY1Label.setVisible(false);
                        newY2Label.setVisible(false);


                    }

                    if (typeA[0].equals("LineSegment")) {
                        editPanel.setVisible(true);
                        newX1.setVisible(true);
                        newX2.setVisible(true);
                        newY1.setVisible(true);
                        newY2.setVisible(true);
                        newX.setVisible(false);
                        yLabel.setVisible(false);
                        xLabel.setVisible(false);
                        newY.setVisible(false);
                        newRadius.setVisible(false);
                        newRadiusLabel.setVisible(false);
                        newSqLength.setVisible(false);
                        newSqLengthLbl.setVisible(false);
                        newRectHeight.setVisible(false);
                        newRectWidth.setVisible(false);
                        newRectHeightLbl.setVisible(false);
                        newRectWidthLbl.setVisible(false);
                        newX1Label.setVisible(true);
                        newX2Label.setVisible(true);
                        newY1Label.setVisible(true);
                        newY2Label.setVisible(true);

                    }
                    if (typeA[0].equals("Square")) {
                        newSqLength.setVisible(true);
                        newSqLengthLbl.setVisible(true);
                        editPanel.setVisible(true);
                        newX1.setVisible(false);
                        newX2.setVisible(false);
                        newY1.setVisible(false);
                        newY2.setVisible(false);
                        newRadius.setVisible(false);
                        newRadiusLabel.setVisible(false);
                        newRectHeight.setVisible(false);
                        newRectWidth.setVisible(false);
                        newRectHeightLbl.setVisible(false);
                        newRectWidthLbl.setVisible(false);
                        newX1.setVisible(false);
                        newX2.setVisible(false);
                        newY1.setVisible(false);
                        newY2.setVisible(false);
                        newX1Label.setVisible(false);
                        newX2Label.setVisible(false);
                        newY1Label.setVisible(false);
                        newY2Label.setVisible(false);

                    }
                    if (typeA[0].equals("Circle")) {
                        newRadius.setVisible(true);
                        newRadiusLabel.setVisible(true);
                        editPanel.setVisible(true);
                        newX1.setVisible(false);
                        newX2.setVisible(false);
                        newY1.setVisible(false);
                        newY2.setVisible(false);
                        newSqLength.setVisible(false);
                        newSqLengthLbl.setVisible(false);
                        newRectHeight.setVisible(false);
                        newRectWidth.setVisible(false);
                        newRectHeightLbl.setVisible(false);
                        newRectWidthLbl.setVisible(false);
                        newX1.setVisible(false);
                        newX2.setVisible(false);
                        newY1.setVisible(false);
                        newY2.setVisible(false);
                        newX1Label.setVisible(false);
                        newX2Label.setVisible(false);
                        newY1Label.setVisible(false);
                        newY2Label.setVisible(false);

                    }
                }
            }
        });
        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                repaint();
                Shape shape = (Shape) comboBox1.getSelectedItem();
                Point point = new Point();
                String[] type = comboBox1.getSelectedItem().toString().split("@");
                System.out.println(type[0]);
                if (type[0].equals("Circle")) {
                    Circle circle = (Circle) comboBox1.getSelectedItem();

                    if (!newX.getText().isEmpty() && !newY.getText().isEmpty()) {
                        point.y = Integer.parseInt(newY.getText());
                        point.x = Integer.parseInt(newX.getText());
                        circle.setPosition(point);
                    }
                    if (!newRadius.getText().isEmpty()) {
                        circle.setRadius(Integer.parseInt(newRadius.getText()));
                    }
                    System.out.println(circle);
                    repaint();
                }
                if (type[0].equals("Square")) {
                    Square square = (Square) comboBox1.getSelectedItem();

                    if (!newX.getText().isEmpty() && !newY.getText().isEmpty()) {
                        point.y = Integer.parseInt(newY.getText());
                        point.x = Integer.parseInt(newX.getText());
                        square.setPosition(point);
                    }
                    if (!newSqLength.getText().isEmpty()) {
                        square.setSide(Integer.parseInt(newSqLength.getText()));
                    }
                    repaint();
                }
                if (type[0].equals("Rectangle")) {

                    Rectangle rectangle = (Rectangle) comboBox1.getSelectedItem();

                    if (!newX.getText().isEmpty() && !newY.getText().isEmpty()) {
                        point.y = Integer.parseInt(newY.getText());
                        point.x = Integer.parseInt(newX.getText());
                        rectangle.setPosition(point);
                    }
                    if (!newRectHeight.getText().isEmpty()) {
                        rectangle.setH(Integer.parseInt(newRectHeight.getText()));
                    }
                    if (!newRectWidth.getText().isEmpty()) {
                        rectangle.setW(Integer.parseInt(newRectWidth.getText()));
                    }
                    repaint();

                }
                if (type[0].equals("LineSegment")) {
                    LineSegment lineSegment = (LineSegment) comboBox1.getSelectedItem();
                    if (!newX1.getText().isEmpty() || !newX2.getText().isEmpty() || !newY1.getText().isEmpty() || !newY2.getText().isEmpty()) {
                        if (!newX1.getText().isEmpty()) {
                            lineSegment.setX1(Integer.parseInt(newX1.getText()));
                            repaint();

                        }
                        if (!newX2.getText().isEmpty()) {
                            lineSegment.setX2(Integer.parseInt(newX2.getText()));
                            repaint();

                        }
                        if (!newY1.getText().isEmpty()) {
                            lineSegment.setY1(Integer.parseInt(newY1.getText()));
                            repaint();

                        }
                        if (!newY2.getText().isEmpty()) {
                            lineSegment.setY2(Integer.parseInt(newY2.getText()));
                            repaint();

                        }
                    }


                }
                editPanel.setVisible(false);
                repaint();
            }

        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPanel.setVisible(false);
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChoose.setVisible(true);
                int returnValue = fileChoose.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChoose.getSelectedFile();
                    writeToFile(file);
                }

                fileChoose.setVisible(false);
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChoose.setVisible(true);
                int returnValue = fileChoose.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChoose.getSelectedFile();
                    readFromFile(file);
                }

                fileChoose.setVisible(false);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        delAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                comboBox1.removeAllItems();
                repaint();
            }
        });
        fileChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (fileChoose.getSelectedFile() != null) {
                    File file = fileChoose.getSelectedFile();
                    System.out.println("Selected File: " + file);
                    System.out.println("File Name: " + file.getName());
                } else {
                    System.out.println("No file selected.");
                }
            }
        });
    }




    public void writeToFile(File file) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            for (int i = 0; i < shapes.size(); i++) {
                if(shapes.get(i) instanceof Rectangle) {
                    Rectangle rectangle = (Rectangle) shapes.get(i);
                    writer.write("rectangle" + "," + rectangle.getH() + "," + rectangle.getW() + "," + "point" + rectangle.getPosition() + "," + "color:" + rectangle.getFillColor() + "\n");
                }
                if(shapes.get(i) instanceof LineSegment) {
                    LineSegment lineSegment = (LineSegment) shapes.get(i);
                    writer.write("line" + "," + lineSegment.getX1() + "," + lineSegment.getX2() + "," + lineSegment.getY1() + "," + lineSegment.getY2() + "," + "color:" + lineSegment.getFillColor() + "\n");
                }
                if(shapes.get(i) instanceof Square) {
                    Square square = (Square) shapes.get(i);
                    writer.write("square" + "," + square.getSide() + "," + "point" + square.getPosition() + "," + "color:" + square.getColor() + "\n");
                }
                if(shapes.get(i) instanceof Circle) {
                    Circle circle = (Circle) shapes.get(i);
                    writer.write("circle" + "," + circle.getRadius() + "," + "point" + circle.getPosition() + "," + "color:" + circle.getFillColor() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFromFile(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String shapeType = data[0];

                if (shapeType.equals("rectangle")) {
                    int h = Integer.parseInt(data[1]);
                    int w = Integer.parseInt(data[2]);
                    Point position = parsePoint(data[3] + data[4]);
                    Color fillColor = parseColor(data[5] + data[6] + data[7]);
                    Rectangle rectangle = new Rectangle();
                    rectangle.setH(h);
                    rectangle.setW(w);
                    rectangle.setPosition(position);
                    rectangle.setColor(fillColor);
                    addShape(rectangle);
                    comboBox1.addItem(rectangle);
                }
                else if (shapeType.equals("line")) {
                    int x1 = Integer.parseInt(data[1]);
                    int x2 = Integer.parseInt(data[2]);
                    int y1 = Integer.parseInt(data[3]);
                    int y2 = Integer.parseInt(data[4]);
                    Color fillColor = parseColor(data[5] + data[6] + data[7]);
                    LineSegment lineSegment = new LineSegment();
                    lineSegment.setX1(x1);
                    lineSegment.setX2(x2);
                    lineSegment.setY1(y1);
                    lineSegment.setY2(y2);
                    lineSegment.setColor(fillColor);
                    addShape(lineSegment);
                    comboBox1.addItem(lineSegment);
                }
                else if (shapeType.equals("square")) {
                    int side = Integer.parseInt(data[1]);
                    Point position = parsePoint(data[2] + data[3]);
                    Color fillColor = parseColor(data[4] + data[5] + data[6]);
                    Square square = new Square();
                    square.setSide(side);
                    square.setPosition(position);
                    square.setColor(fillColor);
                    addShape(square);
                    comboBox1.addItem(square);
                }
                else if (shapeType.equals("circle")) {
                    int radius = Integer.parseInt(data[1]);
                    Point position = parsePoint(data[2] + data[3]);
                    Color fillColor = parseColor(data[4] + data[5] + data[6]);
                    Circle circle = new Circle();
                    circle.setRadius(radius);
                    circle.setPosition(position);
                    circle.setColor(fillColor);
                    addShape(circle);
                    comboBox1.addItem(circle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private Point parsePoint(String pointData) {
        System.out.println(pointData);
        try {
            String[] parts = pointData.replace("pointjava.awt.Point[x=", "").replace("y=", ",")
                    .replace("]", "")
                    .split(",");
            for (int i = 0; i < parts.length; i++) {
                System.out.println(parts[i]);
            }

            if (parts.length == 2) {
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                return new Point(x, y);
            }
        } catch (Exception e) {
            System.out.println("Invalid point data: " + pointData);
        }
        return new Point(0, 0);
    }


    private Color parseColor(String colorData) {
        System.out.println(colorData);
        try {
            colorData = colorData.trim();
            if (colorData.startsWith("color:java.awt.Color[r=") && colorData.contains("g=") && colorData.contains("b=")) {
                colorData = colorData.replace("color:java.awt.Color[r=", "").replace("]", "").replace("g=",",").replace("b=",",");
                System.out.println(colorData);

                String[] parts = colorData.split(",");
                if (parts.length == 3) {
                    int r = Integer.parseInt(parts[0].trim());
                    int g = Integer.parseInt(parts[1].trim());
                    int b = Integer.parseInt(parts[2].trim());

                    System.out.println("Parsed Color: R=" + r + ", G=" + g + ", B=" + b);
                    return new Color(r,g,b);

                } else {
                    System.out.println("Error: Invalid color data after processing.");
                }
            } else {
                System.out.println("Error: Invalid color format.");
            }
        } catch (Exception e) {
            System.out.println("Invalid color data: " + colorData);
        }
        return Color.BLACK;
    }




    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
        comboBox1.removeItem(shape);
        repaint();
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]);
    }

    @Override
    public void refresh(Graphics g) {
        for (Shape shape : shapes) {
            shape.draw(canvas.getGraphics());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        refresh(g);
    }

    public void display(){
        colorChooser.setVisible(false);
        colorDn.setVisible(false);
        circleProp.setVisible(false);
        squareProp.setVisible(false);
        rectProp.setVisible(false);
        lineProp.setVisible(false);
        editPanel.setVisible(false);
        newRadius.setVisible(false);
        newRadiusLabel.setVisible(false);
        newSqLength.setVisible(false);
        newSqLengthLbl.setVisible(false);
        newRectHeight.setVisible(false);
        newRectWidth.setVisible(false);
        newRectHeightLbl.setVisible(false);
        newRectWidthLbl.setVisible(false);
        newX1.setVisible(false);
        newX2.setVisible(false);
        newY1.setVisible(false);
        newY2.setVisible(false);
        fileChoose.setVisible(false);


        setVisible(true);
        setResizable(false);
        setSize(1400,700);
        setLocation(110,60);
        setContentPane(Drawing);
        System.out.println(canvas.getBounds()+","+canvas.getSize());


    }


    private boolean isPositiveNumber(String text) {
        try {
            int value =Integer.parseInt(text);
            if (value >= 0)
                return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public void doCircle(int radius, int x, int y)
    {
        Circle c1=new Circle();
        c1.setColor(Color.red);
        c1.setFillColor(Color.red);
        c1.setRadius(radius);
        c1.setPosition(new Point(x, y));
        c1.setProperties(Map.of("color",1.0,"fillColor",1.0));
        addShape(c1);
        comboBox1.addItem(c1);
    }   public void doSquare(int side, int x, int y)
    {
        Square s1=new Square();
        s1.setColor(Color.red);
        s1.setFillColor(Color.red);
        s1.setSide(side);
        s1.setPosition(new Point(x, y));
        s1.setProperties(Map.of("color",1.0,"fillColor",1.0));
        addShape(s1);
        comboBox1.addItem(s1);
    }

    public void doRect(int w,int h, int x, int y)
    {
        Rectangle r1=new Rectangle();
        r1.setColor(Color.red);
        r1.setFillColor(Color.red);
        r1.setH(h);
        r1.setW(w);
        r1.setPosition(new Point(x, y));
        r1.setProperties(Map.of("color",1.0,"fillColor",1.0));
        addShape(r1);
        comboBox1.addItem(r1);
    }
    public void  doLine(int x1,int y1, int x2, int y2)
    {
        LineSegment l1=new LineSegment();

        l1.setColor(Color.red);
            l1.setFillColor(Color.red);
            l1.setX1(x1);
            l1.setY1(y1);
            l1.setX2(x2);
            l1.setY2(y2);
        l1.setProperties(Map.of("color",1.0,"fillColor",1.0));
        addShape(l1);
     comboBox1.addItem(l1);
    }





}
