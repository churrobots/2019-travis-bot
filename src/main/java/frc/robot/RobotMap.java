package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(
    new WPI_TalonSRX(4),
    new WPI_VictorSPX(5),
    new WPI_VictorSPX(6)
  );

  SpeedControllerGroup rightMotors = new SpeedControllerGroup(
    new WPI_TalonSRX(1),
    new WPI_VictorSPX(2),
    new WPI_VictorSPX(3)
  );

  DifferentialDrive travisDrive = new DifferentialDrive(leftMotors, rightMotors);

  PWMVictorSPX flywheel = new PWMVictorSPX(0);
  PWMVictorSPX conveyor = new PWMVictorSPX(1);

  DoubleSolenoid beak = new DoubleSolenoid(0, 0, 3);
  DoubleSolenoid puncher = new DoubleSolenoid(0, 6, 4);

  DoubleSolenoid wrist = new DoubleSolenoid(0, 5, 2);
  Solenoid hook = new Solenoid(1, 1);

  PowerDistributionPanel powerDistributionPanel = new PowerDistributionPanel();
  Compressor compressor = new Compressor();

}
