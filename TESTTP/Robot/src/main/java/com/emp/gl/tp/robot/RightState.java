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

public class RightState extends IState {

    public RightState(IRobot irobot) {
        super(irobot);
        indicator = StateIndicator.RIGHT;
        dx = 1;
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
