package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.PowerManager;
import frc.robot.subsystems.Shooter;

public class Robot extends TimedRobot {

  private Drivetrain _drivetrain;
  private Hatch _hatch;
  private PowerManager _powerManager;
  private Shooter _shooter;
  private OI _oi;

  @Override
  public void robotInit() {
    RobotMap robotMap = new RobotMap();
    _drivetrain = new Drivetrain(robotMap);
    _hatch = new Hatch(robotMap);
    _powerManager = new PowerManager(robotMap);
    _shooter = new Shooter(robotMap);
    _oi = new OI(_drivetrain, _hatch, _powerManager, _shooter);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    _oi.useAutonomousMode();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    _oi.useTeleopMode();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
  
}
