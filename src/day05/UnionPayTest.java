package day05;

public class UnionPayTest {

	public static void main(String[] args) {
	//	ABCATM  atm=new ABCATM();//ATM对象
	//	UnionPay card=new ABCImpl();//农行卡
		ICBCATM atm1=new ICBCATM();
		UnionPay card1=new ICBCImpl();
		atm1.insetCard(card1);
	//	atm.insetCard(card);//插卡
		System.out.println("插卡成功");
	//	atm.PayPhoneBill();
		atm1.PayOnline();
	}

}
class ABCATM{//农行ATM
	private UnionPay card;//银联卡
	public void insetCard(UnionPay card) {//插卡
		this.card=card;
	}
	public void PayPhoneBill() {//支付话费按钮
		if(card instanceof ABC) {//是农行卡
			ABC abcCard=(ABC)card;//强转为农行类型
			abcCard.PayPhoneBill("12345", 50);
			
		}else {
			System.out.println("不是农行卡，不能支付话费");
			
		}
	}
}
class ICBCATM{
	private UnionPay card;
	public void insetCard(UnionPay card) {
		this.card=card;
	}
	public void PayOnline() {
		if(card instanceof ICBC) {
			ICBC ICBCCard=(ICBC)card;
			ICBCCard.PayOnline(50);
		}else {
			System.out.println("不是工行卡，不能在线支付");
		}
	}
}
interface UnionPay{//银联接口
	public double getBalance();//查询余额
	public boolean drawMoney(double number);//取钱
	public boolean checkPassword(String input);//验证密码
}
interface ICBC extends UnionPay{//工行接口
	public void  PayOnline(double money);
}
interface ABC extends UnionPay{//农行接口
	public boolean PayPhoneBill(String phoneNum,double sum);
	
}
class ICBCImpl implements ICBC{//工行卡
	public double getBalance() {return 0.0;}
	public boolean drawMoney(double number) {return true;}
	public boolean checkPassword(String input) {return true;}
	public void PayOnline(double money) {
		System.out.println("在线支付成功");
	} 
}
class ABCImpl implements ABC{//农行卡
	public double getBalance() {return 0.0;}
	public boolean drawMoney(double number) {return true;}
	public boolean checkPassword(String input) {return true;}
	public boolean PayPhoneBill(String phoneNum,double sum) {
		System.out.println("支付成功");
		return true;}
}
