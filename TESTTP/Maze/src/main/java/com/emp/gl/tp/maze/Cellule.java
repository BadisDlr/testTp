/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.maze;

import java.awt.Panel;


public class Cellule extends Panel implements ICellule {

    private CellType cellType;
    private int x, y;

    public Cellule(int x, int y) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
    }
    
    @Override
    public CellType getCellType() {
        return cellType;
    }

    @Override
    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }


}
