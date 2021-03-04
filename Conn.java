//To connect all the classes and frames through single connection class and different methods for each

package project;
import java.sql.*;

public class Conn{
    
    public Connection c;
    public PreparedStatement st, st1,st2;
    public ResultSet rs,rs1;
    public Conn(){
        try{
            c =  DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");
            st2=	 c.prepareStatement("select * from login");
            rs= st.executeQuery(); 
            rs.next();

            st1=c.prepareStatement("select * from license");
            rs1 = st1.executeQuery();
            rs1.next();
            st.close();
            c.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }      
    }
    
    public void update(int LicenseID, String Name, int Phone,  String Address) throws SQLException {
        c= getConnection();
    	String sql = "update license set Name = ?, Phone =? , Address= ? where LicenseID =?";
    	st= c.prepareStatement(sql); 
    	
    	st.setString(1, Name);
    	st.setInt(2, Phone);
    	st.setString(3, Address);
    	st.setInt(4, LicenseID);
    	
    	st.executeUpdate();
        System.out.println("Updated...");
        st.close();
        c.close();
    }

	
    public ResultSet getAllLicense(String licenseId) throws SQLException{
        c= getConnection();
        String sql = "select * from license where LicenseID = ?";
        st = c.prepareStatement(sql);

        st.setString(1, licenseId);

        return  st.executeQuery();
    }

    public void addLicense (String licenseId,String name, String phone, String address) throws SQLException {
        c= getConnection();
        String sql = "insert into license values(?,?,?,?)";
        st = c.prepareStatement(sql);

        st.setString(1, licenseId);
        st.setString(2, name);
        st.setString(3, phone);
        st.setString(4, address);

        st.executeUpdate();
        st.close();
        c.close();
    }

    public void deleteLicense(int licenseId) throws SQLException{
        c= getConnection();
        String sql = "delete from license where LicenseID=?";
        st=c.prepareStatement(sql);

        st.setInt(1, licenseId);

        st.executeUpdate();
        st.close();
        c.close();

    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");
    
    }
//  }
//    public static  new Conn(); 
//    	
   //}
//    	
   
//    	
   }





 
