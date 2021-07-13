package frc.robot.Hardware;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class RobotID {
    /*Drivetrain Motor Controllers */
    public static VictorSPX leftMaster = new VictorSPX(1);
    public static VictorSPX leftSlave = new VictorSPX(2);
    public static VictorSPX rightMaster = new VictorSPX(3);
    public static VictorSPX rightSlave = new VictorSPX(4);

    public static Joystick driverJoystick; 

public static void initialize() {
    /*Drivetrain initialize*/
    leftMaster = new VictorSPX(0);
    leftSlave = new VictorSPX(1);
    rightMaster = new VictorSPX(2);
    rightSlave = new VictorSPX(3);

    driverJoystick = new Joystick(0);

    conifgControllers();
}

private static void conifgControllers() {
    LeftDrivetrainConfigs.configSide(leftMaster, leftSlave);
    RightDrivetrainConfigs.configSide(rightMaster, rightSlave, leftMaster);
    }
}
