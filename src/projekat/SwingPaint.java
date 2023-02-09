package projekat;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
 
public class SwingPaint {
 
	JToggleButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn,smanjiKrug,smanjiPrav,povecaj1,povecaj2,puno,puno2;

  DrawArea drawArea;
  JRadioButton dugme1,dugme2,dugme3;

  ButtonGroup grupa=new ButtonGroup();
  ButtonGroup grupa1=new ButtonGroup();
  ButtonGroup grupa2=new ButtonGroup();
  ButtonGroup grupa3=new ButtonGroup();
 
  
 
 
  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
      } else if (e.getSource() == blackBtn) {
        drawArea.black();
      } else if (e.getSource() == blueBtn) {
        drawArea.blue();
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
      } else if (e.getSource() == redBtn) {
        drawArea.red();
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
      }
    }
  };
 
  public static void main(String[] args) {
    new SwingPaint().show();
    
  }
 
  public void show() {
  
    JFrame frame = new JFrame("Swing Paint"); 
    Container content = frame.getContentPane();
  
    content.setLayout(new BorderLayout());
   
    drawArea = new DrawArea();
 
    // 
    content.add(drawArea, BorderLayout.CENTER);
 
    // 
    JPanel posebni=new JPanel();
    posebni.setLayout(new GridLayout(3,1));
    JPanel controls = new JPanel();
    JPanel kontrole=new JPanel();

    clearBtn = new JToggleButton("Obrisi");
    clearBtn.addActionListener(actionListener);

    blackBtn = new JToggleButton("Crna");

    blackBtn.addActionListener(actionListener);
    blueBtn = new JToggleButton("Plava");

    blueBtn.addActionListener(actionListener);
    greenBtn = new JToggleButton("Zelena");

    greenBtn.addActionListener(actionListener);
    redBtn = new JToggleButton("Crvena");

    redBtn.addActionListener(actionListener);
    magentaBtn = new JToggleButton("Roza");

    magentaBtn.addActionListener(actionListener);
        
    
    
    dugme1=new JRadioButton("Linija");
    dugme1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent d)
          { drawArea.type=1;  drawArea.repaint(); }
      });
    dugme2=new JRadioButton("Krug");
    dugme2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent d)
          {  drawArea.type=2;  drawArea.repaint(); }
      });
    dugme3=new JRadioButton("Pravougaonik");
    dugme3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent d)
          {  drawArea.type=3;  drawArea.repaint(); }
      });
    
   
  
    Icon icon4 = new ImageIcon("manjiprav.png");
    puno2=new JToggleButton(icon4);
    puno2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent d)
          {  drawArea.type=4;  drawArea.repaint(); }
      });
    Icon icon5 = new ImageIcon("manjikrug.png");
    puno=new JToggleButton(icon5);
    puno.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent d)
          {  drawArea.type=5;  drawArea.repaint(); }
      });
    Icon icon = new ImageIcon("najmanjik.png");
    smanjiKrug= new JToggleButton(icon);
    smanjiKrug.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent d) {
	
			{  drawArea.type=6;	    
			   drawArea.repaint();}
			
		}
	});
    Icon icon2 = new ImageIcon("najmanjip.png");
    smanjiPrav= new JToggleButton(icon2);
    smanjiPrav.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent d) {
			{  drawArea.type=7; 
			   drawArea.repaint(); }
			
		}
	});
    Icon icon1 = new ImageIcon("vecikrug.png");
    povecaj1= new JToggleButton(icon1);
    povecaj1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent d) {
			{  drawArea.type=8; 
			   drawArea.repaint(); }
			
		}
	});
    Icon icon3 = new ImageIcon("veciprav.png");
    povecaj2= new JToggleButton(icon3);
    povecaj2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent d) {
			{  drawArea.type=9; 
			   drawArea.repaint(); }
			
		}
	});
   
    //
    grupa.add(greenBtn);
    grupa.add(blueBtn);
    grupa.add(blackBtn);
    grupa.add(redBtn);
    grupa.add(magentaBtn);
    grupa.add(clearBtn);
   
    grupa1.add(dugme1);
    grupa1.add(dugme2);
    grupa1.add(dugme3);
    grupa1.add(puno);
    grupa1.add(puno2);
    
    
    
 
    	
    grupa1.add(smanjiKrug);
    grupa1.add(smanjiPrav);
    grupa1.add(povecaj1);
    grupa.add(povecaj2);
    
    //  p
    controls.add(greenBtn);
    controls.add(blueBtn);
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(clearBtn);
    

    posebni.add(smanjiKrug);
    posebni.add(smanjiPrav);
    posebni.add(povecaj1);
    posebni.add(povecaj2);

    posebni.add(puno);
    posebni.add(puno2);
    
    kontrole.add(dugme1);
    kontrole.add(dugme2);
    kontrole.add(dugme3);
  
    // 
    content.add(controls, BorderLayout.NORTH);
    content.add(kontrole, BorderLayout.SOUTH);
    content.add(posebni,BorderLayout.EAST);
 
    frame.setSize(700, 700);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
 

  }


	
}




 


