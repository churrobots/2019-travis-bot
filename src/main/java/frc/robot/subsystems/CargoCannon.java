/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.RobotMap;
import frc.robot.commands.ShutdownCannon;

/**
 * Add your docs here.
 */
public class CargoCannon extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private SpeedController _conveyor;
  private SpeedController _flywheel;
  private DigitalInput _ballSensor;
  private final Solenoid _hook;
  private final DoubleSolenoid _wrist;

  public CargoCannon(RobotMap robotMap) {
    _conveyor = new PWMVictorSPX(robotMap.conveyorVictorPWM);
    _flywheel = new PWMVictorSPX(robotMap.flywheelVictorPWM);
    _ballSensor = new DigitalInput(robotMap.ballSensorDIO);

    _hook = new Solenoid(robotMap.hookPCM, robotMap.hookSolenoidChannel);

    _wrist = new DoubleSolenoid(robotMap.wristPCM, robotMap.wristDoubleSolenoidForwardChannel,
        robotMap.wristDoubleSolenoidReverseChannel);
    Shuffleboard.getTab("Subsystems").add("Light Sensor", _ballSensor);
  }

  public void setConveyor(double x) {
    _conveyor.set(x);
  }

  public void setFlywheel(double x) {
    _flywheel.set(x);
  }

  public void startConveyorIntake() {
    _conveyor.set(0.75);
  }

  public void startConveyorEject() {
    _conveyor.set(-0.75);
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
