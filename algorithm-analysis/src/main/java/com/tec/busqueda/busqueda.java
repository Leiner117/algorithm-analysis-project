package com.tec.busqueda;

public class busqueda {
    // Declaración de variables estáticas para contar comparaciones y asignaciones.
    static int comparaciones = 0;
    static int asignaciones = 0;

    public static void main(int[][]board) {
        // Registro del tiempo de inicio de la ejecución.
        float startTime = System.nanoTime();
        
        // Definición del tablero Sudoku como una matriz 9x9.
        
        if (solveSudoku(board)) { // Llama a la función para resolver el Sudoku.
            printSudoku(board); // Si se resuelve, imprime el tablero resultante.
        } else {
            System.out.println("No hay solución para el Sudoku.");
        }
        
        // Registro del tiempo de finalización de la ejecución.
        float endTime = System.nanoTime();
        
        // Cálculo del tiempo transcurrido en segundos y muestra en pantalla.
        float timeElapsed = endTime - startTime;
        System.out.println("Tiempo de ejecución en segundos: " + timeElapsed / 10000000);
    }

    public static boolean solveSudoku(int[][] sudoku) {
        asignaciones++;
        
        // Busca una celda vacía en el tablero.
        int[] emptyCell = findEmptyCell(sudoku);
        asignaciones++;

        comparaciones++;
        if (emptyCell == null) {
            asignaciones++;
            return true;  // Se resolvió el Sudoku, no quedan celdas vacías
        }
        int row = emptyCell[0]; asignaciones++;
        int col = emptyCell[1]; asignaciones++;

        comparaciones++; // contador del for
        asignaciones++; // contador del for
        
        // Intenta llenar la celda vacía con un número válido.
        for (int num = 1; num <= 9; num++) {
            comparaciones++; // contador del for
            comparaciones++; // contador del if
            asignaciones++; // contador del for
            asignaciones++; asignaciones++; asignaciones++; asignaciones++; // contador del if
            
            if (isValidMove(sudoku, row, col, num)) {
                sudoku[row][col] = num; asignaciones++; // Coloca el número en la celda
                asignaciones++; // contador del if
                comparaciones++; // contador del if
                
                // Llama recursivamente a solveSudoku para continuar con la resolución.
                if (solveSudoku(sudoku)) {
                    asignaciones++; // contador del return
                    return true;  // Se encontró una solución
                }

                sudoku[row][col] = 0;  asignaciones++; // Retrocede si no se encontró una solución 
            }
        }
        asignaciones++;
        return false; // No se encontró una solución válida en esta rama
    }

    public static int[] findEmptyCell(int[][] sudoku) {
        asignaciones++;
        int[] cell = new int[2]; asignaciones++;
        
        comparaciones++;
        asignaciones++;
        for (int row = 0; row < 9; row++) {
            comparaciones++; // contador del for1
            asignaciones++; // contador del for1
            asignaciones++; // contador del for2
            comparaciones++; // contador del for2
            for (int col = 0; col < 9; col++) {
                asignaciones++; // contador del for
                comparaciones++; // contador del for
                comparaciones++; // contador del if
                if (sudoku[row][col] == 0) {
                    cell[0] = row; asignaciones++;
                    cell[1] = col; asignaciones++;
                    asignaciones++; // contador del return
                    return cell; // Devuelve las coordenadas de una celda vacía
                }
            }
        }
        asignaciones++;
        return null; // No se encontraron celdas vacías, el Sudoku está resuelto
    }

    public static boolean isValidMove(int[][] sudoku, int row, int col, int num) {
        // Verifica si el número num ya existe en la misma fila o columna
        asignaciones++;asignaciones++;asignaciones++;asignaciones++; // parámetros
        
        comparaciones++;
        asignaciones++;
        for (int i = 0; i < 9; i++) {
            comparaciones++; // contador del for
            asignaciones++; // contador del for
            comparaciones+=2; // contador del if
            if (sudoku[row][i] == num || sudoku[i][col] == num) {
                asignaciones++; // contador del return
                return false;
            }
        }

        // Verifica si el número num ya existe en la misma región 3x3
        int regionRowStart = (row / 3) * 3; asignaciones++;
        int regionColStart = (col / 3) * 3; asignaciones++;
        comparaciones++;
        asignaciones++;
        for (int i = regionRowStart; i < regionRowStart + 3; i++) {
            comparaciones++; // contador del for
            asignaciones++; // contador del for
            comparaciones++; // contador del for
            asignaciones++; // contador del for
            for (int j = regionColStart; j < regionColStart + 3; j++) {
                comparaciones++; // contador del for
                asignaciones++; // contador del for
                comparaciones++; // contador del for
                if (sudoku[i][j] == num) {
                    asignaciones++; // contador del return
                    return false;
                }
            }
        }
        asignaciones++;
        return true; // El número es válido en esta celda
    }

    public static void printSudoku(int[][] sudoku) {
        asignaciones++;
        comparaciones++;
        asignaciones++;
        for (int i = 0; i < 9; i++) {
            comparaciones++; // contador del for
            asignaciones++; // contador del for
            comparaciones++; // contador del for
            asignaciones++; // contador del for
            for (int j = 0; j < 9; j++) {
                comparaciones++; // contador del for
                asignaciones++; // contador del for
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
            
        }
        System.out.println("Hubieron " + comparaciones + " comparaciones");
        System.out.println("Hubieron " + asignaciones + " asignaciones");
    }
}
