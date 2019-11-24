package lyx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lx_test3 {

	
	public void test1() {
		Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(Transaction transaction : transactions) {
			if(transaction.getPrice() > 1000) {
				Currency currency = transaction.getCurrency();
				List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
				if(transactionsForCurrency == null) {
					transactionsForCurrency = new ArrayList<>();
					transactionsByCurrencies.put(currency, transactionsForCurrency);
				}
				transactionsForCurrency.add(transaction);
			}
		}
	}
	
	public void test2() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		//Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream().filter((Transaction t) -> t.getPrice() > 1000).collect();
		
	}
	
}
