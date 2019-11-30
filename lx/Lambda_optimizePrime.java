package lx;

import java.util.List;
import java.util.function.Predicate;

public class Lambda_optimizePrime {

	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p){
		int i = 0;
		for(A item : list) {
			if(!p.test(item))
				return list.subList(0, i);
			i++;
		}
		return list;
	}
	
	public static boolean isPrime(List<Integer> prime, int candidate) {
		int candidateRoot = (int)Math.sqrt((double)candidate);
		return takeWhile(prime, i-> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
	}
}
