package ShootGame;
import java.awt.image.BufferedImage;
public class Hero extends FlyingObject{
	private int doubleFire;
	private int life;
	private BufferedImage[] images;
	private int index;
	private int level;
	public Hero(){
		this.image=ShootGameTest.hero0;
		this.width=image.getWidth();
		this.height=image.getHeight();
		this.level=1;
		this.x=150;
		this.y=400;
		this.doubleFire=0;
		this.life=3;
		this.images=new BufferedImage[] {ShootGameTest.hero0,ShootGameTest.hero1};
		this.index=0;
	}
	public void step() {
		image=images[index++/10%images.length];
	}
	//英雄机发射子弹	
	public Bullet[] shoot() {
		int xStep =this.width/4;
		int yStep=20;
		if(doubleFire>0) {
			Bullet[] bs=new Bullet[2];
			bs[0]=new Bullet(this.x+1*xStep,this.y-yStep);
			bs[1]=new Bullet(this.x+3*xStep,this.y-yStep);
			doubleFire-=2;
			return bs;
		}else {
			Bullet[] bs=new Bullet[1];
			bs[0]=new Bullet(this.x+2*xStep,this.y-yStep);
			return bs;
		}
		
	}
	//英雄机随鼠标动，x：鼠标x，y：鼠标y
	public void moveTo(int x, int y) {
		this.x=x-this.width/2;//英雄机的x=鼠标x-1/2英雄机的宽
		this.y=y-this.height/2;
	}
	public boolean outOfBounds() {
		return false;
	}
	public void addLife() {
		life++;
	}
	public int getLife() {
		return life;
	}
	public void subtractLife() {
		life--;
	}
	public void addDoubleFire() {
		doubleFire+=40;
	}
	public void clearDoubleFire() {
		doubleFire=0;
	}
	public boolean hit(FlyingObject other) {//英雄机与敌人碰撞
		int x1=other.x-this.width/2;
		int x2=other.x+other.width+this.width/2;
		int y1=other.y-this.height/2;
		int y2=other.y+other.height+this.height/2;
		int x=this.x+this.width/2;
		int y=this.y+this.height/2;
		return x>=x1&&x<=x2&&y>=y1&&y<=y2;
	}
}
