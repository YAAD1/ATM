import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        //login to system
        var user=Operators.Login();

        int exit=0;
        Scanner sc=new Scanner(System.in);
        while(exit!=4){
            System.out.println("For Withdraw please press 1('one'): ");
            System.out.println("\nFor Deposit please press 2('two'): ");
            System.out.println("\nFor Check your Balance please press 3('three'): ");
            System.out.println("\nFor Exit please press 4('one'): ");
            System.out.println("\nPlease choose one...");
            int choice=sc.nextInt();
            if(choice==4)break;
            else if(choice==1){
                System.out.println("you press 1");
                Operators.WithDraw(user);
            }
            else if(choice==2){
                System.out.println("you press 2");
                Operators.Deposit(user);
            }
            else if(choice==3){
                System.out.println("you press 3");
                Operators.BalanceCheck(user);
            }

        }
    }

}
