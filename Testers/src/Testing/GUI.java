package Testing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI
{
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
	public static void main(String args[]) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("FILE");
		mb.add(m1);
		JMenuItem m11 = new JMenuItem("Save");
		JMenuItem m12 = new JMenuItem("Open");
		m1.add(m11);
		m1.add(m12);
		
		
		
		
		
		JTextArea ta = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		
		
		
		
		JPanel pane = new JPanel(new GridBagLayout());
		JButton button;
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
		                //natural height, maximum width
		                c.fill = GridBagConstraints.HORIZONTAL;
		}

		button = new JButton("Fight");
		if (shouldWeightX) {
		                   c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; 
		c.gridx = 0;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Info");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Spells");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		pane.add(button, c);

		/*button = new JButton("Long-Named Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(button, c);*/

		button = new JButton("Pause");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		pane.add(button, c);
		
		
		f.getContentPane().add(mb, BorderLayout.NORTH);
		f.getContentPane().add(ta, BorderLayout.CENTER);
		f.getContentPane().add(pane, BorderLayout.SOUTH);
		f.setVisible(true);
	}
}

