package frc.robot.Hardware;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import com.ctre.phoenix.motorcontrol.InvertType;

public class LeftDrivetrainConfigs {

    public static void configSide(VictorSPX master, VictorSPX slave) {
        VictorSPXConfiguration masterConfigs = new VictorSPXConfiguration();

        master.configAllSettings(masterConfigs);
        master.setInverted(false);
        master.setNeutralMode(NeutralMode.Brake);
        master.setSensorPhase(true);

        VictorSPXConfiguration slaveConfigs = new VictorSPXConfiguration();

        slave.configAllSettings(slaveConfigs);

        slave.follow(master);
        slave.setInverted(InvertType.FollowMaster);
        slave.setNeutralMode(NeutralMode.Brake);
    }
}