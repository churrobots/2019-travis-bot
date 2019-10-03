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

public class DriveAsCar extends Command {

  private final Drivetrain _drivetrain;
  private final Axis _turnAxis;
  private final Axis _speedAxis;
  private final Axis _boostAxis;
  private final double _minSpeed = 0.7;
  private final double _maxSpeed = 0.9;
  private final double _minSpeedToTurnInPlace = 0.1;

  public DriveAsCar(Drivetrain drivetrain, Axis turnAxis, Axis speedAxis, Axis boostAxis) {
    requires(drivetrain);
    _drivetrain = drivetrain;
    _turnAxis = turnAxis;
    _speedAxis = speedAxis;
    _boostAxis = boostAxis;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double boostModifier = _boostAxis.get() * (_maxSpeed - _minSpeed) + _minSpeed;
    double xSpeed = boostModifier * _speedAxis.get();
    double zRotation = -1 * _turnAxis.get();
    boolean spinInPlace = Math.abs(xSpeed) < _minSpeedToTurnInPlace;
    _drivetrain.curvatureDrive(xSpeed, zRotation, spinInPlace);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _drivetrain.tankDrive(0, 0);
  }

}
