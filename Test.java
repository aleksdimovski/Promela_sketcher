
import java.util.*; 

public class Test {

public static void main(final String[] array) {

	System.out.println("Hello");
	String regExp = "c\\[3\\] = (\\d+)"; 
	String stm = "c[3] = 123"; 
	System.out.println(stm+" matches "+regExp+" is "+stm.matches(regExp));
}


}