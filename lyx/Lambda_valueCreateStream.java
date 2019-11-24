package lyx;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lambda_valueCreateStream {

	public static void main(String[] args) {
		//值创造流
		Stream<String> stream = Stream.of("lianlong","zxx","lyx");
		stream.map(String::toUpperCase).forEach(System.out::println);
		
		//数组创造流
		int[] numbers = new int[] {1, 2, 3, 4, 5, 6};
		int result = Arrays.stream(numbers).sum();
		System.out.println(result);
		
//		//文件生成流
//		long uniqueWords = 0;
//		try(Stream<String> lines = 
//				Files.lines(Paths.get("/Users/lianlong/Documents/data.rtf"), Charset.defaultCharset())){
//			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
//					.distinct()
//					.count();
//		}catch(IOException e) {
//			System.out.println(e);
//		}
//		System.out.println(uniqueWords);
		
		//由函数生成流，创建无限流
		Stream.iterate(0, n -> n + 2)
			.limit(10)
			.forEach(System.out::print);
	}
}
