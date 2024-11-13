import java.util.Random;
import java.util.Scanner;

public class FioenEvaEjercicio1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int usuarioFilas = 1;
        int usuarioColumnas = 1;
        int low = 2;       //he tenido en cuenta que para que sea un matriz, que al menos tiene que haber 2 columnas y 2 filas
        int high = 9;
        Random matrixMaker = new Random();


        System.out.println("Welcome to Bomber Man!");

        while (usuarioFilas < 2 || usuarioFilas > 10) {
            System.out.println("Enter the number of rows between 2-10:");
            if (input.hasNextInt()) {
                usuarioFilas = input.nextInt();
                if (usuarioFilas >= 2 && usuarioFilas <= 10) {
                    System.out.println("You have chosen " + usuarioFilas + " rows");
                } else {
                    System.out.println("That number is too big or too small. Try again!");
                }
            } else {
                System.out.println("That is not a number. Try again!");
                input.next();
            }
        }

        while (usuarioColumnas < 2 || usuarioColumnas > 10) {
            System.out.println("Enter the number of columns between 2-10:");
            if (input.hasNextInt()) {
                usuarioColumnas = input.nextInt();
                if (usuarioColumnas >= 2 && usuarioColumnas <= 10) {
                    System.out.println("You haven chosen " + usuarioColumnas + " columns" + "\n");
                } else {
                    System.out.println("That number is too big or too small. Try again!");
                }
            } else {
                System.out.println("That is not a number. Try again!");
                input.next();
            }
        }
        System.out.println("This is the matrix that we have created for you!");
        int[][] matrix = new int[usuarioFilas][usuarioColumnas];
        for (usuarioFilas = 0; usuarioFilas < matrix.length; usuarioFilas++) {
            for (usuarioColumnas = 0; usuarioColumnas < matrix[usuarioFilas].length; usuarioColumnas++) {
                matrix[usuarioFilas][usuarioColumnas] = matrixMaker.nextInt(high + 1 - low) + low;
                System.out.print(matrix[usuarioFilas][usuarioColumnas] + " ");
            }
            System.out.println();
        }
        boolean out = false;

        do {
            System.out.println("\n" + "[2] Put the bomb");
            System.out.println("[1] Show the matrix");
            System.out.println("[0] Leave");
            if (input.hasNextInt()) {
                int menu = input.nextInt();
                input.nextLine();
                switch (menu) {
                    case 2:
                        int filaBomba = -1;
                        int filasPermitidas = usuarioFilas - 1;
                        int columnabomba = -1;
                        int columnasPermitidas = usuarioColumnas - 1;

                        while (filaBomba < 0 || filaBomba > filasPermitidas) {
                            System.out.println("Enter the row you want to put the bomb. Pick between row 0 and " + filasPermitidas);
                            if (input.hasNextInt()) {
                                filaBomba = input.nextInt();
                                input.nextLine();
                                if (filaBomba >= 0 && filaBomba <= filasPermitidas) {
                                    System.out.println("You have placed the bomb in row " + filaBomba);
                                } else {
                                    System.out.println("Invalid row. Pick a number between 0 and " + filasPermitidas);
                                }
                            } else {
                                System.out.println("That is not a valid number. Try again!");
                                input.nextLine();
                            }
                        }
                        while (columnabomba < 0 || columnabomba > columnasPermitidas) {
                            System.out.println("Enter the column you want to put the bomb. Pick between row 0 and " + columnasPermitidas);
                            if (input.hasNextInt()) {
                                columnabomba = input.nextInt();
                                input.nextLine();
                                if (columnabomba >= 0 && columnabomba <= columnasPermitidas) {
                                    System.out.println("You have placed the bomb in column " + columnabomba);
                                } else {
                                    System.out.println("Invalid column. Pick a number between 0 and " + columnasPermitidas);
                                }
                            } else {
                                System.out.println("That is not a valid number. Try again!");
                                input.nextLine();
                            }
                        }
                        //calcular la suma de fila eligido por el usuario= sumFila
                        int sumFila = 0;
                        for (int i = 0; i < matrix[filaBomba].length; i++) {
                            sumFila += matrix[filaBomba][i];
                        }
                        // calcular la suma de columna elegido por el usuario= sumColumna
                        int sumColumna = 0;
                        for (int i = 0; i < matrix.length; i++) {
                            sumColumna += matrix[i][columnabomba];
                        }
                        System.out.println("The explosion value is " + (sumFila + sumColumna - matrix[filaBomba][columnabomba]));// Para no calcular doble

                        for (int i = 0; i < matrix.length; i++) {
                            matrix[i][columnabomba] = 0;
                        }

                        for (int i = 0; i < matrix[filaBomba].length; i++) {
                            matrix[filaBomba][i] = 0;
                        }
                        System.out.println("This is de updated matrix");
                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println();
                        }

                        if (filaBomba == 0 && 0 == columnabomba) {
                            System.out.println("You have won! The game will be closed.");
                            out = true;
                            break;
                        }else{
                            System.out.println("You have lost. Press enter to return to the menu");
                            input.nextLine();
                            break;
                        }

                    case 1:
                        System.out.println("The matrix:");
                        for (int[] filas : matrix) {
                            for (int columnas : filas) {
                                System.out.print(columnas + " ");
                            }
                            System.out.println();
                        }
                        System.out.println("Press enter to return to the menu");
                        input.nextLine();
                        break;

                    case 0:
                        System.out.println("The game will be shut down. Come again soon!");
                        out = true;
                        break;

                    default:
                        System.out.println("The option chosen is not correct. Try again");
                        break;
                }

            } else {
                System.out.println("The option chosen is not correct. Try again");
                input.nextLine();
            }
        } while (!out);
    }
}


