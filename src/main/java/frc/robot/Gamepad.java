package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

class Gamepad {

  public final Button buttonA;
  public final Button buttonB;
  public final Button buttonX;
  public final Button buttonY;
  public final Axis leftYAxis;
  public final Axis rightYAxis;
  public final Axis leftAnalogTrigger;
  public final Axis rightAnalogTrigger;
  // TODO: add other axes
  // TODO: implement as a factory for other controllers to be plugged in
  private final Joystick _gamepad;

  public Gamepad(int driverStationPort) {

    _gamepad = new Joystick(driverStationPort);

    buttonA = new JoystickButton(_gamepad, 1);
    buttonB = new JoystickButton(_gamepad, 2);
    buttonX = new JoystickButton(_gamepad, 3);
    buttonY = new JoystickButton(_gamepad, 4);

    leftYAxis = new Axis(_gamepad, 1);
    rightYAxis = new Axis(_gamepad, 5);
    leftAnalogTrigger = new Axis(_gamepad, 2);
    rightAnalogTrigger = new Axis(_gamepad, 3);

  }

  public static final class Axis implements SpeedTarget {

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