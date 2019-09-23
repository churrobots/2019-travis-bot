/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Cannon;

public class IntakeUntilCannonLoaded extends Command {

  private Cannon _cannon;
  private boolean _keepLoading;

  public IntakeUntilCannonLoaded(Cannon cannon) {
    requires(cannon);
    _cannon = cannon;
    _keepLoading = true;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _cannon.startConveyorIntake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (_cannon.hasBall()) {
      _keepLoading = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return _keepLoading;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _cannon.stopConveyor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    _keepLoading = false;
  }
}
