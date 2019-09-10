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
	int accno1;
	
	public int getAccno1() {
		return accno1;
	}
	public void setAccno1(int accno1) {
		this.accno1 = accno1;
	}


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
	
	boolean checkBalance() throws Exception{
		String s1="SELECT * FROM BANK WHERE ACCNO=?";
		pstmt = con.prepareStatement(s1);
		pstmt.setInt(1,accno);
		res= pstmt.executeQuery();
		
		while(res.next()==true) {
			name=res.getString(1);
			balance = res.getInt(5);
			return true;
		}
		return false;
		
	}
	
	boolean applyLoan() throws Exception {
		String s1="SELECT * FROM BANK WHERE ACCNO=?";
		pstmt = con.prepareStatement(s1);
		pstmt.setInt(1,accno);
		res= pstmt.executeQuery();
		
		while(res.next()==true) {
			name=res.getString(1);
			email = res.getString(6);
			return true;
		}
		return false;
		
	}
	
	boolean changePwd() throws Exception{
		String s3="UPDATE BANK SET PWD=? WHERE ACCNO=?";
		pstmt=con.prepareStatement(s3);
		
		pstmt.setString(1,pwd);
		pstmt.setInt(2,accno);
		
		int x = pstmt.executeUpdate();
		
		if(x==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	boolean transfer() throws Exception{
		String s4 = "SELECT * FROM BANK WHERE ACCNO=?";
		pstmt = con.prepareStatement(s4);
		pstmt.setInt(1, accno1);
		
		res = pstmt.executeQuery();
		
		while (res.next() == true) {
			String s5 = "UPDATE BANK SET BALANCE = BALANCE-? WHERE ACCNO =?";
			pstmt = con.prepareStatement(s5);
			pstmt.setInt(1, balance);
			pstmt.setInt(2, accno);
			
			int x1=pstmt.executeUpdate();
			
			if(x1==1){
				String s6="UPDATE BANK SET BALANCE = BALANCE+? WHERE ACCNO =?";
				pstmt = con.prepareStatement(s6);
				
				pstmt.setInt(1, balance);
				pstmt.setInt(2, accno1);
				int x2 = pstmt.executeUpdate();
				
				if(x2==1) {
					String s7="INSERT INTO GETSTATEMENT VALUES (?,?,?)";
					pstmt = con.prepareStatement(s6);
					
					pstmt.setInt(1, accno);
					pstmt.setInt(2, accno1);
					pstmt.setInt(3, balance);
					int x3 = pstmt.executeUpdate();
					
					if(x3==1) {
						return true;
					}
					else {
						return false;
					}
				}
			}
		}
		return false;
		
		
	}
	
	
}
