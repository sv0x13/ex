//simple ex with gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class H
{
	public static void main(String[] args) {
		JFrame frame = new JFrame("HelloWorld");
		frame.add(new HC("Hi,friend!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

class HC extends JComponent
implements MouseMotionListener, Runnable
{
	String m;
	int x=95, y=125;
	
	boolean f;
	
	public HC(String msg) {
		m = msg;
		addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}
	public void paintComponent(Graphics g) {
		g.setColor(f?Color.red:Color.black);
		g.drawString(m,x,y);
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void run() {
		try {
			while(true) {
				f = !f;
				repaint();
				Thread.sleep(200);
			}
		}
		catch(InterruptedException ie) {}
	}
}