package frc.robot;

import frc.robot.commands.DriveAsTank;
import frc.robot.commands.EjectBall;
import frc.robot.commands.LoadCannon;
import frc.robot.commands.ScoreHatch;
import frc.robot.commands.ReceiveHatch;
import frc.robot.commands.ScoreBall;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Extender;
import frc.robot.subsystems.HatchPlacer;
import frc.robot.subsystems.Cannon;
import frc.robot.tools.Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private final Gamepad _driverGamepad;
  private final Gamepad _operatorGamepad;

  private final Drivetrain _drivetrain;
  private final HatchPlacer _hatchPlacer;
  private final Cannon _cannon;
  private final Extender _extender;

  public OI(StationMap stationMap, RobotMap robotMap) {

    _driverGamepad = new Gamepad(stationMap.driverGamepadPort, stationMap.driverGamepadType);
    _operatorGamepad = new Gamepad(stationMap.operatorGamepadPort, stationMap.operatorGamepadType);

    _drivetrain = new Drivetrain(robotMap);
    _hatchPlacer = new HatchPlacer(robotMap);
    _cannon = new Cannon(robotMap);
    _extender = new Extender(robotMap);

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

    _operatorGamepad.leftBumper.whileHeld(new LoadCannon(_cannon, _extender));
    _operatorGamepad.rightBumper.whenPressed(new ScoreBall(_cannon));
    _operatorGamepad.buttonWest.whileHeld(new EjectBall(_cannon));
  
  }

}
