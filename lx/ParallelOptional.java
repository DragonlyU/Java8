package lx;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelOptional {

	public static long sequentialSum(long n) {
//		return Stream.iterate(1l, i -> i + 1).limit(n).reduce(0l, Long::sum);
		return LongStream.rangeClosed(1, n).reduce(0l, Long::sum);
	}
	
	public static long iterativeSum(long n) {
		long result = 0;
		for(long i = 1l; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	public static long parallelSum(long n) {
//		return Stream.iterate(1l, i -> i + 1).limit(n).parallel().reduce(0l, Long::sum);
		return LongStream.rangeClosed(1, n).parallel().reduce(0l, Long::sum);
	}
}
