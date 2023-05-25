import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class Operators {
    public static Users Login() throws IOException{
        Scanner sc=new Scanner(System.in);
        int choice=0;
        while(choice!=2){
            System.out.println("\nFor Creat new account please press 1('one'): ");
            System.out.println("\nFor Login please press 2('two'): ");
            choice =sc.nextInt();
            if(choice==1) Operators.NewAccount();
        }
        Users user=new Users();

        String c_num = "";
        String c_password ="";
        while (true){

            System.out.println("\nFor input c_num: 1");
            System.out.println("\nFor input password: 2");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Please enter Citizenship number: ");
                int ca_num = sc.nextInt();
                c_num = Integer.toString(ca_num);
            } else if (choice == 2) {
                System.out.print("Please enter password: ");
                int ca_password = sc.nextInt();
                c_password = Integer.toString(ca_password);
                break;
            }
        }
        user=Operators.FileWR(user,c_num,c_password,"r");
        Operators.FileWR(user,c_num,c_password,"d");

//            File FUsersDataOpen= new File("UsersData.dat");
//
//            // Users user =new Users("2441","123","5000");
//
//            Scanner Freader=new Scanner(FUsersDataOpen);
//            boolean flag=true;
//            String r_user="";
//            //String[] lr_user=new String[20];
//            while(Freader.hasNextLine()){
//                r_user=Freader.nextLine();
//                String[] lr_user=r_user.split("/");
//                if(lr_user[0].equals(c_num)){
//                    flag=false;
//                    if(lr_user[1].equals(c_password)){
//                        user.setCitizenship_number(c_num);
//                        user.setPassword(c_password);
//                        user.setBalance(lr_user[2]);
//                    }
//                }
//            }
//            if(flag){
//                System.out.println("The user not found.");
//                continue;
//            }
//            else break;
        return user;
    }
    public static void NewAccount() throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter Citizenship number: ");
        String c_num=sc.nextLine();
        System.out.println("Please enter Password: ");
        String password=sc.nextLine();
        System.out.println("Please enter Balance: ");
        String balance=sc.nextLine();
        var user =new Users(c_num,password,balance);
        //FileWriter UserWriter=new FileWriter("UsersData.dat");
        //UserWriter.append(user.getCitizenship_number()+"/"+user.getPassword()+"/"+user.getBalance()+"/");
        Files.write(Paths.get("UsersData.dat"), ( user.getCitizenship_number()+"/"+user.getPassword()+"/"+user.getBalance()+"/").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println("writing completed.");
        //UserWriter.close();
    }
    public static void WithDraw(Users user) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the amount: ");
        int amount=sc.nextInt();
        int tempI=Integer.parseInt(user.getBalance());
        String tempS=Integer.toString(tempI-amount);
        user.setBalance(tempS);
        Operators.FileWR(user, user.getCitizenship_number(), user.getPassword(), "w");
    }
    public static void Deposit(Users user) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the amount: ");
        int amount=sc.nextInt();
        int tempI=Integer.parseInt(user.getBalance());
        String tempS=Integer.toString(tempI+amount);
        user.setBalance(tempS);
        Operators.FileWR(user, user.getCitizenship_number(), user.getPassword(), "w");

    }
    public static void BalanceCheck(Users user){
        System.out.println(user.getBalance());
    }
    public static Users FileWR(Users user,String c_num,String c_password,String w_r_d) throws IOException {
        File FUsersDataOpen= new File("UsersData.dat");

        if(w_r_d.equals("r")){
            // r for reading
            Scanner Freader=new Scanner(FUsersDataOpen);
            boolean flag=true;
            String r_user="";
            //String[] lr_user=new String[20];
            while(Freader.hasNextLine()){
                r_user=Freader.nextLine();
                String[] lr_user=r_user.split("/");
                // burada büyük verimsizlik var dosyada olan bütün kelimleri string[] in içine alıyorum ram katiliyim.
                if(lr_user[0].equals(c_num)){
                    flag=false;
                    if(lr_user[1].equals(c_password)){
                        user.setCitizenship_number(c_num);
                        user.setPassword(c_password);
                        user.setBalance(lr_user[2]);
                    }
                }
            }
            if(flag){
                System.out.println("The user not found.");
                return null;
            }
            String result="";
           result = result.replaceAll("\bTutorialspoint\b", "");
        }
        else if(w_r_d.equals("w")) {
           // FileWriter UserWriter = new FileWriter("UsersData.dat");
            Files.write(Paths.get("UsersData.dat"), ( user.getCitizenship_number()+"/"+user.getPassword()+"/"+user.getBalance()+"/\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("writing completed.");
//            UserWriter.write(user.getCitizenship_number() + "/" + user.getPassword() + "/" + user.getBalance() + "/");
//            System.out.println("writing completed.");
//            UserWriter.close();
        }
        else if(w_r_d.equals("d")){
            // d for delete


        }


        return user;
    }
}


// Users[] gibi bir şey açıp buna bütün elemanları çekip daha sonra arama işlemini yapabiliriz işlemler bittiiğindede değişmiş Users[] listesini dosyayı sıfırlayıp yazarız
// verimsiz olur ama zaten normal hayatta böyle veriler böyle tutulmuyor diye düşünüyorum.