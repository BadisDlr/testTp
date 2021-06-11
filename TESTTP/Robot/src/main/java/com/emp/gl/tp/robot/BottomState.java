/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.robot;

/**
 *
 * @author fateh
 */
public class BottomState extends IState {

    public BottomState(IRobot irobot) {
        super(irobot);
        indicator = StateIndicator.BOTTOM;
        dx = 0;
        dy = 1;
    }
    
    @Override
    public void changeState(StateIndicator stateIndicator) {
        super.changeState(stateIndicator);
        if (stateIndicator == StateIndicator.RIGHT) {
            this.robot.changeState(new RightState(this.robot));
        } else if (stateIndicator == StateIndicator.LEFT) {
            this.robot.changeState(new LeftState(this.robot));
        }
    }
}
