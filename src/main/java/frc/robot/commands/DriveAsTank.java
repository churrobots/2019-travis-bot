/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.tools.SpeedTarget;
import frc.robot.subsystems.Drivetrain;

public class DriveAsTank extends Command {

  private Drivetrain _drivetrain;
  private SpeedTarget _leftSpeedTarget;
  private SpeedTarget _rightSpeedTarget;
  private SpeedTarget _boostTarget;
  private boolean _interrupted = false;

  public DriveAsTank(Drivetrain drivetrain, SpeedTarget leftSpeedTarget, SpeedTarget rightSpeedTarget, SpeedTarget boostTarget) {
    requires(drivetrain);
    _drivetrain = drivetrain;
    _leftSpeedTarget = leftSpeedTarget;
    _rightSpeedTarget = rightSpeedTarget;
    _boostTarget = boostTarget;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double minSpeed = 0.7;
    double boostModifier = _boostTarget.get() * (1 - minSpeed) + minSpeed;
    // TODO: implement brownout prevention
    double leftSpeed = _leftSpeedTarget.get() * boostModifier;
    double rightSpeed = _rightSpeedTarget.get() * boostModifier;
    _drivetrain.tankDrive(leftSpeed, rightSpeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return _interrupted;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _drivetrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    _interrupted = true;
  }
}
