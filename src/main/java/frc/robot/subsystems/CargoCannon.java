/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class CargoCannon extends Subsystem {
  private final DigitalInput _ballSensor;
  private final Solenoid _hook;
  private final DoubleSolenoid _wrist;






  public CargoCannon(RobotMap robotMap) {
    _hook = new Solenoid(robotMap.hookPCM, robotMap.hookSolenoidChannel);
    _ballSensor = new DigitalInput(robotMap.ballSensorDIO);
    _wrist = new DoubleSolenoid(robotMap.wristDoubleSolenoidForwardChannel, robotMap.wristDoubleSolenoidReverseChannel);

  }

  @Override
  public void initDefaultCommand(){
   
  }
  public boolean hasCargoInCannon(){
    return _ballSensor.get();
  } 
  public void releaseHook(){
    _hook.set(true);
  }
  public void retractHook(){
    _hook.set(false);
  }
  public void lowerConveyor(){
    _wrist
  }
  

}
