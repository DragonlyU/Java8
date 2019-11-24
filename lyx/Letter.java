package lyx;

import java.util.function.DoubleFunction;
import java.util.function.Function;

public class Letter {

	public static String addHeader(String text) {
		return "From Raoul, Mario And Alan :" + text;
	}
	
	public static String addFooter(String text) {
		return text + " Kind Regrads;";
	}
	public static String checkSpelling(String text) {
		return text.replace("labda", "lambda");
	}
	
	public static double integrate(DoubleFunction<Double> f, double a, double b) {
		return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
	}
	public static void main(String[] args) {
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
		String s = transformationPipeline.apply("lianlong love labda");
		System.out.println(s);
		
	}
}
