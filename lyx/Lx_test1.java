package lyx;

import java.io.File;
import java.io.FileFilter;



public class Lx_test1 {

	public static void main(String[] args) {
		System.out.println("lianlong");
		
		/*
		 * java 老方法
		 * 
		 * File[] hiddenFiles = new File(".").listFiles(new FileFilter() { //匿名内部类
		 * 
		 * @Override public boolean accept(File file) { // TODO Auto-generated method
		 * stub return file.isHidden(); } });
		 */
		
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);//方法引用  ::语法，将isHiddden函数传进listFiles方法中
		
		// 什么情况下使用
		// (MyMathUtils::add1)  与 (int x ) -> x + 1; 
		System.out.println();
	}
	
	
}
class MyMathUtils{
	
	public int add1(int x) {
		return x + 1;
	}
}


