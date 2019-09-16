package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  OI() {
    RobotMap robotMap = new RobotMap();
    // driverButtonA.whileHeld(new IntakeBall(robotMap.));
  }
  
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

  double getDriverLeftYAxis() {
    return driverGamepad.getRawAxis(1);
  }

  double getDriverRightYAxis() {
    return driverGamepad.getRawAxis(5);
  }

  double getDriverLeftAnalogTrigger() {
    return driverGamepad.getRawAxis(2);
  }

  double getDriverRightAnalogTrigger() {
    return driverGamepad.getRawAxis(3);
  }

}
