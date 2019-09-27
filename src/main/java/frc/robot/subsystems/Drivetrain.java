package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.StopDriving;

public class Drivetrain extends Subsystem {

  private final DifferentialDrive _differentialDrive;
  private final WPI_TalonSRX _leftTalonMotor;
  private final WPI_TalonSRX _rightTalonMotor;
  private int _mostRecentLeftRotations = 0;
  private int _mostRecentRightRotations = 0;
  private int _allowableEncoderPositionRange = 5;

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

  public void tankDriveByRotations(int leftRotations, int rightRotations) {

    // https://seamonsters-2605.github.io/docs/reference/#using-encoders

    _mostRecentLeftRotations = leftRotations;
    _leftTalonMotor.setSelectedSensorPosition(0);
    _leftTalonMotor.set(ControlMode.Position, leftRotations);

    _mostRecentRightRotations = rightRotations;
    _rightTalonMotor.setSelectedSensorPosition(0);
    _rightTalonMotor.set(ControlMode.Position, rightRotations);

  }

  public boolean hasCompletedMostRecentRotations() {
    int deltaLeft = Math.abs(_leftTalonMotor.getSelectedSensorPosition() - _mostRecentLeftRotations);
    int deltaRight = Math.abs(_rightTalonMotor.getSelectedSensorPosition() - _mostRecentRightRotations);
    if (deltaLeft < _allowableEncoderPositionRange && deltaRight < _allowableEncoderPositionRange) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopDriving(this));
  }
}
