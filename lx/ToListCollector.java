package lx;

import static java.util.stream.Collector.Characteristics.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	//建立新的结果容器
	@Override
	public Supplier<List<T>> supplier() {
		
//		return () -> new ArrayList<T>();
		return ArrayList::new; //构造函数引用
	}
	//将元素添加到结果容器
	@Override
	public BiConsumer<List<T>, T> accumulator() {
	 
//		return (list, item) -> list.add(item);
		return List::add; //方法引用
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
	}

}
