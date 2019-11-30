package lx;

import java.util.stream.LongStream;

public class Lambda_Accumulater {

	public long total = 0;
	
	public void add(long value) {
		total += value;
	}
	public static long sideEffectSum(long n) {
		Lambda_Accumulater accumulater = new Lambda_Accumulater();
		LongStream.rangeClosed(1, n).forEach(accumulater::add);
		return accumulater.total;
	}
	
	public static long sideEffectParallelSum(long n) {
		Lambda_Accumulater accumulater = new Lambda_Accumulater();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulater::add);
		return accumulater.total;
	}

}
