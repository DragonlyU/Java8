package lyx;

public class Lyx_test1 {

	public static void  process(Runnable r) {
		r.run();
	}
	
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("hello lyx");
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hello lyx love lianlong");
			}
		};
		
		process(r1);
		process(r2);
		process(() -> System.out.println("hello wxd"));
	}
}
