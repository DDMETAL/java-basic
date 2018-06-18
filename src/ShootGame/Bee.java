package ShootGame;

import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private int xSpeed=1;
	private int ySpeed=2;
	private int awardType;
	public Bee() {
		image=ShootGameTest.bee;
		width=image.getWidth();
		height=image.getHeight();
		
	}
	public int getType() {
		return awardType;
	}
	public void step() {
		x+=xSpeed;
		y+=ySpeed;
		if(x>=ShootGameTest.WIDTH-this.width) {
			xSpeed=-1;
		}
		if(x<=0) {
			xSpeed=+1;
		}
	}
	public boolean outOfBounds() {
		return this.y>=ShootGameTest.HEIGHT;
	}
}
