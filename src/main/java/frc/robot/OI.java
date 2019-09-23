package frc.robot;

import frc.robot.commands.DriveAsTank;
import frc.robot.commands.EjectCargo;
import frc.robot.commands.EjectHatch;
import frc.robot.commands.LoadCargo;
import frc.robot.commands.ScoreHatch;
import frc.robot.commands.LoadHatch;
import frc.robot.commands.ScoreCargo;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.CargoPicker;
import frc.robot.subsystems.HatchPlacer;
import frc.robot.subsystems.CargoCannon;
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
  private final CargoCannon _cargoCannon;
  private final CargoPicker _cargoPicker;

  public OI(StationMap stationMap, RobotMap robotMap) {

    _driverGamepad = new Gamepad(stationMap.driverGamepadPort, stationMap.driverGamepadType);
    _operatorGamepad = new Gamepad(stationMap.operatorGamepadPort, stationMap.operatorGamepadType);

    _drivetrain = new Drivetrain(robotMap);
    _hatchPlacer = new HatchPlacer(robotMap);
    _cargoCannon = new CargoCannon(robotMap);
    _cargoPicker = new CargoPicker(robotMap);

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

    _driverGamepad.leftBumper.whileHeld(new LoadHatch(_hatchPlacer));
    _driverGamepad.rightBumper.whenPressed(new ScoreHatch(_hatchPlacer, _drivetrain));
    _driverGamepad.buttonWest.whenPressed(new EjectHatch(_hatchPlacer));

    _operatorGamepad.leftBumper.whileHeld(new LoadCargo(_cargoCannon, _cargoPicker));
    _operatorGamepad.rightBumper.whenPressed(new ScoreCargo(_cargoCannon));
    _operatorGamepad.buttonWest.whenPressed(new EjectCargo(_cargoCannon));
  
  }

}
