package com.tec.Main;

import com.tec.backTracking.BackTracking;
import com.tec.busqueda.busqueda;
import com.tec.restrictionPropagation.restrictionPropagation;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Proyecto {
    public static final int size = 9;
    public static final int empty = 0;
    public static int contadorComparaciones = 0;
    public static int contadorAsignaciones = 0;
    public static int contadorLineaEjecutadas = 0;

    /**
    * Imprime una representación visual del tablero de Sudoku en la consola.
    * @param board Un arreglo bidimensional que representa el tablero de Sudoku a imprimir.
    */
    public static void printSudoku(int[][] board) {
        // Itera a través de cada fila del tablero
        for (int row = 0; row < size; row++) {
            // Itera a través de cada columna del tablero
            for (int col = 0; col < size; col++) {
                // Imprime el valor de la celda actual seguido de un espacio en blanco
                System.out.print(board[row][col] + " ");
            }
            // Después de imprimir una fila completa, mueve el cursor a una nueva línea
            System.out.println();
        }
    }

    /**
    * Cuenta y muestra la cantidad de celdas rellenas en un tablero de Sudoku.
    *
    * @param board Un arreglo bidimensional que representa el tablero de Sudoku.
    */
   public static void countVoidCells(int[][] board) {
       int count = 0; // Inicializa el contador de celdas rellenas en 0
        // Itera a través de las filas y columnas del tablero
        for (int[] board1 : board) {
            for (int j = 0; j < board1.length; j++) {
                // Comprueba si el valor de la celda actual no es igual a cero (celda rellena)
                if (board1[j] != 0) {
                    count++; // Incrementa el contador si la celda está rellena
                }
            }
        }

       // Muestra la cantidad de celdas rellenas en la consola
       System.out.println("Cantidad de celdas Rellenas: " + count);
   }


    /**
    * Muestra un menú de opciones para interactuar con el juego de Sudoku.
    * Permite al usuario seleccionar entre diferentes algoritmos de resolución o salir del juego.
    */
   public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        
        do {
            int[][] board = selectBoard();
            System.out.println("Ingrese una opción:");
            System.out.println("0. Salir");
            System.out.println("1. Resolver con Algoritmo Backtracking");
            System.out.println("2. Resolver con Algoritmo de Búsqueda");
            System.out.println("3. Resolver con Algoritmo de Restricción y Propagación");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Llama a la función del menú para el Algoritmo Backtracking
                    menuBackTraking(board);
                    break;
                case 2:
                    // Llama a la función del menú para el Algoritmo de Búsqueda
                    busqueda.main(board);
                    break;
                case 3:
                    // Llama a la función del menú para el Algoritmo de Restricción y Propagación
                    restrictionPropagation.main(board);
                    break;
                default:
                    // Opción no válida, se continúa mostrando el menú
                    break;
            }
        } while (option != 0);

       // Cierra el escáner cuando el usuario elige salir
       scanner.close();
   }
    public static int[][] selectBoard(){
            int[][][] boards = {
                {
                    {1, 0, 0, 0, 0, 0, 0, 0, 4},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {7, 0, 0, 0, 9, 0, 0, 0, 8},
                    {0, 7, 0, 0, 0, 8, 0, 0, 0},
                    {0, 0, 0, 3, 0, 0, 0, 0, 0},
                    {6, 0, 0, 0, 0, 0, 0, 5, 0},
                    {0, 8, 0, 0, 0, 0, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 4, 0},
                    {3, 0, 0, 0, 0, 0, 8, 0, 0}
                },
                 {
                    {5, 3, 0, 0, 7, 0, 0, 1, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 8},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 9, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {2, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}
                },
                {
                    {1, 0, 0, 8, 0, 2, 6, 0, 4},
                    {8, 0, 2, 0, 7, 4, 1, 0, 0},
                    {7, 4, 3, 0, 9, 0, 5, 0, 8},
                    {2, 7, 0, 0, 5, 8, 0, 9, 0},
                    {0, 5, 0, 3, 0, 7, 2, 8, 1},
                    {6, 3, 0, 2, 1, 0, 0, 5, 7},
                    {0, 8, 6, 9, 0, 3, 7, 0, 5},
                    {5, 2, 0, 6, 8, 0, 0, 4, 0},
                    {3, 1, 9, 7, 0, 5, 8, 0, 2}
                },
                {
                    {1, 0, 5, 8, 3, 2, 6, 0, 4},
                    {8, 0, 2, 5, 7, 4, 1, 3, 9},
                    {7, 4, 3, 0, 9, 0, 5, 2, 8},
                    {2, 7, 0, 4, 5, 8, 3, 9, 0},
                    {0, 5, 4, 3, 6, 7, 2, 8, 1},
                    {6, 3, 0, 2, 1, 9, 4, 5, 7},
                    {0, 8, 6, 9, 2, 3, 7, 1, 5},
                    {5, 2, 7, 6, 8, 1, 0, 4, 3},
                    {3, 1, 9, 7, 0, 5, 8, 0, 2}
                },
                {
                    {1, 9, 5, 8, 3, 2, 6, 7, 4},
                    {8, 6, 2, 5, 7, 4, 1, 3, 9},
                    {7, 4, 3, 1, 9, 6, 5, 2, 8},
                    {2, 7, 1, 4, 5, 8, 3, 9, 6},
                    {9, 5, 4, 3, 6, 7, 2, 8, 1},
                    {6, 3, 8, 2, 1, 9, 4, 5, 7},
                    {4, 8, 6, 9, 2, 3, 7, 1, 5},
                    {5, 2, 7, 6, 8, 1, 9, 4, 3},
                    {3, 1, 9, 7, 4, 5, 8, 6, 2}
                }
            };
        Scanner scanner = new Scanner(System.in);
        int optio;
        // Títulos de las opciones del menú
        String[] titles = {
            "Salir",
            "Resolver sudoku de 17",
            "Resolver sudoku de 34",
            "Resolver sudoku de 51",
            "Resolver sudoku de 68",
            "Resolver sudoku"
        };  
        // Mostrar las opciones del menú al usuario
        System.out.println("Ingrese una opcion:");
        for (int i = 0; i < titles.length; i++) {
            System.out.println(i + ". " + titles[i]);
        }
        optio = scanner.nextInt();
        if (optio >= 1 && optio <= 5) {
            // Selecciona el tablero de Sudoku correspondiente según la opción del usuario
            int[][] selectedBoard = boards[optio - 1];
            return selectedBoard;
        }
        if (optio == 0){
            return null;
        }
        else {
            System.err.println("INGRESE UNA OPCIÓN VÁLIDA!");
        }
        return null;

   }
  

   /**
    * Implementa un menú interactivo para resolver sudokus utilizando el algoritmo de Backtracking.
    * Permite al usuario seleccionar diferentes sudokus predefinidos para resolver y muestra estadísticas de resolución.
    */

    public static void menuBackTraking(int[][] selectBoard) {
        
        
        // Reinicia los contadores de operaciones para cada iteración.
        contadorAsignaciones = 0;
        contadorComparaciones = 0;
        contadorLineaEjecutadas = 0;
        
        
            
            
        // Calcula la cantidad de celdas vacías en el tablero seleccionado
        countVoidCells(selectBoard);

        System.out.println("Sudoku resuelto:");

        // Inicia el temporizador
        long startTime = System.currentTimeMillis();

        // Resuelve el Sudoku utilizando el algoritmo de Backtracking
        BackTracking.solveSudoku(selectBoard);

        // Detiene el temporizador
        long endTime = System.currentTimeMillis();

        // Calcula la duración en milisegundos
        long durationMilliseconds = endTime - startTime;

        // Convierte la duración de milisegundos a segundos con tres decimales
        double durationSeconds = durationMilliseconds / 1000.0;

        // Formatea la duración para mostrar tres decimales
        String formattedDuration = String.format("%.3f", durationSeconds);

        // Imprime la duración en segundos con tres decimales
        System.out.println("El algoritmo tomo " + formattedDuration + " segundos.");
        System.out.println("Cantidad de comparaciones para resolver el sudoku: " + contadorComparaciones);
        System.out.println("Cantidad de asignaciones para resolver el sudoku: " + contadorAsignaciones);
        System.out.println("Cantidad de líneas ejecutadas para resolver el sudoku: " + contadorLineaEjecutadas);

        // Imprime el Sudoku resuelto
        printSudoku(selectBoard);
    
        System.out.println("Saliendo...");
    }


    public static void main(String[] args) {
            // Definición de sudokus predefinidos

        menu();

    }
}
