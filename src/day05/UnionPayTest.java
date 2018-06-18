package day05;

public class UnionPayTest {

	public static void main(String[] args) {
	//	ABCATM  atm=new ABCATM();//ATM����
	//	UnionPay card=new ABCImpl();//ũ�п�
		ICBCATM atm1=new ICBCATM();
		UnionPay card1=new ICBCImpl();
		atm1.insetCard(card1);
	//	atm.insetCard(card);//�忨
		System.out.println("�忨�ɹ�");
	//	atm.PayPhoneBill();
		atm1.PayOnline();
	}

}
class ABCATM{//ũ��ATM
	private UnionPay card;//������
	public void insetCard(UnionPay card) {//�忨
		this.card=card;
	}
	public void PayPhoneBill() {//֧�����Ѱ�ť
		if(card instanceof ABC) {//��ũ�п�
			ABC abcCard=(ABC)card;//ǿתΪũ������
			abcCard.PayPhoneBill("12345", 50);
			
		}else {
			System.out.println("����ũ�п�������֧������");
			
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
			System.out.println("���ǹ��п�����������֧��");
		}
	}
}
interface UnionPay{//�����ӿ�
	public double getBalance();//��ѯ���
	public boolean drawMoney(double number);//ȡǮ
	public boolean checkPassword(String input);//��֤����
}
interface ICBC extends UnionPay{//���нӿ�
	public void  PayOnline(double money);
}
interface ABC extends UnionPay{//ũ�нӿ�
	public boolean PayPhoneBill(String phoneNum,double sum);
	
}
class ICBCImpl implements ICBC{//���п�
	public double getBalance() {return 0.0;}
	public boolean drawMoney(double number) {return true;}
	public boolean checkPassword(String input) {return true;}
	public void PayOnline(double money) {
		System.out.println("����֧���ɹ�");
	} 
}
class ABCImpl implements ABC{//ũ�п�
	public double getBalance() {return 0.0;}
	public boolean drawMoney(double number) {return true;}
	public boolean checkPassword(String input) {return true;}
	public boolean PayPhoneBill(String phoneNum,double sum) {
		System.out.println("֧���ɹ�");
		return true;}
}
