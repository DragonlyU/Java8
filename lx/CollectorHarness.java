package lx;

import java.util.function.Function;

public class CollectorHarness {

	public static void main(String[] args) {
		long fastest = Long.MAX_VALUE;
		for(int i = 0; i < 10; i++) {
			long start = System.nanoTime();
//			Lambda_prime.partitionPrimes(1000000);
			PrimeNumbersCollectors.partitionPrimesWithCustomCollector(1000000);
			long duration = (System.nanoTime() - start) / 1000000;
			if(duration < fastest)
				fastest = duration;
		}
		System.out.println("最快的执行时间 :" + fastest + "毫秒");
		
	}
}
