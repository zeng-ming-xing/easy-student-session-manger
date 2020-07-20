package com.student.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.student.util.DbConnect;
import com.student.vo.Student;



public class StudentDao implements IstudentDao{
	protected static final String FIELDS_INSERT = "id,name,sex,age,weight,hight";
	// protected static final String FIELDS_RETURN ="id, " + FIELDS_INSERT;
	protected static String INSERT_SQL = "insert into stu_info (" + FIELDS_INSERT + ")" + "values (?,?,?,?,?,?)";
	protected static String SELECT_SQL = "select " + FIELDS_INSERT + " from stu_info where id=?";
	protected static String UPDATE_SQL = "update stu_info set id=?,name=?,sex=?,age=?,weight=?,hight=? where id=?";
	protected static String DELETE_SQL = "delete from stu_info where id=?";
	
	

	@Override
	public int add(Student stu) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		int n = 0;
		try {
			con = DbConnect.getDBconnection();
			prepStmt = con.prepareStatement(INSERT_SQL);
			prepStmt.setInt(1,stu.getId());
			prepStmt.setString(2, stu.getName());
			prepStmt.setString(3, stu.getSex());
			prepStmt.setInt(4, stu.getAge());
			prepStmt.setFloat(5, stu.getWeight());
			prepStmt.setFloat(6, stu.getHight());
			n = prepStmt.executeUpdate();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			DbConnect.closeDB(con, prepStmt, rs);
		}
		return n;
	}


	@Override
	public List<Student> findall() {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		con = DbConnect.getDBconnection();
		try {
			prepStmt = con.prepareStatement("select * from stu_info");
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Student stu2 = new Student();
				stu2.setId(rs.getInt(1));
				stu2.setName(rs.getString(2));
				stu2.setSex(rs.getString(3));
				stu2.setAge(rs.getInt(4));
				stu2.setWeight(rs.getFloat(5));
				stu2.setHight(rs.getFloat(6));
				list.add(stu2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DbConnect.closeDB(con, prepStmt, rs);
		return list;
	}
	
	public int deleted(int id)
	{
		Connection con = null;
		Statement prepStmt = null;
		int rs=0 ;
		con = DbConnect.getDBconnection();
		try {
			prepStmt = con.createStatement();
			rs=prepStmt.executeUpdate("delete from stu_info where id="+id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	return rs;
	        
	}
	public List<Student>  find(int id) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		con = DbConnect.getDBconnection();
		try {
			prepStmt = con.prepareStatement(SELECT_SQL);
			prepStmt.setInt(1, id);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Student stu2 = new Student();
				stu2.setId(rs.getInt(1));
				stu2.setName(rs.getString(2));
				stu2.setSex(rs.getString(3));
				stu2.setAge(rs.getInt(4));
				stu2.setWeight(rs.getFloat(5));
				stu2.setHight(rs.getFloat(6));
				list.add(stu2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DbConnect.closeDB(con, prepStmt, rs);
		return list;
	}
   public int  update(Student stu) {
	   Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		int n = 0;
		try {
			con = DbConnect.getDBconnection();
			prepStmt = con.prepareStatement(UPDATE_SQL);
			prepStmt.setInt(1,stu.getId());
			prepStmt.setString(2, stu.getName());
			prepStmt.setString(3, stu.getSex());
			prepStmt.setInt(4, stu.getAge());
			prepStmt.setFloat(5, stu.getWeight());
			prepStmt.setFloat(6, stu.getHight());
			prepStmt.setInt(7,stu.getId());
			n = prepStmt.executeUpdate();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			DbConnect.closeDB(con, prepStmt, rs);
		}
		return n;
	
}
}
