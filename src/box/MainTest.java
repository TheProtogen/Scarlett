package box;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainTest {

	
	
	public static void main(String[] args) {
		Stack<String> S1 = new Stack<>();
		
		Queue<String> fila = new LinkedList<>();
	
		S1.add("A");
		S1.add("B");
		S1.add("C");
		
		fila.add("A");
		fila.add("B");
		fila.add("C");
		
		Stack<String> S2 = new Stack<>();
		Queue<String> fila1 = new LinkedList<>();
		
		for(int i = 1; i <= 3; i++) {
			S2.push(fila.remove());
			
		}
		System.out.println(S2);
	}
}
