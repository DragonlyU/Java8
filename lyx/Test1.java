package lyx;

public class Test1 {

	public static void main(String[] args) {
		//System.out.println("lianlong");
		//Converter<String, Integer> converter =  (from) -> Integer.valueOf(from);//标准的Lambda表达式
		//Converter<String, Integer> converter = Integer::valueOf;
		//Integer converted = converter.convert("123");
		//System.out.println(converted.getClass());
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("lian", "long");
		System.out.println(person.firstName);
//		Converter<String, Integer> converter = new Converter<String, Integer>() {
//			
//			@Override
//			public Integer convert(String from) {
//				// TODO Auto-generated method stub
//				return Integer.valueOf(from);
//			}
//		};
		
		final int num = 1;
		Converter<Integer, String> converter = (from) -> String.valueOf(from + num);
		
	}
}
class Something{
	String startWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}
class Person{
	String firstName;
	String lastName;
	Person(){}
	Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
interface PersonFactory<P extends Person>{
	P create(String firstName, String lastName);
}