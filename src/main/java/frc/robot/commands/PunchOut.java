/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hatch;

public class PunchOut extends Command {
  public Hatch _hatch;
  public PunchOut(Hatch hatch) {
    _hatch = hatch;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("punch-out (kForward for DoubleSolenoid @ 6, 4)");
    _hatch.puncher.set(Value.kForward);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
