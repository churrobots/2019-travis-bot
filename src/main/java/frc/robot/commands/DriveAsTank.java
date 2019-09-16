package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveAsTank extends Command {

  public DriveAsTank(Drivetrain drivetrain) {
    requires(drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // double leftSpeed = -driverGamepad.getRawAxis(leftJoystickYAxis);
    // double rightSpeed = -driverGamepad.getRawAxis(rightJoystickYAxis);
    // double boost = driverGamepad.getRawAxis(rightAnalogTrigger);
    // double brownoutModifier = this.getBrownoutModifer();
    // double minSpeed = 0.50 * brownoutModifier;
    // double maxSpeed = 1.00 * brownoutModifier;
    // double speedModifier = minSpeed + boost * (maxSpeed - minSpeed);
    // travisDrive.tankDrive(speedModifier * leftSpeed, speedModifier * rightSpeed);
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
