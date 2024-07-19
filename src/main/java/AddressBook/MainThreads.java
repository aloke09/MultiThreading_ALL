package AddressBook;

import java.util.Scanner;

public class MainThreads extends Thread
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("1. insert" +
                    "2. update" +
                    "3. delete" +
                    "4. display" +
                    "5. exit");
            System.out.println("Enter your choice--");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    Thread ins = new Thread(new Runnable() {
                        @Override
                        public void run()
                        {
                            System.out.println("Enter first name");
                            String fName=sc.next();
                            System.out.println("Enter last name");
                            String lName=sc.next();
                            System.out.println("Enter address");
                            String address=sc.next();
                            System.out.println("Enter city");
                            String city=sc.next();
                            System.out.println("Enter state");
                            String state=sc.next();
                            System.out.println("Enter email");
                            String mail=sc.next();
                            System.out.println("Enter zip");
                            int zip=sc.nextInt();
                            System.out.println("Enter phno");
                            long phno=sc.nextLong();
                            new Operations_On_DB().insert_DB(fName,lName,address,city,state,mail,zip,phno);
                        }
                    });
                    ins.start();
                    break;
                case 2:
                    Thread up = new Thread(new Runnable() {
                        @Override
                        public void run()
                        {
                            System.out.println("Enter first name");
                            String fName=sc.next();
                            System.out.println("Enter last name");
                            String lName=sc.next();
                            System.out.println("Enter address");
                            String address=sc.next();
                            System.out.println("Enter city");
                            String city=sc.next();
                            System.out.println("Enter state");
                            String state=sc.next();
                            System.out.println("Enter email");
                            String mail=sc.next();
                            System.out.println("Enter zip");
                            int zip=sc.nextInt();
                            System.out.println("Enter phno");
                            long phno=sc.nextLong();
                            new Operations_On_DB().update(fName,lName,address,city,state,mail,zip,phno);
                        }
                    });
                    up.start();
                    break;
                case 3:
                    Thread del = new Thread(new Runnable() {
                        @Override
                        public void run()
                        {
                            System.out.println("enter city-");
                            String city=sc.next();
                            new Operations_On_DB().delete(city);
                        }
                    });
                    del.start();
                    break;
                case 4:
                    Thread dis = new Thread(new Runnable() {
                        @Override
                        public void run()
                        {
                            new Operations_On_DB().display_DB();
                        }
                    });
                    dis.start();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("select a valid choice");
                    break;
            }
        }
    }
}
