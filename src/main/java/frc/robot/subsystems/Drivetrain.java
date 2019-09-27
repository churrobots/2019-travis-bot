package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.StopDriving;

public class Drivetrain extends Subsystem {

  private final DifferentialDrive _differentialDrive;
  private final WPI_TalonSRX _leftTalonMotor;
  private final WPI_TalonSRX _rightTalonMotor;

  public Drivetrain(RobotMap robotMap) {

    WPI_VictorSPX leftVictorMotor1 = new WPI_VictorSPX(robotMap.leftVictorMotor1CAN);
    WPI_VictorSPX leftVictorMotor2 = new WPI_VictorSPX(robotMap.leftVictorMotor2CAN);
    _leftTalonMotor = new WPI_TalonSRX(robotMap.leftTalonMotorCAN);
    _leftTalonMotor.setInverted(true);
    leftVictorMotor1.follow(_leftTalonMotor);
    leftVictorMotor2.follow(_leftTalonMotor);

    WPI_VictorSPX rightVictorMotor1 = new WPI_VictorSPX(robotMap.rightVictorMotor1CAN);
    WPI_VictorSPX rightVictorMotor2 = new WPI_VictorSPX(robotMap.rightVictorMotor2CAN);
    _rightTalonMotor = new WPI_TalonSRX(robotMap.rightTalonMotorCAN);
    _rightTalonMotor.setInverted(true);
    rightVictorMotor1.follow(_rightTalonMotor);
    rightVictorMotor2.follow(_rightTalonMotor);

    _differentialDrive = new DifferentialDrive(_leftTalonMotor, _rightTalonMotor);

    // TODO: add shuffleboard indicators for motor speed and encoder positions
    // https://seamonsters-2605.github.io/docs/reference/#using-encoders
  
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    _differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void tankDriveByRotations(double leftRotations, double rightRotations) {
    // https://seamonsters-2605.github.io/docs/reference/#using-encoders
    _leftTalonMotor.set(ControlMode.Position, leftRotations);
    _rightTalonMotor.set(ControlMode.Position, rightRotations);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopDriving(this));
  }
}
