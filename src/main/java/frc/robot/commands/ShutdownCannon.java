/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CargoCannon;

public class ShutdownCannon extends Command {

  private final CargoCannon _cargoCannon;
  private final double _timeItTakesForArmToFoldUpInSeconds = 2.1;

  public ShutdownCannon(CargoCannon cargoCannon) {
    requires(cargoCannon);
    _cargoCannon = cargoCannon;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    _cargoCannon.stopFlywheel();
    _cargoCannon.stopConveyor();
    _cargoCannon.foldUp();
    if (timeSinceInitialized() > _timeItTakesForArmToFoldUpInSeconds) {
      _cargoCannon.lock();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _cargoCannon.lock();
  }

}
