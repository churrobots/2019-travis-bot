/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CargoCannon;

public class LoadCargo extends Command {
  
  private final CargoCannon _cargoCannon;
  private final double _timeNeededForBallToSettleInSeconds = 0.5;

  public LoadCargo(CargoCannon cargoCannon) {
    requires(cargoCannon);
    _cargoCannon = cargoCannon;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    // If there is already cargo loaded, don't allow new cargo.
    // Just cancel the command and don't pull it any further.
    // TODO: make sure the DIO is reliable, and give some way of overriding this in case it gets unseated
    if (_cargoCannon.hasCargoInHoldingArea()) {
      cancel();

    // Otherwise, begin attempting to intake cargo.
    } else {
      _cargoCannon.unlock();
      _cargoCannon.foldDown();
      _cargoCannon.runConveyorIntake();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // TODO: verify auto-stop works with an actual ball
    if (_cargoCannon.hasCargoInHoldingArea()) {
      setTimeout(_timeNeededForBallToSettleInSeconds);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _cargoCannon.stopConveyor();
    _cargoCannon.foldUp();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
