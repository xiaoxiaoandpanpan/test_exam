package cn.xing.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.xing.po.Student;
import cn.xing.po.Teacher;
import cn.xing.util.DBUtil;

public class StudentDao implements IStudentDao {
	DBUtil db=new DBUtil();

	@Override
	public void addStudent(Student s) {
		String sql="insert into student values("+s.getId()+",'"+s.getName()+"','"+ s.getPwd()+"','"+s.getSchool()+"','"+ s.getDeptName()+"','"+ s.getSex()+"','"+ s.getBorn()+"',"+ s.getClassId()+")";
		
		//System.out.println(sql);
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql="update student set name=?,pwd=?,school=?,deptName=?,sex=?,born=?,classId=?  where id=?";
		try {
			db.execute(sql,new Object[]{s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId(),s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

	@Override
	public Student findStudentById(int id) {
		Student student = new Student();
		String sql="select * from student where id=?";
		try {
			student=(Student) db.getObject(Student.class, sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		String sql="SELECT s.id, s.name, pwd, school, deptName, sex, born, sc.name as className FROM student as s,stuclass as sc WHERE s.classid=sc.id";
		List<Map<String, Object>> studentList=null;
		try {
			studentList=db.getQueryList(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public List<Student> studentList(String name) {
		StringBuilder sql=new StringBuilder("SELECT s.id, s.name, pwd, school, deptName, sex, born, sc.name as className FROM student as s,stuclass as sc WHERE s.classid=sc.id");
		if(name!=null&&!"".equals(name.trim())){
			sql.append(" and  s.name like '%"+name +"%'");
		}
		System.out.println(sql.toString());
		System.out.println(Teacher.class);
		List<Student> students=new ArrayList<Student>();
		try {
			students= (List)db.getQueryList(Student.class, sql.toString(), new Object[]{});
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
}
