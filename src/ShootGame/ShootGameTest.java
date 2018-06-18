package ShootGame;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
//��������
public class ShootGameTest extends JPanel{
	public static final int WIDTH=400;
	public static final int HEIGHT=654;
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage bullet;
	static {
		try {
			background=ImageIO.read(ShootGameTest.class.getResource("background.png"));
			start=ImageIO.read(ShootGameTest.class.getResource("start.png"));
			pause=ImageIO.read(ShootGameTest.class.getResource("pause.png"));
			gameover=ImageIO.read(ShootGameTest.class.getResource("gameover.png"));
			airplane=ImageIO.read(ShootGameTest.class.getResource("airplane.png"));
			bee=ImageIO.read(ShootGameTest.class.getResource("bee.png"));
			hero0=ImageIO.read(ShootGameTest.class.getResource("hero0.png"));
			hero1=ImageIO.read(ShootGameTest.class.getResource("hero1.png"));
			bullet=ImageIO.read(ShootGameTest.class.getResource("bullet.png"));
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	private Hero hero= new Hero();
	private FlyingObject[] flyings= {};
	private Bullet[] bullets= {};
	public static final int START=0;//����
	public static final int RUNNING=1;//����
	public static final int PAUSE=2;//��ͣ
	public static final int GAME_OVER=3;//����
	private int state=START;//��ǰ״̬
	//���ɵ��˶���
	public FlyingObject nextOne() {
		Random rand=new Random();
		int type=rand.nextInt(20);
		if(type==0) {
			return new Bee();
		}else {
			return new Airplane();
		}
	}
	int flyIndex=0;
	//airplane+bee�볡
	public void enterAction() {//10����ִ��һ��
		
		flyIndex++;
		if(flyIndex%40==0) {
			FlyingObject obj=nextOne();
			flyings=Arrays.copyOf(flyings, flyings.length+1);//����
			flyings[flyings.length-1]=obj;
		}
	}
	public void stepAction() {
		hero.step();
		for(int i=0;i<flyings.length;i++) {
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++) { 
			bullets[i].step();
		}
	}
	int shootIndex=0;
	public void shootAction() {
		
		shootIndex++;
		if(shootIndex%30==0) {
			Bullet[] bs= hero.shoot();
			bullets=Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
			
		}
	}
	public void outOfBoundsAction() {
		int index=0;
		FlyingObject[] flyingLives=new FlyingObject[flyings.length];
		for(int i=0;i<flyings.length;i++) {//�������е���
			FlyingObject f=flyings[i];//��ȡÿһ������
			if(!f.outOfBounds()) {//���˲�Խ��
				flyingLives[index]=f;//����Խ��ĵ��˴�������
				index++;
			}
		}
		flyings=Arrays.copyOf(flyingLives, index);
		
		index=0;
		Bullet[] bulletLives=new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++) {
			Bullet b=bullets[i];
			if(!b.outOfBounds()) {
				bulletLives[index]=b;
				index++;
			}
		}
		bullets=Arrays.copyOf(bulletLives, index);
	}
	//�����ӵ������е��˵���ײ
	public void collisionAction() {
		for(int i=0;i<bullets.length;i++) {
			Bullet b=bullets[i];
			collision(b);
		}
	}
	int score=0;
	//һ���ӵ������е�����ײ
	public void collision(Bullet b) {
		int index=-1;
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f=flyings[i];
			if(f.shootBy(b)) {
				index=i;//��¼��ײ�����±�
				break;//������˲��ٲ���Ƚ�
			}
		}
		if(index!=-1) {
			FlyingObject one=flyings[index];//��ײ����
			if(one instanceof Enemy) {//���ǵ���
				Enemy e=(Enemy)one;//ǿתΪ����
				score+=e.getScore();//��ҵķ�	
			}
			if(one instanceof Award) {
				Award a=(Award)one;
				int type=a.getType();//��ȡ��������
				switch(type) {
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			//������ײ�������������һ��Ԫ��
			FlyingObject t=flyings[index];
			flyings[index]=flyings[flyings.length-1];
			flyings[flyings.length-1]=t;
			//���ݣ�ȥ�����һ��Ԫ��
			flyings=Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	public void hitAction() {
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f=flyings[i];
			if(hero.hit(f)) {
				hero.subtractLife();
				hero.clearDoubleFire();
				FlyingObject t=flyings[i];
				flyings[i]=flyings[flyings.length-1];
				flyings[flyings.length-1]=t;
				flyings=Arrays.copyOf(flyings, flyings.length-1);
			}
		}
	}
	public void checkGameOverAction() {
		if(hero.getLife()<=0) {//��Ϸ����
			state=GAME_OVER;
		}
	}
	//���������ִ��
	public void action() {
		//�������������
		MouseAdapter l=new MouseAdapter() {
			//��дmouseMoved����ƶ��¼�
		public void mouseMoved(MouseEvent e) {
			if(state==RUNNING) {
				int x=e.getX();//��ȡ���x����
				int y=e.getY();
				hero.moveTo(x, y);//Ӣ�ۻ�����������ƶ�
				}	
			}
		//��дmouseClicked������¼�
		public void mouseClicked(MouseEvent e) {
			switch(state) {
			case START:
				state=RUNNING;
				break;
			case GAME_OVER:
				score=0;//����
				hero=new Hero();
				flyings=new FlyingObject[0];
				bullets=new Bullet[0];
				state=START;//�޸�Ϊ����
				break;
			}
		}
		//��д����Ƴ��¼�
		public void mouseExited(MouseEvent e) {
			if(state==RUNNING) {
				state=PAUSE;
			}
		}
		//��д��������¼�
		public void mouseEntered(MouseEvent e) {
			if(state==PAUSE) {
				state=RUNNING;
			}
		}
	};
		this.addMouseListener(l);//����������¼�
		this.addMouseMotionListener(l);//������껬���¼�
		
		Timer timer=new Timer();
		int intervel=10;//ʱ����
		timer.schedule(new TimerTask() {
			public void run() {//��ʱ�ɵ���
				if(state==RUNNING) {
					enterAction();//�����볡
					stepAction();//�����ж�
					shootAction();//�ӵ�����
					outOfBoundsAction();//ɾ��Խ�������
					collisionAction();//�ӵ��������ײ
					hitAction();//Ӣ�ۻ��������ײ
					checkGameOverAction();
				}
				repaint();//�ػ�
			}
		}, intervel,intervel);
	}
	//��дpaint()��gΪ����
	public void paint(Graphics g) {
		g.drawImage(background,0,0,null);
		paintHero(g);
		paintFlyingObjects(g);
		paintBullets(g);
		paintScoreAndLife(g);
		paintState(g);
	}
	public void paintHero(Graphics g) {
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	public void paintFlyingObjects(Graphics g) {
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f=flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	public void paintBullets(Graphics g) {
		for(int i=0;i<bullets.length;i++) {
			FlyingObject b=bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
	}
	public void paintScoreAndLife(Graphics g) {//��score��life
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE:"+hero.getLife(), 10, 45);
	}
	public void paintState(Graphics g) {//��״̬
		switch(state) {//���ݵ�ǰ״̬�Ĳ�ͬ����ͬ��ͼ
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
			
		}
	}
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly");//������ܶ���
		ShootGameTest game=new ShootGameTest();//����������
		frame.add(game);//�������ӵ����
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);//���ô�����������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲر�
		frame.setLocationRelativeTo(null);//���þ�����ʾ
		frame.setVisible(true);//���ô��ڿɼ�������paint()����
		
		game.action();//���������ִ��

	}

}
