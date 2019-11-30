package lx;

//责任链模式
public abstract class ProcessingObject<T> {

	protected ProcessingObject<T> successor; //以便往下继续执行，嵌套另外一个successor
	
	public void setSuccessor(ProcessingObject<T> successor) {
		this.successor = successor;
	}
	 
	public T handle(T input) {
		T t = handleWork(input);//第一层先执行
		if(successor != null) {//如果有第二层级的话，继续递归执行
			return successor.handle(t);
		}
		return t;
	}
	
	public abstract T handleWork(T input);//抽象方法，供继承类实现
}
