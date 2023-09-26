/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.backTracking;

import static com.tec.Main.Proyecto.empty;
import static com.tec.Main.Proyecto.size;
import static com.tec.Main.Proyecto.contadorComparaciones;
import static com.tec.Main.Proyecto.contadorAsignaciones;
import static com.tec.Main.Proyecto.contadorLineaEjecutadas;

/**
 *
 * @author josuc
 */
public class BackTracking {
    
    /**
    * Resuelve un tablero de Sudoku utilizando el algoritmo de Backtracking.
    *
    * @param board Un arreglo bidimensional que representa el tablero de Sudoku a resolver.
    * @return `true` si se encuentra una solución válida, `false` si no se puede resolver.
    */
   public static boolean solveSudoku(int[][] board) {
       contadorAsignaciones++; 

       contadorAsignaciones++;
       for (int row = 0; row < size; row++) { // Itera a través de cada fila del tablero
           contadorLineaEjecutadas++; 
           contadorAsignaciones++;
           contadorComparaciones++;
           contadorAsignaciones++;
           for (int col = 0; col < size; col++) { // Itera a través de cada columna del tablero.
               contadorLineaEjecutadas++;
               contadorAsignaciones++;
               contadorComparaciones++;
               if (board[row][col] == empty) { // Verifica si la casilla esta vacia. 
                   contadorLineaEjecutadas++;
                   contadorComparaciones++;
                   contadorAsignaciones++;
                   for (int num = 1; num <= size; num++) { // Recorre las posibles soluciones para la casilla (numeros del 1 al 9).
                       contadorLineaEjecutadas++;
                       contadorAsignaciones++;
                       contadorComparaciones++;
                       if (isValidPlacement(board, row, col, num)) { // Verifica si es valido colocar este numero en la casilla.
                           contadorLineaEjecutadas++;
                           contadorComparaciones++;
                           board[row][col] = num; // Asigna el numero actual a la casilla actual.
                           contadorLineaEjecutadas++;
                           contadorAsignaciones++;
                           if (solveSudoku(board)) { // Verifica si el tablero esta completo, encontró una solución válida.
                               contadorLineaEjecutadas++;
                               contadorComparaciones++;
                               contadorAsignaciones++;
                               contadorLineaEjecutadas++;
                               return true; // Encontró una solución válida.
                           }
                           board[row][col] = empty; // Retrocede si no es válida.
                           contadorLineaEjecutadas++;
                           contadorAsignaciones++;
                       }
                   }
                   contadorComparaciones++;
                   contadorAsignaciones++;
                   contadorLineaEjecutadas++;
                   return false; // No se encontró ninguna solución para esta celda.
               }
           }
           contadorComparaciones++;
       }
       contadorComparaciones++;

       contadorAsignaciones++;
       contadorLineaEjecutadas++;
       return true; // Se llenó toda la cuadrícula con éxito.
   }


    /**
    * Comprueba si un número 'num' puede ser colocado en la celda especificada sin violar las reglas del Sudoku.
    *
    * @param board Un arreglo bidimensional que representa el tablero de Sudoku.
    * @param row La fila de la celda que se va a verificar.
    * @param col La columna de la celda que se va a verificar.
    * @param num El número que se desea colocar en la celda.
    * @return `true` si el número 'num' puede colocarse en la celda sin violar las reglas del Sudoku, `false` en caso contrario.
    */
   private static boolean isValidPlacement(int[][] board, int row, int col, int num) {
       contadorAsignaciones += 5; 
       contadorComparaciones += 3; 
       contadorLineaEjecutadas++; 

       // La función verifica si el número 'num' puede ser colocado en la celda sin violar las reglas del Sudoku
       // Comprueba tres condiciones:
       // 1. El número 'num' no se usa en la misma fila (utilizando la función usedInRow).
       // 2. El número 'num' no se usa en la misma columna (utilizando la función usedInCol).
       // 3. El número 'num' no se usa en la misma subcuadrícula (utilizando la función usedInBox).

       // La expresión final utiliza operadores lógicos AND para asegurarse de que todas las condiciones se cumplan.
       return !usedInRow(board, row, num) && !usedInCol(board, col, num) && !usedInBox(board, row - row % 3, col - col % 3, num);
   }


    /**
    * Comprueba si el número se utiliza en la misma fila del tablero de Sudoku.
    *
    * @param board Un arreglo bidimensional que representa el tablero de Sudoku.
    * @param row La fila en la que se va a buscar el número.
    * @param num El número que se desea buscar en la fila.
    * @return `true` si el número se encuentra en la fila , `false` en caso contrario.
    */
   private static boolean usedInRow(int[][] board, int row, int num) {
       contadorAsignaciones += 3;
       contadorAsignaciones++;  
       for (int col = 0; col < size; col++) { // Recorre una fila de la matriz
           contadorLineaEjecutadas++;  
           contadorAsignaciones++;  
           contadorComparaciones++; 
           if (board[row][col] == num) { // Verifica si el numero esta en la casilla
               contadorLineaEjecutadas++; 
               contadorComparaciones++; 
               contadorAsignaciones++; 
               contadorLineaEjecutadas++; 
               return true; // El número se encuentra en la fila.
           }
       }
       contadorAsignaciones++;
       return false; // El número no se encuentra en la fila.
   }

    /**
     * Comprueba si el número se utiliza en la misma columna del tablero de Sudoku.
     *
     * @param board Un arreglo bidimensional que representa el tablero de Sudoku.
     * @param col La columna en la que se va a buscar el número.
     * @param num El número que se desea buscar en la columna.
     * @return `true` si el número se encuentra en la columna, `false` en caso contrario.
     */
    private static boolean usedInCol(int[][] board, int col, int num) {
        contadorAsignaciones += 3;
        contadorAsignaciones++;
        for (int row = 0; row < size; row++) { // Recorre una columna de la matriz
            contadorLineaEjecutadas++;
            contadorAsignaciones++;
            contadorComparaciones++;
            if (board[row][col] == num) { // Verifica si el numero esta en la casilla
                contadorLineaEjecutadas++;
                contadorComparaciones++;
                contadorAsignaciones++;
                contadorLineaEjecutadas++;
                return true; // El número se encuentra en la fila.
            }
        }
        contadorAsignaciones++;
        contadorLineaEjecutadas++;
        return false; // El número no se encuentra en la fila.
    }
    /**
     * Comprueba si el número se utiliza en la misma subcuadrícula (caja de 3x3) del tablero de Sudoku.
     *
     * @param board Un arreglo bidimensional que representa el tablero de Sudoku.
     * @param startRow La fila inicial de la subcuadrícula.
     * @param startCol La columna inicial de la subcuadrícula.
     * @param num El número que se desea buscar en la subcuadrícula.
     * @return `true` si el número 'num' se encuentra en la subcuadrícula, `false` en caso contrario.
     */
    private static boolean usedInBox(int[][] board, int startRow, int startCol, int num) {
        contadorAsignaciones += 3;
        contadorAsignaciones++;
        for (int row = 0; row < 3; row++) { // Recorre las filas de la matriz.
            contadorLineaEjecutadas++;
            contadorAsignaciones += 2;
            contadorComparaciones++;
            for (int col = 0; col < 3; col++) { // Recorre las columnas de la matriz.
                contadorLineaEjecutadas++;
                contadorAsignaciones++;
                contadorComparaciones++;
                if (board[row + startRow][col + startCol] == num) { // Compara el valor de la celda en la subcuadrícula con el número 'num'.
                    contadorLineaEjecutadas++;
                    contadorComparaciones++;
                    contadorAsignaciones++;
                    contadorLineaEjecutadas++;
                    return true;// El número 'num' se encuentra en la subcuadrícula.
                }
            }
        }
        contadorLineaEjecutadas++;
        contadorAsignaciones++;
        return false;   // El número 'num' no se encuentra en la subcuadrícula.
    }
}
