package functionalinterface;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Main {
	public static void main(String[] args) {
		//consiumer function predicate
		Consumer<String> check = x-> System.out.println("Printing from consumer");
		Predicate<String> checkingStartsWith = x->x.startsWith("A");
		Function<String,String> function = x->x.substring(0,1);
		
		check.accept("hello");
		if(checkingStartsWith.test("Alpha")==true) {
			System.out.println("Yes the word strarts with A");
		}
		
		System.out.println(function.apply("Vishnu"));
	}
}
