package P1;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

public class Model {
	
	String name;
	int accno;
	String custid;
	String pwd;
	int balance;
	String email;
	
	private Connection con;
	String url="jdbc:oracle:thin:@//localhost";
	String user="SYSTEM";
	String password="system";
	private PreparedStatement pstmt;
	private ResultSet res;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Model() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		con = DriverManager.getConnection(url,user,password);
		
	}
	
	boolean login() throws Exception{
		String s = "SELECT * FROM BANK WHERE custid= ? AND pwd = ? ";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1,custid);
		pstmt.setString(2,pwd);
		
		res = pstmt.executeQuery();
		
		while(res.next()==true) {
			name = res.getString(1);
			accno = res.getInt(2);
			custid = res.getString(3);
			balance = res.getInt(5);
			email = res.getString(6);
			
			return true;
		}
		return false;
	}
	
	
	
	
}
