package lx;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterSpliterator implements Spliterator<Character>{

	private final String string;
	private int currentChar = 0;
	
	public WordCounterSpliterator(String string) {
		super();
		this.string = string;
	}

	//若存在剩余操作，则执行给定操作
	@Override
	public boolean tryAdvance(Consumer<? super Character> action) {
		action.accept(string.charAt(currentChar++)); //处理当前字符，
		return currentChar < string.length();//如果还有字符要处理，返回true
	}

	@Override
	public Spliterator<Character> trySplit() {
		int currentSize = string.length() - currentChar;
		if(currentSize < 10) {
			return null;
		}
		for(int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
			if(Character.isWhitespace(string.charAt(splitPos))) {
				Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar,splitPos));//String.subStirng(包括，不包括)
				currentChar = splitPos;
				return spliterator;
			}
		}
		return null;
	}

	@Override
	public long estimateSize() {
		return string.length() - currentChar;
	}

	@Override
	public int characteristics() {
		return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
	}
	private static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
									WordCounter::accumulate,
									WordCounter::combine);
		return wordCounter.getCounter();
	}
	
	public static void main(String[] args) {
		final String SENTENCE = " Nel mezzo del cammin di nostra vita " +
				"mi ritrovai in una selva oscura" +
				" ché la dritta via era smarrita ";
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		System.out.println("Found " + countWords(stream) + " words");
	}
}
