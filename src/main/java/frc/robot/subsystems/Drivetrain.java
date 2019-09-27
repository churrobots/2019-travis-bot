package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.RobotMap;
import frc.robot.commands.StopDriving;

public class Drivetrain extends Subsystem {

  private final DifferentialDrive _differentialDrive;

  public Drivetrain(RobotMap robotMap) {

    SpeedController leftMotors = new SpeedControllerGroup(
      new WPI_TalonSRX(robotMap.leftTalonMotorCAN),
      new WPI_VictorSPX(robotMap.leftVictorMotor1CAN),
      new WPI_VictorSPX(robotMap.leftVictorMotor2CAN)
    );

    SpeedController rightMotors = new SpeedControllerGroup(
      new WPI_TalonSRX(robotMap.rightTalonMotorCAN),
      new WPI_VictorSPX(robotMap.rightVictorMotor1CAN),
      new WPI_VictorSPX(robotMap.rightVictorMotor2CAN)
    );

    leftMotors.setInverted(true);
    rightMotors.setInverted(true);

    // TODO: confirm this outputs what we expect
    // Shuffleboard.getTab("Subsystems").add("Drivetrain.LeftMotors", leftMotors);
    // Shuffleboard.getTab("Subsystems").add("Drivetrain.RightMotors", leftMotors);

    _differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    _differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopDriving(this));
  }
}
