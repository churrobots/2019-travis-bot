/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveForTime extends Command {

  private Drivetrain _drivetrain;
  private double _leftSpeed;
  private double _rightSpeed;

  public DriveForTime(Drivetrain drivetrain, double leftSpeed, double rightSpeed, double timeInSeconds) {
    requires(drivetrain);
    _drivetrain = drivetrain;
    _leftSpeed = leftSpeed;
    _rightSpeed = rightSpeed;
    setTimeout(timeInSeconds);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    _drivetrain.tankDrive(_leftSpeed, _rightSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _drivetrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
