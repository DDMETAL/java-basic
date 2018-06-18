package ShootGame;

public class Bullet extends FlyingObject {
	private int speed=3;
	public Bullet(int x,int y) {
		image=ShootGameTest.bullet;
		width=image.getWidth();
		height=image.getHeight();
		this.x=x;
		this.y=y;

	}
	public void step() {
		y-=speed;
	}
	public boolean outOfBounds() {
		return this.y<=-this.height;//y坐标小于等于负的子弹的高
	}
}
