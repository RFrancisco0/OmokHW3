package noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;

/**
 * Simple NoAppet app to draw a text and an image. The displayed image
 * is obtained from the file <code>src/image/rabbit.jpg</code>, where
 * <code>src</code> is the resource directory of your Java project.
 * Refer to your IDE to designate the resource directory of your project.
 */
@SuppressWarnings("serial")
public class HelloWorld extends NoApplet {

	public HelloWorld() {
	}

	public HelloWorld(String[] params) {
		super(params);
	}
	
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(new Color(155, 0,255));
        g.drawString("FRANCISCO RODRIGUEZ", 60, 40);

        g.drawImage(getImage("rabbit.jpg"), 40, 60, this);
        //g.drawOval(20,20,200,120);
        g.setColor(Color.white);

        g.drawLine(5, 60, 300, 60);
        g.drawLine(10, 50, 10, 320);

        g.drawLine(11, 70, 250, 70);
        g.drawLine(20, 60, 20, 300);

        g.drawLine(11, 80, 250, 80);
        g.drawLine(30, 60, 30, 300);

        g.drawLine(11, 90, 250, 90);
        g.drawLine(40, 60, 40, 300);

        g.drawLine(11, 100, 250, 100);
        g.drawLine(50, 60, 50, 300);

        g.drawLine(11, 110, 300, 110);
        g.drawLine(60, 60, 60, 300);

        g.drawLine(11, 120, 300, 120);
        g.drawLine(70, 60, 70, 300);

        g.drawLine(11, 130, 300, 130);
        g.drawLine(80, 60, 80, 300);

        g.drawLine(11, 140, 300, 140);
        g.drawLine(90, 60, 90, 300);

        g.drawLine(11, 150, 300, 150);
        g.drawLine(100, 60, 100, 300);

        g.drawLine(11, 160, 300, 160);
        g.drawLine(110, 60, 110, 300);

        g.drawLine(11, 170, 300, 170);
        g.drawLine(120, 60, 120, 300);

        g.drawLine(11, 180, 300, 180);
        g.drawLine(130, 60, 130, 300);

        g.drawLine(11, 190, 300, 190);
        g.drawLine(140, 60, 140, 300);

        g.drawLine(11, 200, 300, 200);
        g.drawLine(150, 60, 150, 300);

        g.drawLine(11, 210, 300, 210);
        g.drawLine(160, 60, 160, 300);

        g.drawLine(11, 220, 300, 220);
        g.drawLine(170, 60, 170, 300);

        g.drawLine(11, 230, 300, 230);
        g.drawLine(180, 60, 180, 300);

        g.drawLine(11, 240, 300, 240);
        g.drawLine(190, 60, 190, 300);

        g.drawLine(11, 250, 300, 250);
        g.drawLine(200, 60, 200, 300);

        g.drawLine(11, 260, 300, 260);
        g.drawLine(210, 60, 210, 300);

        g.drawLine(11, 270, 300, 270);
        g.drawLine(220, 60, 220, 300);

        g.drawLine(11, 280, 300, 280);
        g.drawLine(230, 60, 230, 300);

        g.drawLine(11, 290, 300, 290);
        g.drawLine(240, 60, 240, 300);

        g.drawLine(11, 300, 300, 300);
        g.drawLine(250, 60, 250, 300);

        g.setColor(Color.green);
        g.fillOval(215,215,10,10);

        g.setColor(new Color(155, 0,255));
        g.fillOval(205,205,10,10);
    }  

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new HelloWorld(new String[] {"width=330", "height=350"}).run();
    }
}
