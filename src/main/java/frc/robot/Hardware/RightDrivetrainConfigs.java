package frc.robot.Hardware;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;

public class RightDrivetrainConfigs {

    public static void configSide(
            VictorSPX master, VictorSPX slave, VictorSPX leftMaster) {
        VictorSPXConfiguration masterConfigs = new VictorSPXConfiguration();

        master.configAllSettings(masterConfigs);
        master.setInverted(true);
        master.setNeutralMode(NeutralMode.Brake);
        master.setSensorPhase(true);
        master.selectProfileSlot(1, 1);

        VictorSPXConfiguration slaveConfigs = new VictorSPXConfiguration();

        slave.configAllSettings(slaveConfigs);

        slave.follow(master);
        slave.setInverted(InvertType.FollowMaster);
        slave.setNeutralMode(NeutralMode.Brake);
    }
}