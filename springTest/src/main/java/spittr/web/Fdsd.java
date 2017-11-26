package spittr.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
interface A{
	void test();
}
interface B extends A{
	
}
public class Fdsd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put(1, 1);
		map.put(1, 2);
		map.put(2, 1);
		System.out.println(map.get(1));
		Collection c=new ArrayList();
	}

}
