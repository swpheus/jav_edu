import java.applet.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.xml.stream.events.StartDocument;
public class JS extends Applet implements Runnable{
 Thread gameThread;
 int width=400, height=400, Max=1;
 int currentX[] = new int[Max];
 int currenty[] = new int[Max];
 int speed=10;
 int directionX[] = new int[Max];
 int directionY[] = new int[Max];
 long start=0;	
 long tick_end_time;
 long tick_duration;
 long sleep_duration;
 static final int MIN_SLEEP_TIME = 10;
 static final int MAX_FPS = 20;
 static final int MAX_MS_PER_FRAME = 1000 / MAX_FPS;
 float fps=0;
 BufferedImage bufferdImg;	
 Graphics2D bufferdImgSurface;

 


	public void start() {
		Thread gameThread = new Thread(this);
		gameThread.start();
	}
	public void init() {
		currentX[0]=100;
		currenty[0]=0;
		directionX[0]=1;
		directionY[0]=0;
		
	}
	public void run() {
		while(true) {
			start=System.currentTimeMillis();
			for(int i =0; i<Max;i++) {
				if(directionX[i]==1) {
					currentX[i]+=speed;
					
				}
				if(directionX[i]==0) {
					currentX[i]-=speed;
				}
				if(currentX[i] <=0) {
					directionX[i]-=speed;
				}
				if(currentX[i]+20 >=width) {
					directionX[i]=0;
				}
				if(directionY[i]==1) {
					currenty[i]+=speed;
				}
				if(directionY[i]==0) {
					currenty[i]-=speed;
				}
				if(currenty[i] <=0) {
					directionY[i]-=speed;
				}
				if(currenty[i]+20 >=width) {
					directionY[i]=0;
				}
				
			}
		}
		
	}
	@Override
		public void repaint() {
			// TODO Auto-generated method stub
		 tick_end_time = System.currentTimeMillis();
		 tick_duration = tick_end_time - start;
		 sleep_duration = MAX_MS_PER_FRAME - tick_duration;
		 
		 if(sleep_duration<MIN_SLEEP_TIME) {
			 sleep_duration =MIN_SLEEP_TIME;
		 }
		 fps =1000/(sleep_duration+tick_duration);
		 try {
			 Thread.sleep(sleep_duration);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		 start =System.currentTimeMillis();
		
		}
	
	@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
		 g.drawString("FPS: "+fps,1,400);
		}
	@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			Graphics2D g2=(Graphics2D)g;
			g2.setBackground(Color.black);
			g2.clearRect(0, 0, width, height);
			g2.setColor(Color.green);
			g2.fillOval(currentX[0], currenty[0], 20, 20);
			
		}
	
 public static void main(String[] args) {
	JS js = new JS();
	js.stop();
 }
}
