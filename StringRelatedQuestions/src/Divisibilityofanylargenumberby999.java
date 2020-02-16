
public class Divisibilityofanylargenumberby999 {
	
	private static int divisor = 1;
	
	public static boolean isDivisible(String num, int div)
	{
		divisor = div;
		String s = "1";
		int t1 =1 ;
		for (int i = 0; i < 10; i++) {
			s = s + "0";
			System.out.println("s:" +s);
			t1 = Integer.parseInt(s);
			if(t1>divisor)
				break;
		}
		int divibleBy = t1;
		int multiplier = t1 -  divisor;
		System.out.println("num:" + num);
		long mult1 = Long.parseLong(num);
		long mult = mult1 / divibleBy;
		mult +=1;
		System.out.println("divibleBy:" + divibleBy + ", multiplier:" + multiplier + ", mult:" +  mult);
		if((mult * 1000) - (multiplier*mult) == mult1)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		
		System.out.println(isDivisible("235764",999));

		System.out.println(isDivisible("23576",999));
		
	}

}
