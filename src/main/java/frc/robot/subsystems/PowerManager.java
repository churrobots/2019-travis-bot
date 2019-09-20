package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.SpeedTarget;

/**
 * Add your docs here.
 */
public class PowerManager extends Subsystem {

  PowerDistributionPanel _powerDistributionPanel;

  public PowerManager(RobotMap robotMap) {
    _powerDistributionPanel = robotMap.powerDistributionPanel;
  }

  public SpeedTarget getDrivetrainPowerAllocationTarget() {
    return new SpeedTarget(){
    
      @Override
      public double get() {
        if (_powerDistributionPanel.getVoltage() < 7.5) {
          return 0.5;
        } else {
          return 1.0;
        }
      }
    };
  }
  
  @Override
  public void initDefaultCommand() {
  }
}
