package beginner_2_1.NM300.nm002.최대공약수와_최소공배수;

public class test2 {

	public static void main(String[] args) {
		int a=1;
		int b=1;
		int c = 0;
		
		for(int i=a*b; i!=0; i--) {
			
			if(i%a==0 && i%b==0) {
				c=i;
			}
		}
		
		

	}

}
