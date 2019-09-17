package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.StandStill;

public class Drivetrain extends Subsystem {

  private DifferentialDrive _differentialDrive;
  private PowerManager _powerManager;

  public Drivetrain(SpeedControllerGroup leftMotors, SpeedControllerGroup rightMotors, PowerManager powerManager) {
    leftMotors.setInverted(true);
    rightMotors.setInverted(true);
    _differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
    _powerManager = powerManager;
  }

  public void driveAsTank(double leftSpeed, double rightSpeed) {
    double speedModifier = _powerManager.getDrivetrainPowerAllowance();
    _differentialDrive.tankDrive(leftSpeed * speedModifier, rightSpeed * speedModifier);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StandStill(this));
  }
}
