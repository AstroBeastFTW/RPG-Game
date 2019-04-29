package bleh;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyButton extends JButton 
{

    private static final long serialVersionUID = 1L;

    private Color circleColor = Color.BLACK;

    public MyButton(String label) {
        super(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension originalSize = super.getPreferredSize();
        int gap = (int) (originalSize.height * 0.2);
        int x = originalSize.width + gap;
        int y = gap;
        int diameter = originalSize.height - (gap * 2);

        g.setColor(circleColor);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += size.height;
        return size;
    }

    /*Test the button*/
    public static void main(String[] args) {
        MyButton button = new MyButton("Hello, World!");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(button);

        frame.setVisible(true);
    }

}