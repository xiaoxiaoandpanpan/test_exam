package cn.xing.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 测试DButil
 *
 */
public class DBUtilTest {

	public static void main(String[] args) {

		DBUtil db=new DBUtil();
		try{
			List<Map<String,Object>> list = db.getQueryList(" select id,name from stuclass ");
			for (Iterator<Map<String, Object>> iterator = list.iterator(); iterator.hasNext();) {
				Map<String, Object> map = (Map<String, Object>) iterator.next();
				System.out.print(map.get("id")+"     ");
				System.out.println(map.get("name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}


	}

}
