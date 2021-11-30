package java_que;

public class pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pat3();
	}
	public static void pat1() {
		/*
		1
		12
		123
		1234
		12345*/
		for (int x=1;x<=5;x++) {
			
			for(int j=1;j<=x;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
		public static void pat2() {
			/*
			#
			##
			###
			####
			#####
			*/
			for (int x=1;x<=5;x++) {
				
				for(int j=1;j<=x;j++) {
					System.out.print("# ");
				}
				System.out.println();
			}
	}
		public static void pat3() {
			/*
			     #
			    ##
			   ###
			  ####
			 ##### 
			*/
			for(int z=1;z<=5;z++) {
				for(int y=5-z;y>0;y--) {
					System.out.print(".");
				}
				for(int x=z;x>0;x--) {
					System.out.print("#");
				}
				System.out.println("");
			}
			
	}

}
