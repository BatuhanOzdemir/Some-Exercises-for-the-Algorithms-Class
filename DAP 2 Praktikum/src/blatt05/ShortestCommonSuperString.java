package blatt05;

import java.util.Random;
import java.util.ArrayList;

public class ShortestCommonSuperString {
	
	public static String generateRandomString() {
		String alphabet = "ABCD";
		Random numberGenerator = new java.util.Random();
		StringBuilder builder = new StringBuilder();
		int length = 3+numberGenerator.nextInt(4);
		while(length-- > 0) {
			int randomIdx = numberGenerator.nextInt(alphabet.length());
			builder.append(alphabet.charAt(randomIdx));
		}
		return builder.toString();
	}
	
	public static String subString(String a , int start, int end) {
		StringBuilder sub = new StringBuilder();
		if(end <= a.length()) {
			char[] ch = new char[a.length()];
			ch = a.toCharArray();
			for(int i = start; i < end; i++) {
				sub.append(ch[i]);
			}
		}
		return sub.toString();
	}
	
	public static int stringOverlap(String a,String b) {
	int m = a.length();
	int n = b.length();
	int max = 0;
	for(int i = 0; i < Math.min(m, n);i++) {
		if(subString(a,m-i,m).equals(subString(b,0,i)) ) {
			max = i;
		}
	}
	return max;
	}
	
	public static String superString(String a, String b, int max) {
		return a+subString(b,max,b.length());
	}

	public static void main(String[]args) {
		int num = 0;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			num = Integer.parseInt(args[0]);
			while(num-- > 0) {
				list.add(generateRandomString());
			}
		}catch(NumberFormatException e) {
		      for(int i = 0; i < args.length;i++) {
		    	  list.add(args[i].toUpperCase());
		      }
		}
		boolean loop = true;
		while( loop ) {
			int max = 0;
			String a = "",b = "",sup = "";
			for(int i = 0; i < list.size();i++) {
				for(int j = 0; j < list.size();j++) {
					if(stringOverlap(list.get(i),list.get(j)) > max && i != j) {
						max = stringOverlap(list.get(i),list.get(j));
						a = list.get(i);
						b = list.get(j);
					}
				}
			}
			
			if( !(a.equals("")&& b.equals("")&& sup.equals("")) ) {
				
			sup = superString(a,b,max);
			for(int i = 0; i < list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
	   System.out.println("\nErsetze "+a+" und "+b+" durch "+sup);
			list.remove(a);
			list.remove(b);
			list.add(sup);
			
			}else {
				loop = false;
			}
			
			}// end main while loop
		
      for(int i = 0; i < list.size();i++) {
    	  System.out.print(list.get(i)+" ");
      }
      
      int length = 0;
      int index = 0;
      for(int i  = 0; i < list.size();i++) {
    	  if(length < list.get(i).length()) {
    		  length = list.get(i).length();
    		  index = i;
    	  }
      }
      System.out.println("\nSuperstring "+list.get(index)+" mit laenge "+length+" gefunden.");
      
	}// end main
}// end class
