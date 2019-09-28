/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.tools.Gamepad.Axis;
import frc.robot.subsystems.Drivetrain;

public class DriveAsTank extends Command {

  private final Drivetrain _drivetrain;
  private final Axis _leftAxis;
  private final Axis _rightAxis;
  private final Axis _boostAxis;

  public DriveAsTank(Drivetrain drivetrain, Axis leftAxis, Axis rightAxis, Axis boostAxis) {
    requires(drivetrain);
    _drivetrain = drivetrain;
    _leftAxis = leftAxis;
    _rightAxis = rightAxis;
    _boostAxis = boostAxis;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

}
