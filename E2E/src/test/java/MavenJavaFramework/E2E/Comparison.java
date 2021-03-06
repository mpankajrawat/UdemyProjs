package MavenJavaFramework.E2E;

public class Comparison {

	public static int str_Comp(String S1, String S2) {
		int S1_Len = S1.length();
		int S2_Len = S2.length();
		int len_Min = Math.min(S1_Len, S2_Len);
		
		for (int i=0; i<len_Min; i++) {
			int char_at_S1 = (int)S1.charAt(i);
			int char_at_S2 = (int)S2.charAt(i);
			
			if (char_at_S1!=char_at_S2) {
				return char_at_S1 - char_at_S2;
			}
		}
		if (S1_Len != S2_Len) {
			return S1_Len- S2_Len;
		}
		else
			return 0;
	}
	
	public static void main (String[] args) {
		System.out.print(str_Comp("ttring","string"));
	}
}
