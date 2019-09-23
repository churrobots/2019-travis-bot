package frc.robot;

import java.lang.reflect.Field;

import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
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

    // TODO: confirm this outputs what we expect
    Shuffleboard.getTab("Subsystems").add(_drivetrain);
    Shuffleboard.getTab("Subsystems").add(_hatchPlacer);
    Shuffleboard.getTab("Subsystems").add(_cargoCannon);
    Shuffleboard.getTab("Subsystems").add(_cargoPicker);

    // TODO: confirm this outputs what we expect
    publishFieldsToShuffleboard("Maps", "RobotMap", robotMap);
    publishFieldsToShuffleboard("Maps", "StationMap", stationMap);

  }

  private void publishFieldsToShuffleboard(String shuffleBoardTabName, String objName, Object obj) {

    for (Field field : obj.getClass().getDeclaredFields()) {
      Object shuffleBoardValue = null;
      String shuffleBoardTitle = String.format("%s.%s", objName, field.getName());
      try {
        shuffleBoardValue = field.get(obj);
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } finally {
        Shuffleboard.getTab(shuffleBoardTabName).add(shuffleBoardTitle, shuffleBoardValue);
      }
    }
  
  }

  public void useAutonomousMode() {
    Shuffleboard.addEventMarker("useAutonomousMode", EventImportance.kNormal);
  }

  public void useTeleopMode() {

    Shuffleboard.addEventMarker("useTeleopMode", EventImportance.kNormal);

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
