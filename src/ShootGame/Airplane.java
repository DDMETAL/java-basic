package ShootGame;
import java.util.Random;
public class Airplane extends FlyingObject implements Enemy{
	private int speed=2;
	public Airplane(){
		this.image=ShootGameTest.airplane;
		this.width=image.getWidth();
		this.height=image.getHeight();
		Random rand=new Random();
		this.x=rand.nextInt(ShootGameTest.WIDTH-this.width);
		this.y=-this.height;
		
	}
	public int getScore() {
		return 5;
		
	}
	public void step() {
		this.y+=speed;
	}
	public boolean outOfBounds() {
		return this.y>=ShootGameTest.HEIGHT;
		
	}
}
