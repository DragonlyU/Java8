package lyx;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;
import java.util.Set;;

public class Lambda_transation {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge"); 
		Trader mario = new Trader("Mario","Milan"); 
		Trader alan = new Trader("Alan","Cambridge"); 
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950)
				);
		
		//找出2011年发生的交易，并按升序排序
		List<Transaction> tr2011 = transactions.parallelStream()
												.filter(d -> d.getYear() == 2011)
												.sorted(comparing(Transaction::getValue))//按照交易额升序排序
												.collect(toList());
		System.out.println(tr2011);
		//交易员在那些不同的城市工作过
		Set<String> cities = transactions.stream()
									.map(transaction -> transaction.getTrader().getCity())//映射将单独的交易映射到具体的所在城市
//									.distinct()//选择不同的城市
//									.collect(toList());
									.collect(toSet());//toSet与toList+distinct效果一致
		System.out.println(cities);
		
		//查找所有来自剑桥的交易员，并按照字母排序
		List<String> traderList = transactions.stream()
											.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
											.map(transaction -> transaction.getTrader().getName())
											.distinct()
											.sorted()
											.collect(toList());
		System.out.println(traderList);
		//更优的写法
		List<Trader> result = transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(comparing(Trader::getName))
				.collect(toList());
		
		System.out.println(result);
		
		//返回所有交易员姓名字符串，按照字母顺序排序
		List<String> nameString = transactions.stream()
											.map(transaction -> transaction.getTrader().getName())
											.distinct()
											.sorted()
											.collect(toList());
		System.out.println(nameString);
		//所有交易员拼接成一个字符串
		String name = transactions.parallelStream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
//				.reduce("", (a, b) -> a + b);
				.collect(joining());//更高效，其内部使用了stringBuild
		System.out.println(name);
		//有没有交易员是在米兰进行的
		boolean isHave = transactions.stream()
				.map(t -> t.getTrader())
				.anyMatch(trader -> trader.getCity().equals("Milan"));
		System.out.println(isHave);
		//打印生活在剑桥的交易员的所有交易额
		int sum = transactions.stream()
							.filter(t -> t.getTrader().getCity().equals("Cambridge"))
							.map(Transaction::getValue)
							.reduce(0,(a ,b) -> a + b);
		System.out.println(sum);
		transactions.parallelStream()
		.filter(t -> t.getTrader().getCity().equals("Cambridge"))
		.map(Transaction::getValue)
		.forEach(System.out::println);
		
		//所有的交易中，最高的交易额
		transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::max)
				.ifPresent(i -> System.out.println("最高交易额" + i));
		//找到交易额最小的交易
		transactions.parallelStream()
		.map(t -> t.getValue())
		.reduce(Integer::min)
		.ifPresent(i -> System.out.println("最下交易额" + i));
		
		transactions.parallelStream()
		.map(Transaction::getValue)
		.min((a , b) -> a - b)
		.ifPresent(i -> System.out.println(i));
	}
	
}
