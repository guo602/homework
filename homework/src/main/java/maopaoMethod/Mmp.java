package maopaoMethod;

public class Mmp {

	public static String moneyToString(int money) {
		
		String result;
		double d=money;
		double w=(Math.log(d)/Math.log(10)+1);
		long weishu=(long)w;
		
		if(weishu<=2) {
		
			result="0.";
			if(weishu<=1)result+="0";
			while(money>=10) {
				
				result+=oneToString(money/10);
				money=money%10;
			}
			
			result+=oneToString(money);
			return result;
		}
		
		
		else {
			result=Integer.toString(money/100,10);
			result+=".";
			if(money%100==0)result+="00";
			else if(money%100<10) {
				result+="0";
				result+=Integer.toString(money%100,10);
			}
			else result+=Integer.toString(money%100,10);
		return result;
		}
	}
	
	public static String oneToString(int y) {
		
		switch(y) {
		case(1): return "1";
		case(2): return "2";
		case(3): return "3";	
		case(4): return "4";
		case(5): return "5";
		case(6): return "6";
		case(7): return "7";
		case(8): return "8";
		case(9): return "9";
		case(0): return "0";
		default:return "";
		
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println(moneyToString(8490));
	}
	
}
