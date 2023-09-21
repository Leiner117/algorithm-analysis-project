package com.tec.restrictionPropagation;

import java.util.List;

/**
 * La clase Pair representa un par de coordenadas (fila y columna) junto con una lista de posibles
 * soluciones (posiblesSoluciones).
 */
class Pair {
    int row;
    int column;
    List<Integer> possibleSolutions;
    int amountSolutions;

    public Pair(int row, int column, List<Integer> possibleSolutions, int amountSolutions) {
        this.row = row;
        this.column = column;
        this.possibleSolutions = possibleSolutions;
        this.amountSolutions = possibleSolutions.size();
    }
}
