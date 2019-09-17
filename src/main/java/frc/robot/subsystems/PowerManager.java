package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PowerManager extends Subsystem {

  PowerDistributionPanel _powerDistributionPanel;

  public PowerManager(PowerDistributionPanel powerDistributionPanel) {
    _powerDistributionPanel = powerDistributionPanel;
  }

  public double getDrivetrainPowerAllowance() {
    if (_powerDistributionPanel.getVoltage() < 7.5) {
      return 0.5;
    } else {
      return 1.0;
    }
  }
  
  @Override
  public void initDefaultCommand() {
  }
}
