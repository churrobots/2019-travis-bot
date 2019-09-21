/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.SpeedTarget;
import frc.robot.subsystems.Shooter;

public class ManualShooting extends Command {
  private Shooter _shooter;
  private SpeedTarget _conveyorSpeed;
  private SpeedTarget _flywheelSpeed;
  private SpeedTarget _powerAllocation;
  private SpeedTarget _reverser;
  
  public ManualShooting(Shooter shooter, SpeedTarget conveyorSpeed, SpeedTarget flywheelSpeed, SpeedTarget reverser, SpeedTarget powerAllocation) {
    requires(shooter);
    _shooter = shooter;
    _conveyorSpeed = conveyorSpeed;
    _flywheelSpeed = flywheelSpeed;
    _powerAllocation = powerAllocation;
    _reverser = reverser;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    _shooter.flywheel.set(_flywheelSpeed.get());
    double reverseValue = Math.abs(_reverser.get());
    double conveyorSpeed = _conveyorSpeed.get();
    System.out.println(String.format("reverse value is : %s", reverseValue));
    if (reverseValue > 0.1) {
      conveyorSpeed = -reverseValue;
    }
    _shooter.conveyor.set(conveyorSpeed * _powerAllocation.get());
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
