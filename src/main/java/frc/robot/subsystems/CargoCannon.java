/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.RobotMap;
import frc.robot.commands.ShutdownCannon;

/**
 * Add your docs here.
 */
public class CargoCannon extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final SpeedController _conveyor;
  private final SpeedController _flywheel;
  private final Solenoid _hook;
  private final DoubleSolenoid _wrist;
  private final DigitalInput _ballSensor;
  private final double _defaultConveyorSpeed = 0.40;
  private final double _defaultFlywheelSpeed = 0.90;

  public CargoCannon(RobotMap robotMap) {

    _conveyor = new PWMVictorSPX(robotMap.conveyorVictorPWM);
    _flywheel = new PWMVictorSPX(robotMap.flywheelVictorPWM);

    _hook = new Solenoid(robotMap.hookPCM, robotMap.hookSolenoidChannel);
    _wrist = new DoubleSolenoid(robotMap.wristPCM, robotMap.wristDoubleSolenoidForwardChannel, robotMap.wristDoubleSolenoidReverseChannel);

    _ballSensor = new DigitalInput(robotMap.ballSensorDIO);

    ShuffleboardTab tab = Shuffleboard.getTab("Subsystems");
    tab.add("CargoCannon: Light Sensor", _ballSensor);
    tab.add("CargoCannon: Hook", _hook);
    tab.add("CargoCannon: Wrist", _wrist);

    // TODO: add shuffleboard indicators for other components (e.g. motor speed)

  }

  public void runConveyorIntake() {
    _conveyor.set(_defaultConveyorSpeed);
  }

  public void runConveyorEject() {
    _conveyor.set(-1 * _defaultConveyorSpeed);
  }

  public void stopConveyor() {
    _conveyor.set(0);
  }

  public void runFlywheel() {
    _flywheel.set(_defaultFlywheelSpeed);
  }

  public void stopFlywheel() {
    _flywheel.set(0);
  }

  public boolean hasCargoInHoldingArea() {
    return _ballSensor.get();
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
    setDefaultCommand(new ShutdownCannon(this));
  }
}
