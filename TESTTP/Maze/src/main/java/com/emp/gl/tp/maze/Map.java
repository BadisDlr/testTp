/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.maze;

import com.emp.gl.tp.robot.Position;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fateh
 */
public class Map implements IMap {

    private final ICellule[][] cells;
    private final int height;
    private final int width;

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new ICellule[height][width];

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                cells[y][x] = new Cellule(x, y);
            }
        }
    }

    @Override
    public List<ICellule> getNeighbors(int x, int y) {
        List<ICellule> neighbors = new ArrayList<>();
        if (x < width && y < height && x >= 0 && y >= 0) {
            if (x > 0) {
                neighbors.add(cells[x - 1][y]);
            }
            if (x < width - 1) {
                neighbors.add(cells[x + 1][y]);
            }

            if (y > 0) {
                neighbors.add(cells[x][y - 1]);
            }
            if (y < height - 1) {
                neighbors.add(cells[x][y + 1]);
            }
        }

        return neighbors;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Position oldPosition = (Position)evt.getOldValue();
        Position newPosition = (Position)evt.getNewValue();
        
        int newRobotX = newPosition.getX();
        int newRobotY  = newPosition.getY();
        int oldRobotX = oldPosition.getX();
        int oldRobotY = oldPosition.getY();
        System.out.println("Position changed " + newRobotX + ", " + newRobotY);
    }
    
    
    @Override
    public ICellule getCell(int x, int y) {
        return cells[y][x];
    }

}
