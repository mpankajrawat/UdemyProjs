package MavenJavaFramework.E2E;

import java.util.Arrays;

public class test123 extends test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test12 test = new test12(1,"2");

	}
	
	public static void strRev(){
		String original = "My name is Pankaj";
		String reversed="";
		String[] splited = original.split(" ");
		for(int i=splited.length - 1;i>=0;i--) {
			reversed = reversed+ " " +splited[i];
		}
		System.out.print(reversed);
	}
	
	public static void sortal() {
		String[] ar = {"ewq","sol","des","abs", "sol", "eqw"};
		String temp;
		for (int i=0; i<ar.length - 1; i++) {
			for (int j = 0; j<ar.length - 1;j++) {
				if(ar[j].compareToIgnoreCase(ar[j+1])>0) {
					temp = ar[j+1];
					ar[j+1] = ar[j];
					ar[j] = temp; 
				}
			}
		}
		System.out.println(Arrays.toString(ar));
	}
	
	public static void reverseNum() {
		int num = 150;
		 
				
	}
	
	public static void test11() {
		System.out.print("This is child class");
	}

}
