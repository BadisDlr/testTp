/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.environment;

import com.emp.gl.tp.maze.*;
import com.emp.gl.tp.robot.Position;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Environment extends javax.swing.JFrame implements PropertyChangeListener, IMap {

    private final ICellule[][] cells;
    private final int height;
    private final int width;

    Container pane = getContentPane();

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public Environment(int height, int width) {
        initComponents();

        setSize(500,500);
        GridLayout layout = ((GridLayout) pane.getLayout());
        layout.setHgap(5);
        layout.setVgap(5);
        layout.setRows(height);
        layout.setColumns(width);


        this.height = height;
        this.width = width;
        cells = new ICellule[height][width];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                Cellule cell = new Cellule(x, y);
                Random rnd = new Random();
                cell.setBackground(Color.WHITE);
                boolean cellType = rnd.nextBoolean();
                if (cellType) {
                    cell.setCellType(CellType.OBSTACLE);
                    cell.setBackground(Color.black);
                }
                pane.add(cell);
            }
        }

        this.setVisible(true);
    }

    @Override
    public List<ICellule> getNeighbors(int x, int y) {
        List<ICellule> neighbors = new LinkedList<>();
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

        int newRobotX = ((Position) evt.getNewValue()).getX();
        int newRobotY = ((Position) evt.getNewValue()).getY();
        int oldRobotX = ((Position) evt.getOldValue()).getX();
        int oldRobotY = ((Position) evt.getOldValue()).getY();

        Cellule newCell = (Cellule) pane.getComponent(newRobotY * width + newRobotX);
        newCell.setBackground(Color.red);
        Cellule oldCell = (Cellule) pane.getComponent(oldRobotY * width + oldRobotX);
        oldCell.setBackground(Color.LIGHT_GRAY);
        if (oldRobotX == newRobotX && oldRobotY == newRobotY) {
            pane.getComponent(newRobotY * width + newRobotX).setBackground(Color.red);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public ICellule getCell(int x, int y) {
        return (Cellule) pane.getComponent(y * width + x);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
