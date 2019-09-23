/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Extender;

public class UnlockExtender extends Command {
  private Extender _extender;

  public UnlockExtender(Extender extender) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(extender);
    _extender = extender;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _extender.unlock();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // give it a bit to unlock fully
    return timeSinceInitialized() > 0.8;
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
