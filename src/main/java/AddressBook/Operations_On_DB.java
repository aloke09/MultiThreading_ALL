package AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Operations_On_DB
{
    Scanner sc=new Scanner(System.in);
    public void insert_DB(String fName,String lName,String address,String city,String state,String mail,int zip,long phno)
    {

        try(Connection con=DB_Connection.getCon())
        {
            PreparedStatement ps = con.prepareStatement("insert into addressbook values(?,?,?,?,?,?,?,?)");
            ps.setString(1,fName);
            ps.setString(2,lName);
            ps.setString(3,address);
            ps.setString(4,city);
            ps.setString(5,state);
            ps.setString(6,mail);
            ps.setInt(7,zip);
            ps.setLong(8,phno);
            int r = ps.executeUpdate();
            if(r>0)
            {
                System.out.println("data successfully inserted");
            }
            else {
                System.err.println("not inserted");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void display_DB()
    {
        try(Connection con=DB_Connection.getCon())
        {
            PreparedStatement ps = con.prepareStatement("select * from addressbook");
            ResultSet rs = ps.executeQuery();
            int c=0;
            while (rs.next())
            {
                c++;
                System.out.println(rs.getString(1)+"   " +
                        rs.getString(2)+"   " +
                        rs.getString(3)+"   " +
                        rs.getString(4)+"   " +
                        rs.getString(5)+"   " +
                        rs.getString(6)+"   " +
                        rs.getString(7)+"   " +
                        rs.getString(8));
            }
            System.out.println(c+" rows present in DB");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void delete(String city)
    {
        try(Connection con= DB_Connection.getCon())
        {
            PreparedStatement ps = con.prepareStatement("delete from addressbook Where city=?");
            ps.setString(1,city);
            int i = ps.executeUpdate();
            if(i>0)
            {
                System.out.println("Data deleted successfully!!");
            }
            else {
                System.err.println("not deleted ");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update(String fName,String lName,String address,String city,String state,String mail,int zip,long phno)
    {
        try(Connection con=DB_Connection.getCon())
        {
            PreparedStatement ps = con.prepareStatement("update addressbook set lname=?,address=?,city=?,state=?,email=?,zip=?,phno=? where fname=?");
            ps.setString(1,lName);
            ps.setString(2,address);
            ps.setString(3,city);
            ps.setString(4,state);
            ps.setString(5,mail);
            ps.setInt(6,zip);
            ps.setLong(7,phno);
            ps.setString(8,fName);
            int r = ps.executeUpdate();
            if(r>0)
            {
                System.out.println("data successfully inserted");
            }
            else {
                System.err.println("not inserted");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
