package frc.robot.Utils;

import edu.wpi.first.wpilibj.Joystick;

public class RobotState {

    public enum DriveTrainState {
        PercentOut,
        Position,
        MotionMagic,
    }

    public class DTStruct {
        public DriveTrainState state;
        public double leftSide;
        public double rightSide;

        @Override
        public String toString() {
            return state.toString() + "  " + leftSide + " " + rightSide;
        }

        public void set(DriveTrainState state, double left, double right) {
            this.state = state;
            leftSide = left;
            rightSide = right;
        }
    }
    ;

    public DTStruct driveTrainState;

    private Joystick _driver;

    public RobotState(Joystick driver) {
        _driver = driver;

        /* Initialize states */
        driveTrainState = new DTStruct();
    }

    public void getJoystickValues() {
        /* Drive base */

        double throt = -_driver.getRawAxis(1);
        double wheel = _driver.getRawAxis(4); /* Throttle is negated */
        double leftSide = throt + wheel;
        double rightSide = throt - wheel;

        driveTrainState.set(DriveTrainState.PercentOut, leftSide, rightSide);

    }
}