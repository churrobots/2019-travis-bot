package frc.robot;

import frc.robot.commands.DriveAsTank;
import frc.robot.commands.RetractPuncher;
import frc.robot.commands.ScoreHatch;
import frc.robot.commands.PunchHatch;
import frc.robot.commands.ReceiveHatch;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HatchPlacer;
import frc.robot.subsystems.Cannon;
import frc.robot.tools.Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // TODO: send these in as DriverStation subsystem object
  private final Gamepad _driverGamepad;
  private final Gamepad _operatorGamepad;
  private final Drivetrain _drivetrain;
  private final HatchPlacer _hatchPlacer;
  private final Cannon _cannon;

  public OI(StationMap stationMap, RobotMap robotMap) {

    _driverGamepad = new Gamepad(stationMap.driverGamepadPort, stationMap.driverGamepadType);
    _operatorGamepad = new Gamepad(stationMap.operatorGamepadPort, stationMap.operatorGamepadType);

    _drivetrain = new Drivetrain(robotMap);
    _hatchPlacer = new HatchPlacer(robotMap);
    _cannon = new Cannon(robotMap);

  }

  public void useAutonomousMode() {
  }

  public void useTeleopMode() {

    _drivetrain.setDefaultCommand(new DriveAsTank(
      _drivetrain,
      _driverGamepad.leftYAxis,
      _driverGamepad.rightYAxis,
      _driverGamepad.rightAnalogTrigger
    ));

    _driverGamepad.leftBumper.whileHeld(new ReceiveHatch(_hatchPlacer));
    _driverGamepad.rightBumper.whenPressed(new ScoreHatch(_hatchPlacer, _drivetrain));

    _driverGamepad.buttonWest.whenPressed(new PunchHatch(_hatchPlacer));
    _driverGamepad.buttonWest.whenReleased(new RetractPuncher(_hatchPlacer));

    // _cannon.setDefaultCommand(new ManualShooting(_cannon, _operatorGamepad.rightAnalogTrigger,
    //     _operatorGamepad.leftAnalogTrigger, _operatorGamepad.rightYAxis, _powerManager.getShooterPowerAllocationTarget()));
  
  }

}
