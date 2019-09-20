package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {

  private DoubleSolenoid _beak;
  private DoubleSolenoid _puncher;

  public Hatch(RobotMap robotMap) {
    _beak = robotMap.beak;
    _puncher = robotMap.puncher;
  }

  @Override
  public void initDefaultCommand() {
    // return new LockDisc(this);
  }
}
