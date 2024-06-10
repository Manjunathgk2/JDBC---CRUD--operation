package org.example;

import java.sql.*;

public class demo {
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5432/Studentdetails";
        String username="postgres";
        String password="root";
       Connection con=DriverManager.getConnection(url,username,password);
       System.out.println("connected");
       /*
       String sql1="UPDATE students set name = ?, branch = ? WHERE id = ?";
       PreparedStatement pst=con.prepareStatement(sql1);
        pst.setString(1, "ram");
        pst.setString(2, "AI");
        pst.setInt(3,8);
        pst.executeUpdate();
        System.out.println("updated");
        */

        String sql2="INSERT INTO students (id,name, branch,address, phone_number,enrollment_number) VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement pst2=con.prepareStatement(sql2);
        pst2.setInt(1,4);
        pst2.setString(2, "james");
        pst2.setString(3, "ML");
        pst2.setString(4,"cannada");
        pst2.setString(5, "123-3212");
        pst2.setString(6,"ty23");
        pst2.setInt(1,4);
        pst2.executeUpdate();
        System.out.println("inserted");

        /*
        String sql1 = "DELETE FROM students WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql1);
        pst.setInt(1,3);
        pst.executeUpdate();
        System.out.println("deleted");
        */

        String sql="select * from students";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()) {
            String name = rs.getString("name");
            String branch = rs.getString("branch");
            String address=rs.getString("address");
            String phone_number = rs.getString("phone_number");
            String enrollment_number = rs.getString("enrollment_number");
            System.out.println("name=" + name + " " + "branch=" + branch + " " +"address="+address+" "+"phone=" + phone_number+" "+"rollnumber="+enrollment_number);
        }
    }
}
