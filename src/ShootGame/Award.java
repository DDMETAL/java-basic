package ShootGame;
/**奖励*/
public interface Award {
	public int DOUBLE_FIRE=0;//火力值
	public int LIFE=1;//生命
	//获取奖励类型（上边的0或1）
	public int getType();
}
