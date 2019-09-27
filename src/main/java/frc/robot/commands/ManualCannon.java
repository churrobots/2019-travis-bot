/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CargoCannon;
import frc.robot.tools.SpeedTarget;

public class ManualCannon extends Command {
  CargoCannon _cargoCannon;
  SpeedTarget _intakeSpeed;
  SpeedTarget _flywheelSpeed;
  public ManualCannon(CargoCannon cargoCannon, SpeedTarget intakeSpeed, SpeedTarget flywheelSpeed) {
    requires(cargoCannon);
    _cargoCannon = cargoCannon;
    _intakeSpeed = intakeSpeed;
    _flywheelSpeed = flywheelSpeed;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    _cargoCannon.setConveyor(_intakeSpeed.get());
    _cargoCannon.setFlywheel(_flywheelSpeed.get());
    System.out.println("DOING THINGS");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
