package MavenJavaFramework.E2E;

public class test12 {

	
	public  test12() {
		System.out.print("This is a constructor");
	}
	public test12(int para) {
		System.out.print("This is overloaded" +para);
	}
	public test12(int para, String param) {
		System.out.print(para+""+param );
	}
	public void test1(){
		System.out.print("This is parent class");
	}
	
	public void test1(int param) {
		System.out.print(param);
	}
	public void test11(int param) {
		System.out.print(param);
	}


}
