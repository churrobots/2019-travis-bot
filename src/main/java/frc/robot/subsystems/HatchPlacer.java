package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.RobotMap;
import frc.robot.commands.HoldHatch;

public class HatchPlacer extends Subsystem {

  private final DoubleSolenoid _beak;
  private final DoubleSolenoid _puncher;

  public HatchPlacer(RobotMap robotMap) {
    
    _beak = new DoubleSolenoid(
      robotMap.beakPCM,
      robotMap.beakDoubleSolenoidForwardChannel,
      robotMap.beakDoubleSolenoidReverseChannel
    );

    _puncher = new DoubleSolenoid(
      robotMap.puncherPCM,
      robotMap.puncherDoubleSolenoidForwardChannel,
      robotMap.puncherDoubleSolenoidReverseChannel
    );

    ShuffleboardTab tab = Shuffleboard.getTab("Subsystems");
    tab.add("HatchPlacer: Beak", _beak);
    tab.add("HatchPlacer: Puncher", _puncher);
  
  }

  public void openBeak() {
    _beak.set(Value.kReverse);
  }

  public void closeBeak() {
    _beak.set(Value.kForward);
  }

  public void punch() {
    _puncher.set(Value.kForward);
  }

  public void retractPuncher() {
    _puncher.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new HoldHatch(this));
  }
}
