package frc.robot;

import frc.robot.commands.DriveAsTank;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.PowerManager;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // TODO: send these in as DriverStation subsystem object
  private final Gamepad _driverGamepad = new Gamepad(0);
  private final Gamepad _operatorGamepad = new Gamepad(1);
  private final Drivetrain _drivetrain;
  private final PowerManager _powerManager;

  public OI(Drivetrain drivetrain, PowerManager powerManager) {
    _drivetrain = drivetrain;
    _powerManager = powerManager;
  }

  public void useAutonomousMode() {
  }

  public void useTeleopMode() {
    _drivetrain.setDefaultCommand(new DriveAsTank(_drivetrain, _driverGamepad.leftYAxis, _driverGamepad.rightYAxis,
        _driverGamepad.rightAnalogTrigger, _powerManager.getDrivetrainPowerAllocationTarget()));
    // drivetrain.setDefaultCommand(new DriveAsTankWithBooster(drivetrain,
    // driverLeftYAxis, driverRightYAxis, driverRightAnalogTrigger));
    // Shooter shooter = new Shooter(robotMap.conveyor, robotMap.flywheel,
    // robotMap.hook);
    // operatorButtonX.whenPressed(new PickUpBall(shooter));
    // operatorButtonX.whenReleased(new FoldShooter(shooter));
    // operatorButtonA.whenPressed(new ShootBall(shooter));
  }

}
