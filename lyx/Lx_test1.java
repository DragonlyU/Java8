package lyx;

import java.io.File;
import java.io.FileFilter;



public class Lx_test1 {

	public static void main(String[] args) {
		System.out.println("lianlong");
		
		/*
		 * java �Ϸ���
		 * 
		 * File[] hiddenFiles = new File(".").listFiles(new FileFilter() { //�����ڲ���
		 * 
		 * @Override public boolean accept(File file) { // TODO Auto-generated method
		 * stub return file.isHidden(); } });
		 */
		
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);//��������  ::�﷨����isHiddden��������listFiles������
		
		// ʲô�����ʹ��
		// (MyMathUtils::add1)  �� (int x ) -> x + 1; 
		System.out.println();
	}
	
	
}
class MyMathUtils{
	
	public int add1(int x) {
		return x + 1;
	}
}


