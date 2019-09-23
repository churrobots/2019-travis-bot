/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.StopCannon;

/**
 * Add your docs here.
 */
public class Cannon extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private SpeedController _conveyor;
  private SpeedController _flywheel;

  public Cannon(RobotMap robotMap) {
    _conveyor = new WPI_VictorSPX(robotMap.conveyorVictorPWM);
    _flywheel = new WPI_VictorSPX(robotMap.flywheelVictorPWM);
  }

  public void startConveyor() {
    _conveyor.set(0.75);
  }

  public void stopConveyor() {
    _conveyor.set(0);
  }

  public void startFlywheel() {
    _flywheel.set(1.0);
  }

  public void stopFlywheel() {
    _flywheel.set(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopCannon(this));
  }
}
