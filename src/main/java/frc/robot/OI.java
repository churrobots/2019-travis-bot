package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveAsTankWithBooster;
import frc.robot.commands.StreamVideo;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.PowerManager;
import frc.robot.subsystems.Vision;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static void connect(RobotMap robotMap) {

    Joystick driverGamepad = new Joystick(0);
    Joystick operatorGamepad = new Joystick(1);

    Button driverButtonA = new JoystickButton(driverGamepad, 1);
    Button driverButtonB = new JoystickButton(driverGamepad, 2);
    Button driverButtonC = new JoystickButton(driverGamepad, 3);
    Button driverButtonD = new JoystickButton(driverGamepad, 4);

    Button operatorButtonA = new JoystickButton(operatorGamepad, 1);
    Button operatorButtonB = new JoystickButton(operatorGamepad, 2);
    Button operatorButtonC = new JoystickButton(operatorGamepad, 3);
    Button operatorButtonD = new JoystickButton(operatorGamepad, 4);

    Axis driverLeftYAxis = new Axis(driverGamepad, 1);
    Axis driverRightYAxis = new Axis(driverGamepad, 5);
    Axis driverLeftAnalogTrigger = new Axis(driverGamepad, 2);
    Axis driverRightAnalogTrigger = new Axis(driverGamepad, 3);

    Vision vision = new Vision(robotMap.cameraServer);
    vision.setDefaultCommand(new StreamVideo(vision));

    PowerManager powerManager = new PowerManager(robotMap.powerDistributionPanel);
    Drivetrain drivetrain = new Drivetrain(robotMap.leftDriveMotors, robotMap.rightDriveMotors, powerManager);
    drivetrain.setDefaultCommand(new DriveAsTankWithBooster(drivetrain, driverLeftYAxis, driverRightYAxis, driverRightAnalogTrigger));

    // Shooter shooter = new Shooter(robotMap.conveyor, robotMap.flywheel, robotMap.hook);
    // operatorButtonX.whenPressed(new PickUpBall(shooter));
    // operatorButtonX.whenReleased(new FoldShooter(shooter));
    // operatorButtonA.whenPressed(new ShootBall(shooter));

  }

  private static class Axis implements SpeedTarget {

    private Joystick _gamepad;
    private int _axis;

    Axis(Joystick gamepad, int axis) {
      _gamepad = gamepad;
      _axis = axis;
    }

    public double get() {
      return _gamepad.getRawAxis(_axis);
    }

  }

}
