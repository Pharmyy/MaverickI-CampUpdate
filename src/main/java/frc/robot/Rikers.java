package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Hardware.RobotID;
import frc.robot.Subsystems.*;
import frc.robot.Utils.RobotState;

public class Rikers {
    public enum RikersState {
        Disabled,
        Teleoperated,
        Autonomous,
        Test,
    };

    private RikersState _currentState;

    private Drivetrain _drivetrain;

    private RobotState _robot;

    public Rikers() {
        RobotID.initialize();

        UsbCamera src = new UsbCamera("usb0", "/dev/video0");
        src.setResolution(320, 240);
        CameraServer.getInstance().startAutomaticCapture(src);

        _drivetrain = new Drivetrain(RobotID.leftMaster, RobotID.rightMaster);

        _robot = new RobotState(RobotID.driverJoystick);

        _currentState = RikersState.Disabled;
    }

    public void periodicTasks() {
        _robot.getJoystickValues();
        _drivetrain.arcadeDrive(RobotID.driverJoystick.getRawAxis(1), RobotID.driverJoystick.getRawAxis(4));
    
    }

    public void changeState(RikersState newState) {
        _currentState = newState;
    }
}