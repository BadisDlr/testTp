/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.maze;

import java.beans.PropertyChangeListener;
import java.util.List;

/**
 *
 * @author fateh
 */
public interface IMap extends PropertyChangeListener{
    public List<ICellule> getNeighbors(int x, int y);
    
    public int getHeight();

    public int getWidth();

    public ICellule getCell(int x, int y);
}
