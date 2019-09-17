package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.SpeedTarget;
import frc.robot.subsystems.Drivetrain;

public class DriveAsTankWithBooster extends Command {

  private Drivetrain _drivetrain;
  private SpeedTarget _leftSpeedTarget;
  private SpeedTarget _rightSpeedTarget;
  private SpeedTarget _boostTarget;

  public DriveAsTankWithBooster(Drivetrain drivetrain, SpeedTarget leftSpeedTarget, SpeedTarget rightSpeedTarget, SpeedTarget boostTarget) {
    requires(drivetrain);
    _drivetrain = drivetrain;
    _leftSpeedTarget = leftSpeedTarget;
    _rightSpeedTarget = rightSpeedTarget;
    _boostTarget = boostTarget;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftSpeed = _leftSpeedTarget.get() * _boostTarget.get();
    double rightSpeed = _rightSpeedTarget.get() * _boostTarget.get();
    _drivetrain.driveAsTank(leftSpeed, rightSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
