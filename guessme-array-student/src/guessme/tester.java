package guessme;

public class tester {
	public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
		// TODO
		int match=0;
		int i=0;
		int first,second;
		
		while(i<4) {
			first=a%10;
			a=a/10;
			second=b%10;
			b=b/10;
			if(first==second) {	match++;}
			i++;
		}
		return match;
	}
	public static void main(String[] args) {
		int guess=3222;
		int nmatches=3;
		
		boolean flag[] = new boolean[9000];
		for(int i=0;i<flag.length;i++) {
			flag[i]=true;
			}
		
		if(nmatches==0) {
	         for(int i=0;i<flag.length;i++) {
			    if(numMatches(guess,i+1000)>0) {
				  flag[i]=false;
			    }
		        }
		  guess=guess+1111;
		  System.out.println(guess);
		  
		
		  }
		else {
			
			for(int i=0;i<flag.length;i++) {
				if(numMatches(guess,i+1000)>nmatches) {
					flag[i]=false;
				  }
				}
				for(int p=0;p<flag.length;p++) {
					if(flag[p]==true) {
						guess=p+1000;
						System.out.println(guess);
						break;

						
					
					}
				}
		}
		
}
		
    
	
}
