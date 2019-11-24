package lyx;

import java.util.stream.Stream;

public class Fabonacci {

	public static void main(String[] args) {
		//斐波那契元组序列 unary 一元
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] +" ," + t[1] + ")"));
		
		//打印正常的斐波那契数列
		Stream.iterate(new int[] {0 ,1}, t -> new int[] {t[1], t[0] + t[1]})
		.limit(20)
		.map(t -> t[0])
		.forEach(System.out::println);
	}
}
