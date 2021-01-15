package cn.xing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xing.po.Student;
import cn.xing.po.Teacher;
import cn.xing.util.DBUtil;

public class TeacherDao  implements ITeacherDao{
	private DBUtil db = new DBUtil();
	@Override
	public List<Map<String, Object>> findAllTeacherInfo() {
		String sql="select * from teacher";
		List<Map<String, Object>> teachers=null;
		try {
			teachers= db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}

	@Override
	public void addTeacher(Teacher s) {
		String sql="insert into teacher values("+s.getId()+",'"+s.getName()+"','"+ s.getPwd()+"','"+ s.getDeptName()+"')";
		System.out.println(sql);
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		String sql="UPDATE `teacher` SET `name`=?,`pwd`=?,`deptName`=? WHERE id=?";
		try {
			db.execute(sql, new Object[]{teacher.getName(),teacher.getPwd(),teacher.getDeptName(),teacher.getId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		String sql="select * from teacher where id=?";
		Map<String, Object> student=new HashMap<>();
		try {
			 student=db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> findTeacherByName(String name) {
		StringBuilder sql=new StringBuilder("select * from teacher where 1=1");
		if(name!=null&&!"".equals(name.trim())){
			sql.append(" and  name like '%"+name +"%'");
		}
		System.out.println(sql.toString());
		System.out.println(Teacher.class);
		List<Teacher> teachers=new ArrayList<Teacher>();
		try {
			teachers= (List)db.getQueryList(Teacher.class, sql.toString(), new Object[]{});
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}


}
