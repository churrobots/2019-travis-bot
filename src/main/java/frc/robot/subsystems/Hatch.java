package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LockDisc;

public class Hatch extends Subsystem {

  public final DoubleSolenoid beak;
  public final DoubleSolenoid puncher;

  public Hatch(RobotMap robotMap) {
    beak = robotMap.beak;
    puncher = robotMap.puncher;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LockDisc(this));
  }
}
