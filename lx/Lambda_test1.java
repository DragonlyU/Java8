package lx;

public class Lambda_test1 {

	public static void doSomething(Runnable r) {
		r.run();
	}
	public static void doSomething(Task t) {
		t.execute();
	}
	
	public static void main(String[] args) {
		doSomething((Task)() -> System.out.println("lyx love lianlong"));
	}
}

interface Task{
	public void execute();
}