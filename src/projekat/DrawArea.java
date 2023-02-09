package projekat;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import javax.swing.JComponent;
 
/**
* Component for drawing !
*
*
*
*/
public class DrawArea extends JComponent { 

 
  //Image na kojem ce da se crta
  private Image image;
  //Graphics 2D objekat za crtanje visedimenzijonalnih linija i oblika
  private Graphics2D g2; 
  //Kordinate
  private int currentX, currentY, oldX, oldY;

  public int type = 1;//deklaracija i inicijalizacija promenljive za switch
  public Shape shape;

  public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
 
  public DrawArea() {
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
    	 //cuva kordinate x i y kada je mis pritisnut
        oldX = e.getX();
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        currentX = e.getX();
        currentY = e.getY();
        
 
        if (g2 != null) { //nacrtati sledece oblike ako g2 kontekst nije null
        
        		switch (type) {
        		case 1:  g2.drawLine(oldX, oldY, currentX, currentY);
        				break;
        		case 2: g2.drawOval(oldX, oldY, 25, 25);
        				break;											//Crta oblik 
        		case 3: g2.drawRect(oldX, oldY,25, 25);
        				break;

        		case 4: g2.fillRect(oldX, oldY, 25, 25);
        			
        				break;
        		case 5:g2.fillOval(oldX, oldY, 25, 25);
        			  
        			
        				break;
     
        		case 6:	g2.fillOval(oldX-10,oldY-10, 10, 10);
        			   break;

        		case 7: g2.fillRect(oldX-10, oldY-10, 10, 10);
						break;
        		case 8: g2.fillOval(oldX-10, oldY-10, 70, 70);
        				break;
        		case 9:g2.fillRect(oldX-10, oldY-10, 70, 70);
				break;
        		}
        	}	
        	
        
        

        repaint();
  
          
          oldX = currentX;
          oldY = currentY;
        

      }
      

    });
  }

	private Shape smanjiOblik() {
		if (g2!=null) {
			 g2.drawOval(oldX-10, oldY, 20, 20);
		} else if (shape == g2) {
			g2.drawRect(oldX, oldY,20, 20);
			
		}
		return null;
	}
	

  protected void paintComponent(Graphics g) {
    if (image == null) {

      image = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();

      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      clear();

    }
 
    g.drawImage(image, 0, 0, null);
  }
 

  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();

  }
 
  public void red() {

    g2.setPaint(Color.red);
  }
   {
	 

	  }
 
  public void black() {
    g2.setPaint(Color.black); 
    
	}
  
 
  public void magenta() {
    g2.setPaint(Color.magenta);

  }
 
  public void green() {
    g2.setPaint(Color.green);

  }
 
  public void blue() {
    g2.setPaint(Color.blue);


  }
  
}