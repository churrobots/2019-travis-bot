/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CargoCannon;

public class IntakeUntilCargoReachesHoldingArea extends Command {

  private CargoCannon _cargoCannon;
  private boolean _keepLoading;

  public IntakeUntilCargoReachesHoldingArea(CargoCannon cargoCannon) {
    requires(cargoCannon);
    _cargoCannon = cargoCannon;
    _keepLoading = true;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _cargoCannon.startConveyorIntake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (_cargoCannon.hasCargoInHoldingArea()) {
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
    _cargoCannon.stopConveyor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    _keepLoading = false;
  }
}
