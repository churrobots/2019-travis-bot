package frc.robot;

import frc.robot.commands.DriveAsTank;
import frc.robot.commands.LockDisc;
import frc.robot.commands.ManualShooting;
import frc.robot.commands.PunchIn;
import frc.robot.commands.PunchOut;
import frc.robot.commands.ReceiveDisc;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.PowerManager;
import frc.robot.subsystems.Shooter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // TODO: send these in as DriverStation subsystem object
  private final Gamepad _driverGamepad = new Gamepad(0);
  private final Gamepad _operatorGamepad = new Gamepad(1);
  private final Drivetrain _drivetrain;
  private final Hatch _hatch;
  private final Shooter _shooter;
  private final PowerManager _powerManager;

  public OI(Drivetrain drivetrain, Hatch hatch, PowerManager powerManager, Shooter shooter) {
    _drivetrain = drivetrain;
    _powerManager = powerManager;
    _hatch = hatch;
    _shooter = shooter;
  }

  public void useAutonomousMode() {
  }

  public void useTeleopMode() {

    _drivetrain.setDefaultCommand(new DriveAsTank(_drivetrain, _driverGamepad.leftYAxis, _driverGamepad.rightYAxis,
        _driverGamepad.rightAnalogTrigger, _powerManager.getDrivetrainPowerAllocationTarget()));

    _driverGamepad.buttonA.whenPressed(new ReceiveDisc(_hatch));
    _driverGamepad.buttonA.whenReleased(new LockDisc(_hatch));

    _driverGamepad.buttonX.whenPressed(new PunchOut(_hatch));
    _driverGamepad.buttonX.whenReleased(new PunchIn(_hatch));

    _shooter.setDefaultCommand(new ManualShooting(_shooter, _operatorGamepad.rightAnalogTrigger,
        _operatorGamepad.leftAnalogTrigger, _operatorGamepad.rightYAxis, _powerManager.getShooterPowerAllocationTarget()));
  
  }

}
