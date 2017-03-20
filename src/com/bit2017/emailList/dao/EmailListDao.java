package com.bit2017.emailList.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2017.emailList.vo.EmailListVo;

public class EmailListDao {
	
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		//1.JDBC Driver Loading (JDBC Class Loading)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패 : " + e);
		}
		
		//2.Connection 얻어오기 (connect to DB)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
	
		return conn;
	}
	public List<EmailListVo> getList(){
		List<EmailListVo> list = new ArrayList<EmailListVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1,2번 위에 함수로 처리
			conn = getConnection();
			
			//3.SQL문 준비
			String sql = "select no, first_name, last_name, email from emailList order by no desc";
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//4.결과처리
			while(rs.next()){
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmailListVo vo = new EmailListVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				list.add(vo);
			}
			//conn.close(); --여기다 쓰면 안됨
		} catch(SQLException e){
			System.out.println("error : " + e);
			
		}finally{ 
			//3.자원정리
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
				conn.close();
			}catch(SQLException e){
				System.out.println("error: " + e );
			}
			
		}
		return list;
	}
	
	
	public boolean insert(EmailListVo emailListVo){
		Connection conn = null;    // 지역변수 외에서도 사용하기 위해 블럭 밖에서 선언
	      PreparedStatement pstmt = null;
	      
	      try {                                    // {} -> 안에 있는 건 지역변수
		         conn = getConnection();
		         
		         //3. SQL문 준비
		         String sql = "insert into emaillist values (seq_emaillist.nextval, ?, ?, ?)";
		         pstmt = conn.prepareStatement(sql);
		         
		         //4. binding
		         pstmt.setString(1, emailListVo.getFirstName());
		         pstmt.setString(2, emailListVo.getLastName());
		         pstmt.setString(3, emailListVo.getEmail());
		         
		         //5. SQL문 실행
		         int count = pstmt.executeUpdate();
		         
		         //6.결과
		         
		         return count == 1;
	      } catch (SQLException e) {
	         System.out.println("error: " + e);
	         return false;
	         //finally는 항상 꼭 실행된다.
	      } finally {
	         //3. 자원정리
	         try {
	            if( pstmt != null) {
	               pstmt.close();
	            }
	            if( conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            System.out.println("error: " + e);
	         }
	      }
	      
	   }

}
