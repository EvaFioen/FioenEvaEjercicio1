import java.util.Scanner;

public class FioenEvaEjercicio1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int usuarioFilas = -1;
        int usuarioColumnas = -1;
        System.out.println("Welcome to Bomber Man!");

        while (usuarioFilas < 0 || usuarioFilas > 10) {
            System.out.println("Enter the number of rows:");
            if (input.hasNextInt()) {
                usuarioFilas = input.nextInt();
                if (usuarioFilas >= 0 && usuarioFilas <= 10) {
                    System.out.println("You have chosen: " + usuarioFilas);
                } else {
                    System.out.println("That number is to big or to small. Try again!");
                }
            }else{
                System.out.println("That is not a number. Try again");
                input.next();
            }
        }
    }
}
