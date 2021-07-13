package frc.robot.Subsystems;

import frc.robot.Hardware.RobotID;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.*;

public class Drivetrain {
    private VictorSPX leftside;
    private VictorSPX rightside;

public Drivetrain(VictorSPX leftside, VictorSPX rightside) {
    this.leftside = leftside;
    this.rightside = rightside;
}
public void arcadeDrive(double throttle, double wheel) {
    double leftthrottle = throttle + wheel;
    double rightthrottle = throttle - wheel;
    leftside.set(ControlMode.PercentOutput, leftthrottle);
    rightside.set(ControlMode.PercentOutput, rightthrottle);
}

}