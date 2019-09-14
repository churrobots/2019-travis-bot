/*
Learning from Space Cookies:

3 motors eachside
power control (no brownouts)
classes(organize)
using constants to name all our ports

USB-A upload for robot at competition (no wifi)

*/

// Import all of our WPI libraries for robot control.
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Robot extends TimedRobot {

  // Mechanical model.
  private final DoubleSolenoid hook = new DoubleSolenoid(0,1);
  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(
    new Talon(4),
    new PWMVictorSPX(0),
    new PWMVictorSPX(1)
  );
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(
    new Talon(1),
    new PWMVictorSPX(2),
    new PWMVictorSPX(3)
  );
  private final DifferentialDrive travisDrive = new DifferentialDrive(leftMotors, rightMotors);
  private final PowerDistributionPanel powerDistributionPanel = new PowerDistributionPanel();

  // Controller model.
  private final Joystick driverGamepad = new Joystick(0);
  private final Joystick operatorGamepad = new Joystick(1);
  private final int buttonA = 1;
  private final int buttonB = 2;
  private final int buttonX = 3;
  private final int buttonY = 4;
  private final int leftJoystickYAxis = 1;
  private final int rightJoystickYAxis = 5;
  private final int leftAnalogTrigger = 2;
  private final int rightAnalogTrigger = 3;

  // Other variables.
  private final Timer globalTimer = new Timer();

  private void startCamera() {
    var camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(320, 240);
    camera.setFPS(25);
  }

  private double getBrownoutModifer() {
   double voltage = powerDistributionPanel.getVoltage();
   if (voltage>7.5){
     return 1.00;
    
   }
   if (voltage>6.5){
     return 0.75;
   }
   return 0.20;

  }
//harambe lmfao

  @Override
  public void robotInit() {
    // this.startCamera();
    this.globalTimer.reset();
    this.globalTimer.start();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }


  @Override
  public void teleopPeriodic() {
    double leftSpeed = -driverGamepad.getRawAxis(leftJoystickYAxis);
    double rightSpeed = -driverGamepad.getRawAxis(rightJoystickYAxis);
    double boost = driverGamepad.getRawAxis(rightAnalogTrigger);
    double brownoutModifier = this.getBrownoutModifer();
    double minSpeed = 0.50 * brownoutModifier;
    double maxSpeed = 1.00 * brownoutModifier;
    double speedModifier = minSpeed + boost * (maxSpeed - minSpeed);
    travisDrive.tankDrive(speedModifier * leftSpeed, speedModifier * rightSpeed);
  }

  @Override
  public void testPeriodic() {
  }

}
