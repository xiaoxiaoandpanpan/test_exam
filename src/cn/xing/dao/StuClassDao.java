package cn.xing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.xing.po.StuClass;
import cn.xing.util.DBUtil;

public class StuClassDao implements IStuClassDao {

	private DBUtil db=new DBUtil();
	@Override
	public List<Map<String, Object>> findAllStuClassInfo() {
		List<Map<String,Object>> list =null;
		try{
			list = db.getQueryList(" select id,name,depName from stuclass ");
			/*for (Iterator<Map<String, Object>> iterator = list.iterator(); iterator.hasNext();) {
				Map<String, Object> map = (Map<String, Object>) iterator.next();
				System.out.print(map.get("id")+"     ");
				System.out.print(map.get("name")+"  ");
				System.out.println(map.get("depName"));
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		Map<String, Object> result= new HashMap<>();
		try {
			String sql="select * from stuclass where id=?";
			Object[] paramList = new Object[]{classId};
			result=db.getObject(sql, paramList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(result+"findStuClassById");
		return result;
	}

	@Override
	public int addStuClassById(StuClass sc) {
		int result=0;
		try {
			String sql="insert into stuclass values(?,?,?)";
			List<Object> stuClassList = new ArrayList<Object>();
			stuClassList.add(sc.getId());
			stuClassList.add(sc.getName());
			stuClassList.add(sc.getDeptName());
			
			Object[] paramList=(Object[])stuClassList.toArray(new Object[stuClassList.size()]);
			 result=db.execute(sql, paramList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		try {
			String sql="update stuclass set name=?,depName=? where id=? ";
			List<Object> stuClassList = new ArrayList<Object>();
			stuClassList.add(sc.getId());
			stuClassList.add(sc.getName());
			stuClassList.add(sc.getDeptName());
			Object[] paramList=(Object[])stuClassList.toArray(new Object[stuClassList.size()]);
			Object[] paramLists=new Object[]{sc.getName(),sc.getDeptName(),sc.getId()};
			
			int t=db.execute(sql, paramLists);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql="SELECT name from stuclass where id in ("+ids+")";
		List<Map<String , Object>> list =new ArrayList<>();
		try {
			list=db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == list)
			return "";
		StringBuilder classname = new StringBuilder();
		for (Map<String, Object> map : list) {
			classname.append(map.get("name")).append(" ");
		}
		return classname.toString();
	}

	@Override
	public List<String> classNameAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StuClass> findClassByTeacherId(int tId) {
		//SELECT id,name from stuclass where id in ( SELECT classID from teachercourse where teaId =1 )
		String sql="SELECT * from stuclass where id in ( SELECT classID from teachercourse where teaId =? )";
		List<StuClass> stuClasses = new ArrayList<>();
		List stuc= new ArrayList<>();
		try {
			stuc =db.getQueryList(StuClass.class, sql, new Object[]{tId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stuClasses=stuc;
		return stuClasses;
	}

}
