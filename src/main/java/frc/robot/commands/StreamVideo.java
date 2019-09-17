package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Vision;

public class StreamVideo extends Command {

  private Vision _vision;

  public StreamVideo(Vision vision) {
    requires(vision);
    _vision = vision;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    _vision.startStreaming();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    _vision.stopStreaming();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
