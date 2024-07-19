package AddressBook;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection
{
    static Connection con=null;
    DB_Connection(){}
    static
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(Credentials.url,Credentials.uName,Credentials.pwd);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        return  con;
    }

}
