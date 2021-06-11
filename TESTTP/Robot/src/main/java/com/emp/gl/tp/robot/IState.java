/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.robot;

public abstract class IState {

    protected IRobot robot;
    protected int dx, dy;
    protected StateIndicator indicator;

    public StateIndicator getIndicator() {
        return indicator;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public IState() {
    }

    public IState(IRobot robot) {
        this.robot = robot;
    }

    public void setContext(IRobot robot) {
        this.robot = robot;
    }

    public void blockedState() {

    }

    public void changeState(StateIndicator stateIndicator) {
        if (stateIndicator == StateIndicator.BLOCKED) {
            blockedState();
            System.out.println("Blocked");
        }
    }
}
