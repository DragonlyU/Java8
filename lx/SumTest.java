package lx;

import java.util.function.Function;

public class SumTest {

	public static long measuresSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for(int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1000000;
			System.out.println("Result : " + sum);
			if(duration < fastest) fastest = duration;
		}
		return fastest;
	}
	
	public static void main(String[] args) {
//		System.out.println("顺序执行求和所需 ： " + measuresSumPerf(ParallelOptional::sequentialSum, 10000000) + "毫秒");
//		System.out.println("遍历执行求和所需 ： " + measuresSumPerf(ParallelOptional::iterativeSum, 10000000) + "毫秒");
//		System.out.println("并行执行求和所需 ： " + measuresSumPerf(ParallelOptional::parallelSum, 10000000) + "毫秒");
		System.out.println("顺序执行求和所需 ： " + measuresSumPerf(Lambda_Accumulater::sideEffectSum, 10000000) + "毫秒");
		System.out.println("并行执行求和所需 ： " + measuresSumPerf(Lambda_Accumulater::sideEffectParallelSum, 10000000) + "毫秒");
		System.out.println("Fork/Join执行求和所需 ： " + measuresSumPerf(ForkJoinSumCalculator::forkJoinSum, 10000000) + "毫秒");
	}
}
