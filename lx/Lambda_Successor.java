package lx;

public class Lambda_Successor {

	public static void main(String[] args) {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckProcessing();
		p1.setSuccessor(p2);
		String result = p1.handle("Aren't labdas really sexy?!!");
		System.out.println(result);
	}
	
	
}
class HeaderTextProcessing extends ProcessingObject<String>{

	@Override
	public String handleWork(String input) {
		return "From Raoul, Mario and Alan: " + input;
	}
}
class SpellCheckProcessing extends ProcessingObject<String>{

	@Override
	public String handleWork(String input) {
		return input.replaceAll("labdas", "lambda");
	}
	
}
