/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Extender extends Subsystem {

  private final Solenoid _hook;
  private final DoubleSolenoid _wrist;

  public Extender(RobotMap robotMap) {

    _hook = new Solenoid(robotMap.hookPCM, robotMap.hookSolenoidChannel);

    _wrist = new DoubleSolenoid(
      robotMap.wristPCM,
      robotMap.wristDoubleSolenoidForwardChannel,
      robotMap.wristDoubleSolenoidReverseChannel
    );

  }

  public void foldDown() {
    _wrist.set(Value.kForward);
  }

  public void foldUp() {
    _wrist.set(Value.kReverse);
  }

  public void lock() {
    _hook.set(false);
  }

  public void unlock() {
    _hook.set(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
