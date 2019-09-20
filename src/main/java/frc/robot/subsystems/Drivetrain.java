package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.StopDriving;

public class Drivetrain extends Subsystem {

  private DifferentialDrive _differentialDrive;

  public Drivetrain(RobotMap robotMap) {

    SpeedController leftMotors = new SpeedControllerGroup(robotMap.leftTalonMotor, robotMap.leftVictorMotorA,
        robotMap.leftVictorMotorB);
    SpeedController rightMotors = new SpeedControllerGroup(robotMap.rightTalonMotor, robotMap.rightVictorMotorA,
        robotMap.rightVictorMotorB);

    leftMotors.setInverted(true);
    rightMotors.setInverted(true);

    _differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  
  }

  public void driveAsTank(double leftSpeed, double rightSpeed) {
    _differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopDriving(this));
  }
}
