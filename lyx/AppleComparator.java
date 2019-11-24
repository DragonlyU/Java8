package lyx;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple>{

	@Override
	public int compare(Apple o1, Apple o2) {
		// TODO Auto-generated method stub
//		return o1.getWeight().compareTo(o2.getWeight());
		return o1.getColor().compareTo(o2.getColor());
	}

}
