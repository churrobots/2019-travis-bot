package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.SpeedTarget;
import frc.robot.subsystems.Drivetrain;

public class DriveAsTank extends Command {

  private Drivetrain _drivetrain;
  private SpeedTarget _leftSpeedTarget;
  private SpeedTarget _rightSpeedTarget;
  private SpeedTarget _boostTarget;
  private SpeedTarget _powerAllocationTarget;
  private boolean _stoppedMotors = false;

  public DriveAsTank(Drivetrain drivetrain, SpeedTarget leftSpeedTarget, SpeedTarget rightSpeedTarget, SpeedTarget boostTarget, SpeedTarget powerAllocationTarget) {
    requires(drivetrain);
    _drivetrain = drivetrain;
    _leftSpeedTarget = leftSpeedTarget;
    _rightSpeedTarget = rightSpeedTarget;
    _boostTarget = boostTarget;
    _powerAllocationTarget = powerAllocationTarget;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double minSpeed = 0.7;
    double boostModifier = _boostTarget.get() * (1 - minSpeed) + minSpeed;
    double leftSpeed = _leftSpeedTarget.get() * boostModifier * _powerAllocationTarget.get();
    double rightSpeed = _rightSpeedTarget.get() * boostModifier * _powerAllocationTarget.get();
    _drivetrain.tankDrive(leftSpeed, rightSpeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return _stoppedMotors;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    _stoppedMotors = true;
    _drivetrain.tankDrive(0, 0);
  }
}
