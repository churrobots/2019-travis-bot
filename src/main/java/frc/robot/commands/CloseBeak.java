/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.HatchPlacer;

public class CloseBeak extends Command {

  private HatchPlacer _hatchPlacer;

  public CloseBeak(HatchPlacer hatchPlacer) {
    _hatchPlacer = hatchPlacer;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _hatchPlacer.closeBeak();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // takes some time to close the beak fully for sure
    return timeSinceInitialized() > 0.5;
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
