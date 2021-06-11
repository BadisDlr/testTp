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
public class LeftState extends IState {

    public LeftState(IRobot irobot) {
        super(irobot);
        indicator = StateIndicator.LEFT;
        dx = -1;
        dy = 0;
    }

    @Override
    public void changeState(StateIndicator stateIndicator) {
        super.changeState(stateIndicator);
        if (stateIndicator == StateIndicator.BOTTOM) {
            this.robot.changeState(new BottomState(this.robot));
        } else if (stateIndicator == StateIndicator.TOP) {
            this.robot.changeState(new TopState(this.robot));
        }
        
    }

}
