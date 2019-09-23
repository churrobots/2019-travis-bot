/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Cannon;

public class IntakeUntilBallExits extends Command {
  private Cannon _cannon;
  public IntakeUntilBallExits(Cannon cannon) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(cannon);
    _cannon = cannon;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _cannon.startConveyorIntake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // give it extra time to make sure the ball exits via the flywheel
    return timeSinceInitialized() > 1.6;
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
