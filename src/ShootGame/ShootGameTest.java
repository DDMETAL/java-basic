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
//主窗口类
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
	public static final int START=0;//启动
	public static final int RUNNING=1;//运行
	public static final int PAUSE=2;//暂停
	public static final int GAME_OVER=3;//结束
	private int state=START;//当前状态
	//生成敌人对象
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
	//airplane+bee入场
	public void enterAction() {//10毫秒执行一次
		
		flyIndex++;
		if(flyIndex%40==0) {
			FlyingObject obj=nextOne();
			flyings=Arrays.copyOf(flyings, flyings.length+1);//扩容
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
		for(int i=0;i<flyings.length;i++) {//遍历所有敌人
			FlyingObject f=flyings[i];//获取每一个敌人
			if(!f.outOfBounds()) {//敌人不越界
				flyingLives[index]=f;//将不越界的敌人存入数组
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
	//所有子弹与所有敌人的碰撞
	public void collisionAction() {
		for(int i=0;i<bullets.length;i++) {
			Bullet b=bullets[i];
			collision(b);
		}
	}
	int score=0;
	//一个子弹与所有敌人碰撞
	public void collision(Bullet b) {
		int index=-1;
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f=flyings[i];
			if(f.shootBy(b)) {
				index=i;//记录被撞敌人下标
				break;//其余敌人不再参与比较
			}
		}
		if(index!=-1) {
			FlyingObject one=flyings[index];//被撞敌人
			if(one instanceof Enemy) {//若是敌人
				Enemy e=(Enemy)one;//强转为敌人
				score+=e.getScore();//玩家的分	
			}
			if(one instanceof Award) {
				Award a=(Award)one;
				int type=a.getType();//获取奖励类型
				switch(type) {
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			//交换被撞敌人与数组最后一个元素
			FlyingObject t=flyings[index];
			flyings[index]=flyings[flyings.length-1];
			flyings[flyings.length-1]=t;
			//缩容，去掉最后一个元素
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
		if(hero.getLife()<=0) {//游戏结束
			state=GAME_OVER;
		}
	}
	//启动程序的执行
	public void action() {
		//创建鼠标侦听器
		MouseAdapter l=new MouseAdapter() {
			//重写mouseMoved鼠标移动事件
		public void mouseMoved(MouseEvent e) {
			if(state==RUNNING) {
				int x=e.getX();//获取鼠标x坐标
				int y=e.getY();
				hero.moveTo(x, y);//英雄机随鼠标坐标移动
				}	
			}
		//重写mouseClicked鼠标点击事件
		public void mouseClicked(MouseEvent e) {
			switch(state) {
			case START:
				state=RUNNING;
				break;
			case GAME_OVER:
				score=0;//清零
				hero=new Hero();
				flyings=new FlyingObject[0];
				bullets=new Bullet[0];
				state=START;//修改为启动
				break;
			}
		}
		//重写鼠标移出事件
		public void mouseExited(MouseEvent e) {
			if(state==RUNNING) {
				state=PAUSE;
			}
		}
		//重写鼠标移入事件
		public void mouseEntered(MouseEvent e) {
			if(state==PAUSE) {
				state=RUNNING;
			}
		}
	};
		this.addMouseListener(l);//处理鼠标点击事件
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		
		Timer timer=new Timer();
		int intervel=10;//时间间隔
		timer.schedule(new TimerTask() {
			public void run() {//定时干的事
				if(state==RUNNING) {
					enterAction();//敌人入场
					stepAction();//敌人行动
					shootAction();//子弹发射
					outOfBoundsAction();//删除越界飞行物
					collisionAction();//子弹与敌人碰撞
					hitAction();//英雄机与敌人碰撞
					checkGameOverAction();
				}
				repaint();//重画
			}
		}, intervel,intervel);
	}
	//重写paint()；g为画笔
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
	public void paintScoreAndLife(Graphics g) {//画score和life
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE:"+hero.getLife(), 10, 45);
	}
	public void paintState(Graphics g) {//画状态
		switch(state) {//根据当前状态的不同画不同的图
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
		JFrame frame=new JFrame("Fly");//创建框架对象
		ShootGameTest game=new ShootGameTest();//创建面板对象
		frame.add(game);//将面板添加到框架
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);//设置窗口总在最上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭
		frame.setLocationRelativeTo(null);//设置居中显示
		frame.setVisible(true);//设置窗口可见，调用paint()方法
		
		game.action();//启动程序的执行

	}

}
