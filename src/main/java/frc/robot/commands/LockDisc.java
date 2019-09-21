package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hatch;

public class LockDisc extends Command {

  private Hatch _hatch;

  public LockDisc(Hatch hatch) {
    requires(hatch);
    _hatch = hatch;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _hatch.beak.set(Value.kForward);
    _hatch.puncher.set(Value.kForward);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
