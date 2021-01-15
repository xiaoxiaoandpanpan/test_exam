package cn.sdut.xing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
class DD{
	int i=2;
	String string="www";
	
}
class WW{
	int i=1;
	String string=new String("www");
}
public class Main {
	public static void main(String[] args) {
		DD d=new DD();
		WW w=new WW();
		if (d.string==w.string) {
			System.out.println("====");
		}else{
			System.out.println("--------");
		}
		
		/*// TODO Auto-generated method stub
		Date.sum=11;
		System.out.println(Date.sum+"->"+Date.max);
		Integer  i=200;
		Integer  j=200;
		if(i.equals(j)){
			System.out.println("==");
		}else{
			System.out.println("nono");
		}
		String ss="123";
		float d=i.floatValue();
		System.out.println(d);
		double dd=Double.valueOf(ss);
		System.out.println(dd);*/
		/*String str = "abcdefg";
		char d=str.charAt(2);
		System.out.println(d);
		String str1 = "abcd";
		String str2 = "12";
		String str3 = "aB";
		int rel=str2.compareTo(str1);
		System.out.println(rel);
		char[] dst = null;
		str1.getChars(1, 3, dst, 0);
		System.out.println(dst[1]);*/
		
	/*	Map<String, String> stu=new HashMap<>();
		stu.put("1", "nihao");
		stu.put("2", "nihao");
		for(String key : stu.keySet()) {
			System.out.println(key+"->"+stu.get(key));
		}
		for(Map.Entry<String, String> entry : stu.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
		
		Map<String, Studenttttt> stus=new HashMap<>();
		Studenttttt stu1=new Studenttttt();
		stu1.setId(123);
		stu1.setName("luzhenxing");
		Studenttttt stu2=new Studenttttt();
		stu2.setId(456);
		stu2.setName("zhangsan");
		Studenttttt stu3=new Studenttttt();
		stu3.setId(789);
		stu3.setName("lisi");
		
		stus.put("1", stu1);
		stus.put("2", stu2);
		stus.put("3", stu3);
		for (String string : args) {
			
		}
		System.out.println(stus.get("1"));*/
		
		int[] ss= {1,1,3};
		if (ss[0]==ss[1]) {
			System.out.println("========");
		} else {
			System.out.println("nonono");
		}
		int[] tt= new int[2];
		tt[0]=1;
		if (tt[0]==ss[0]) {
			System.out.println("xiangdeng ");
		}
		Integer  d5= new Integer(5);
		Integer d6= new Integer(5);
		if (d5.equals(d6)) {
			System.out.println("OK");
		}
	}

}
