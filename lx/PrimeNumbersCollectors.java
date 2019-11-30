package lx;

import static java.util.stream.Collector.Characteristics.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class PrimeNumbersCollectors implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>>{
	
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		return () -> new HashMap<Boolean, List<Integer>>(){/**
			 * 
			 */
			private static final long serialVersionUID = -8459354169179484144L;

		{
			put(true, new ArrayList<Integer>());
			put(false, new ArrayList<Integer>());
		}};
	}

	//累加器
	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean,List<Integer>> acc, Integer candidate) ->{
			acc.get(isPrime(acc.get(true), candidate)).add(candidate);
		};
	}
	//规约，并行操作（如果可能），但此例子并不能进行并行操作
	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return (Map<Boolean, List<Integer>> map1,
				Map<Boolean, List<Integer>> map2) ->{
					map1.get(true).addAll(map2.get(true));
					map2.get(false).addAll(map2.get(false));
					return map1;
				};
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
	}
	
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
	
	public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollectors());
	}
	
	public static void main(String[] args) {
		Map<Boolean, List<Integer>> result = partitionPrimesWithCustomCollector(100);
		System.out.println(result.get(true));
	}
}
