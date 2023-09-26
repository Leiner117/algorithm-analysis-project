package com.tec.restrictionPropagation;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
//import com.tec.restrictionPropagation.Pair;  

public class restrictionPropagation {
    public static int contadorAsignaciones = 0;
    public static int contadorComparaciones = 0;

/**
 * La función comprueba si un número determinado es válido para colocarse en un tablero de Sudoku en
 * una posición específica de fila y columna.
 * 
 * @param board Una matriz bidimensional que representa el tablero de Sudoku. Tiene unas dimensiones
 * de 9x9 y contiene números enteros que representan los números del tablero. Una celda vacía está
 * representada por el valor 0.
 * @param row El parámetro "fila" representa el índice de fila de la celda en el tablero de Sudoku. Se
 * utiliza para comprobar si el número dado ya está presente en la misma fila.
 * @param column El parámetro "columna" representa el índice de la columna en el tablero de Sudoku. Se
 * utiliza para comprobar si el número dado ya está presente en la columna.
 * @param num El parámetro "numero" representa el número cuya validez queremos comprobar en el
 * tablero de Sudoku.
 * @return El método `esValido` devuelve un valor booleano. Devuelve "verdadero" si el número dado es
 * válido para colocarlo en la posición especificada en el tablero de Sudoku, y "falso" en caso
 * contrario.
 */
    public static boolean isValid(int[][] board, int row, int column, int num) {
        contadorAsignaciones++; //Asignacion de la variable row
        contadorAsignaciones++; //Asignacion de la variable column
        contadorAsignaciones++; //Asignacion de la variable num
        contadorAsignaciones++; //Asignacion de matriz board
        
        // Comprueba si el número se repite en la fila
        contadorAsignaciones++; //Asignacion de la variable i
        contadorComparaciones++; //Comparacion falsa
        for (int i = 0; i < 9; i++) {
            contadorComparaciones++; //Comparacion verdadera
            contadorAsignaciones++;//Asignacion de la variable i
            
            contadorComparaciones++; //Comparacion falsa
            if (board[row][i] == num) {
                contadorComparaciones++; //Comparacion verdadera
                contadorAsignaciones++;//return
                return false;
            }
        }

        // Comprueba si el número se repite en la columna
        contadorAsignaciones++;//Asignacion de la variable i
        contadorComparaciones++;//Comparacion falsa
        for (int i = 0; i < 9; i++) {
            contadorComparaciones++;//Comparacion verdadera
            contadorAsignaciones++; //Asignacion de la variable i
            contadorComparaciones++;//Comparacion falsa
            if (board[i][column] == num) {
                contadorComparaciones++;//Comparacion verdadera
                contadorAsignaciones++;//return
                return false;
            }
        }

        // Comprueba si el número se repite en el subtablero 3x3
        int subBoardRowStart = 3 * (row / 3); contadorAsignaciones++; //Asignacion de la variable subBoardRowStart
        int subBoardColStart = 3 * (column / 3); contadorAsignaciones++; //Asignacion de la variable subBoardColStart
        contadorComparaciones++;//Comparacion falsa
        contadorAsignaciones++;//Asignacion de la variable i
        for (int i = subBoardRowStart; i < subBoardRowStart + 3; i++) {
            contadorComparaciones++;//Comparacion verdadera
            contadorAsignaciones++;//Asignaciones de la variable i


            contadorComparaciones++;//Comparacion falsa
            contadorAsignaciones++;//Asignacion de la variable j
            for (int j = subBoardColStart; j < subBoardColStart + 3; j++) {
                contadorComparaciones++;//Comparacion verdadera
                contadorAsignaciones++;//Asignacion de la variable j
                contadorComparaciones++;//Comparaciones falsa
                if (board[i][j] == num) {
                    contadorComparaciones++;//Comparacion verdadera\
                    contadorAsignaciones++;//return
                    return false;
                }
            }
        }
        contadorAsignaciones++;//return
        return true;
    }

/**
 * La función "verificarSolucion" verifica si un tablero de Sudoku está completamente resuelto iterando
 * por cada celda y devolviendo falso si alguna celda está vacía (0), de lo contrario devuelve
 * verdadero.
 * 
 * @param board El parámetro "tablero" es una matriz bidimensional de números enteros que representan
 * un tablero de Sudoku. Tiene unas dimensiones de 9x9, donde cada elemento representa un número del
 * Sudoku. Un valor de 0 indica una celda vacía.
 * @return El método devuelve un valor booleano. Devuelve verdadero si el tablero es una solución
 * válida, lo que significa que todas las celdas están llenas con valores distintos de cero. Devuelve
 * falso si hay al menos una celda con valor 0, lo que indica que la solución está incompleta.
 */
    public static boolean checkSolution(int[][] board) {
        contadorAsignaciones++;//Asignacion de la variable board
        contadorAsignaciones++;//Asignacion de la variable row
        contadorComparaciones++;//Comparacion falsa
        for (int row = 0; row < 9; row++) {
            contadorComparaciones++;//Comparacion verdadera
            contadorAsignaciones++;//Asignaciones de la variable row
            contadorAsignaciones++;//Asignacion de la variable column
            contadorComparaciones++;//Comparacion falsa
            for (int column = 0; column < 9; column++) {
                contadorComparaciones++;//Comparacion verdadera
                contadorAsignaciones++;//Asignacion de la variable column
                contadorComparaciones++;//Comparacion falsa
                if (board[row][column] == 0) {
                    contadorComparaciones++;//Comparacion verdadera
                    contadorAsignaciones++;//return
                    return false; 
                }
            }
        }
        contadorAsignaciones++;//return
        return true;
    }

/**
 * La función "encontrarSolucionesPosibles" toma como entrada un tablero de Sudoku y devuelve una lista
 * de pares que representan las celdas vacías del tablero y las posibles soluciones para cada celda.
 * 
 * @param board El parámetro "tablero" es una matriz bidimensional de números enteros que representan
 * un tablero de Sudoku. Cada elemento de la matriz representa una celda en el tablero, donde 0 indica
 * una celda vacía.
 * @return El método devuelve una lista de objetos de par.
 */
    public static List<Pair> findPossibleSolutions(int[][] board) {
        contadorAsignaciones++;//Asignacion de la variable board
        contadorAsignaciones++;//Asignacion de la variable possibleSolutions
        List<Pair> possibleSolutions = new ArrayList<>();


        contadorAsignaciones++;//Asignacion de la variable row
        contadorComparaciones++;//Comparacion falsa
        for (int row = 0; row < 9; row++) {
            contadorComparaciones++;//Comparacion verdadera
            contadorAsignaciones++;//Asignacion de la variable row

            contadorAsignaciones++;//Asignacion de la variable column
            contadorComparaciones++;//Comparacion falsa
            for (int column = 0; column < 9; column++) {
                contadorComparaciones++;//Comparacion verdadera
                contadorAsignaciones++;//Asignacion de la variable column
                contadorComparaciones++;//Comparacion falsa
                if (board[row][column] == 0) {
                    contadorComparaciones++;//Comparacion verdadera
                    contadorAsignaciones++;//Asignacion de la variable possibleSolutionList
                    List<Integer> possibleSolutionList = new ArrayList<>();
                    contadorAsignaciones++;//Asignacion de la variable num
                    contadorComparaciones++;//Comparacion falsa
                    for (int num = 1; num <= 9; num++) {
                        contadorComparaciones++;//Comparacion verdadera
                        contadorAsignaciones++;//Asignaciones de la variable num
                        contadorComparaciones++;//Comparacion falsa
                        if (isValid(board, row, column, num)) {
                            contadorComparaciones++;//Comparacion verdadera
                            contadorAsignaciones++;//Asignacion de la variable possibleSolutionList
                            possibleSolutionList.add(num);
                        }
                    }
                    contadorAsignaciones++;//Asignacion de la variable possibleSolutions
                    if (possibleSolutionList.size() == 1){
                        contadorAsignaciones++;//Asignacion de clase pair
                        contadorAsignaciones++;//Asignacion de row
                        contadorAsignaciones++;//Asignacion column
                        contadorAsignaciones++;//Asignacion possibleSolutionList
                        contadorAsignaciones++;//Asignacion possibleSolutionList.size()

                        possibleSolutions.add(new Pair(row, column, possibleSolutionList, possibleSolutionList.size()));
                    }
                    
                }
            }
        }
        contadorAsignaciones++;//return
        return possibleSolutions;
    }
    public static int getSolutionsSize(List<Pair> possibleSolutions){
        int totalSolutions = 0; contadorAsignaciones++;
        contadorAsignaciones++;//Asignacion de la variable pair
        contadorComparaciones++;//Comparacion falsa
        for (Pair pair : possibleSolutions) {
            contadorComparaciones++;//Comparacion verdadera
            contadorComparaciones++;//Comparacion falsa
            if (pair.amountSolutions == 1) {
                contadorComparaciones++;//Comparacion verdadera
                contadorAsignaciones++;//Asignacion de la variable totalSolutions
                totalSolutions++;
            }
            
        }
        contadorAsignaciones++;//return
        return totalSolutions;
    }


/**
 * La función "agregarSoluciones" toma una lista de pares que representan posibles soluciones para cada
 * celda de un tablero de Sudoku, y actualiza el tablero con la solución si solo hay una posibilidad.
 * 
 * @param possibleSolutions Una lista de objetos Pair. Cada objeto Par contiene la siguiente
 * información:
 * @param board Una matriz bidimensional que representa un tablero de Sudoku. Cada elemento de la
 * matriz representa una celda del tablero y el valor del elemento representa el número de esa celda.
 * @return El método devuelve una matriz 2D de números enteros.
 */
    public static boolean solveSudoku(int[][] board) {
        contadorAsignaciones++;//Asignacion de la variable possibleSolutions
        contadorAsignaciones++;//Asignacion de la variable board
        contadorAsignaciones++;//Asignacion de la variable solutionsSize
        List<Pair> possibleSolutions = findPossibleSolutions(board);
        int solutionsSize = getSolutionsSize(possibleSolutions);
        contadorComparaciones++;//Comparacion falsa
        while(solutionsSize != 0){
            contadorComparaciones++;//Comparacion verdadera
            contadorComparaciones++;//Comparacion falsa
            contadorAsignaciones++;//Asignacion de la variable pair
            for (Pair pair : possibleSolutions) {
                contadorComparaciones++;//Comparacion verdadera
                contadorAsignaciones++;//Asignacion de board
                board[pair.row][pair.column] = pair.possibleSolutions.get(0);
        }
        contadorAsignaciones++;//Asignacion de la variable possibleSolutions
        solutionsSize = getSolutionsSize(possibleSolutions);
        contadorAsignaciones++;//Asignacion de la variable possibleSolutions
        possibleSolutions = findPossibleSolutions(board);
    }
    contadorAsignaciones++;//return
    if (!checkSolution(board)){
        System.out.println("No hay solución para el Sudoku.");
        return false;
    }
    return true;
    }
/**
 * La función "printboard" imprime un tablero Sudoku de 9x9 representado por una matriz 2D.
 * 
 * @param board El parámetro "tablero" es una matriz bidimensional de números enteros. Representa un
 * tablero de Sudoku con 9 filas y 9 columnas. Cada elemento de la matriz representa un número en el
 * Sudoku.
 */
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }
    public static void main(int[][] board) {
        contadorAsignaciones = 0;
        contadorComparaciones = 0;
        long startTime = Instant.now().toEpochMilli();

        //float startTime = System.nanoTime();
        if (solveSudoku(board)){
            //float endTime = System.nanoTime();
            printBoard(board);
            long endTime = Instant.now().toEpochMilli();
            //float timeElapsed = endTime - startTime;
            long timeElapsed = endTime - startTime;
            System.out.println("Tiempo de ejecución en milisegundos: " + timeElapsed );
            System.out.println("Asignaciones: " + contadorAsignaciones);
            System.out.println("Comparaciones: " + contadorComparaciones);
        };
        
    }
}

