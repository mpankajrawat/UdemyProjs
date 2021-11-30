package method;

import java.util.Arrays;

public class testing extends base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortalpha();
		
		
	}

	public static void overriding() {
		for (int i=1;i<=5; i++ ) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int k= 4; k>0; k--) {
			for(int l = k; l>0;l--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		}
	
	public static void sort() {
		int ar[] = {6,5,1,2,20,60,81,35,101};
		int temp;
		System.out.print(Arrays.toString(ar));
		for(int i=0; i<ar.length-1;i++) {
			for(int j=0;j<ar.length-1;j++) {
				if(ar[j]>ar[j+1]) {
					temp=ar[j+1];
					ar[j+1]=ar[j];
					ar[j]=temp;
				}
			}
		}
		System.out.print(Arrays.toString(ar));
	}
	
	public static void sortalpha() {
		String ar[] = {"pan","at.wert","xyml","her"};
		String temp;
		System.out.print(Arrays.toString(ar));
		for(int i=0;i<ar.length-1;i++) {
			for(int j=0;j<ar.length-1;j++) {
				if(ar[j].compareTo(ar[j+1])>0) {
					temp=ar[j+1];
					ar[j+1] = ar[j];
					ar[j]=temp;
				}
			}
		}
		System.out.print(Arrays.toString(ar));
	}
}
