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

  private CargoCannon _shooter;

  public ShutdownCannon(CargoCannon shooter) {
    requires(shooter);
    _shooter = shooter;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(2.1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    _shooter.stopFlywheel();
    _shooter.stopConveyor();
    _shooter.foldUp();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _shooter.lock();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
