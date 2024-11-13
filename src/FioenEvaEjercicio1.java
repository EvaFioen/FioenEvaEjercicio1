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


        System.out.println("Welcome to Bomber Man!\nIn order to make the matrix we will ask you for numbers of rows and columns.");

        while (usuarioFilas < 2 || usuarioFilas > 10) { //poniendo los limites de filas
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

        while (usuarioColumnas < 2 || usuarioColumnas > 10) { // poniendo los limites de columnas
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

        // La creacion de la matriz, teniendo en cuenta los numeros aleatorios y poniendo el max para el 'random' que se llama matrixMaker
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

        // Aqui se encuentran el parte del menu con sus opciones para eligir
        do {
            System.out.println("\nThe menu:");
            System.out.println("[2] Put the bomb");
            System.out.println("[1] Show the matrix");
            System.out.println("[0] Leave");
            if (input.hasNextInt()) {
                int menu = input.nextInt();
                input.nextLine();
                switch (menu) {
                    case 2: // el parte de poner la bomba donde mostramos entre que numero de filas y columnas el usuario puede eligir
                        int filaBomba = -1;
                        int filasPermitidas = usuarioFilas - 1;
                        int columnaBomba = -1;
                        int columnasPermitidas = usuarioColumnas - 1;

                        while (filaBomba < 0 || filaBomba > filasPermitidas) { // se pide al usuario un numero para la bomba es esa fila
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
                        while (columnaBomba < 0 || columnaBomba > columnasPermitidas) { // se pide al usuario un numero para poner la bomba es esa columna
                            System.out.println("Enter the column you want to put the bomb. Pick between row 0 and " + columnasPermitidas);
                            if (input.hasNextInt()) {
                                columnaBomba = input.nextInt();
                                input.nextLine();
                                if (columnaBomba >= 0 && columnaBomba <= columnasPermitidas) {
                                    System.out.println("You have placed the bomb in column " + columnaBomba);
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
                            sumColumna += matrix[i][columnaBomba];
                        }
                        System.out.println("The explosion value is " + (sumFila + sumColumna - matrix[filaBomba][columnaBomba]));// Para no calcular doble

                        // cambiando la fila y columna eligido por el usuario de poner la bomba a 0s
                        for (int i = 0; i < matrix.length; i++) {
                            matrix[i][columnaBomba] = 0;
                        }
                        for (int j = 0; j < matrix[filaBomba].length; j++) {
                            matrix[filaBomba][j] = 0;
                        }
                            Random bomba = new Random();
                            matrix[filaBomba][columnaBomba] = bomba.nextInt(2);

                            System.out.println("This is de updated matrix"); // Y aqui se muestra y verifica que se ha cambiado la fila y columna
                            for (int i = 0; i < matrix.length; i++) {
                                for (int j = 0; j < matrix[i].length; j++) {
                                    System.out.print(matrix[i][j] + " ");
                                }
                                System.out.println();
                            }

                        if (filaBomba == 0 && 0 == columnaBomba) { // si son 0s, el usuario ha ganado y se cierra el juego
                            System.out.println("You have won! The game will be closed.");
                            out = true;
                            break;
                        }else if (matrix[filaBomba][columnaBomba] == 1){ // si hay un valor que no es 0, el usuario ha perdido se vuele al menu
                            System.out.println("You have lost. Press enter to return to the menu.");
                            input.nextLine();
                            break;
                        }else{
                            System.out.println("Something went wrong. Reload the game.");
                        }

                    case 1: // Se muestra la matriz de inicio (antes de poner la bomba)
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

                    case 0: // el usuario tiene opcion de cerrar el juego
                        System.out.println("The game will be shut down. Come again soon!");
                        out = true;
                        break;

                    default: // si el usuario no elige entre las 3 opciones se muestrara que es incorrecto y volvemos a pedir
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


