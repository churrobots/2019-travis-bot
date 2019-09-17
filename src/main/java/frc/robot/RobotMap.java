package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class RobotMap {

  public final WPI_TalonSRX rightDriveMotorTalon = new WPI_TalonSRX(1);
  public final WPI_VictorSPX rightDriveMotorVictorA = new WPI_VictorSPX(2);
  public final WPI_VictorSPX rightDriveMotorVictorB = new WPI_VictorSPX(3);
  public final SpeedControllerGroup rightDriveMotors = new SpeedControllerGroup(rightDriveMotorTalon, rightDriveMotorVictorA, rightDriveMotorVictorB);

  public final WPI_TalonSRX leftDriveMotorTalon = new WPI_TalonSRX(4);
  public final WPI_VictorSPX leftDriveMotorVictorA = new WPI_VictorSPX(5);
  public final WPI_VictorSPX leftDriveMotorVictorB = new WPI_VictorSPX(6);
  public final SpeedControllerGroup leftDriveMotors = new SpeedControllerGroup(leftDriveMotorTalon, leftDriveMotorVictorA, leftDriveMotorVictorB);

  public final PWMVictorSPX flywheel = new PWMVictorSPX(0);
  public final PWMVictorSPX conveyor = new PWMVictorSPX(1);

  public final DoubleSolenoid beak = new DoubleSolenoid(0, 0, 3);
  public final DoubleSolenoid puncher = new DoubleSolenoid(0, 6, 4);

  public final DoubleSolenoid wrist = new DoubleSolenoid(0, 5, 2);
  public final Solenoid hook = new Solenoid(1, 1);

  public final PowerDistributionPanel powerDistributionPanel = new PowerDistributionPanel();
  public final Compressor compressor = new Compressor();
  public final CameraServer cameraServer = CameraServer.getInstance();

}
