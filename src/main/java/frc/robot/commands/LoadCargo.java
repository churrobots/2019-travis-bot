/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.CargoCannon;
import frc.robot.subsystems.CargoPicker;

public class LoadCargo extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LoadCargo(CargoCannon cargoCannon, CargoPicker cargoPicker) {
    addSequential(new UnlockExtender(cargoPicker));
    addParallel(new FoldDown(cargoPicker));
    addSequential(new IntakeUntilCargoReachesHoldingArea(cargoCannon));
    addSequential(new FoldUp(cargoPicker));
    addSequential(new LockExtender(cargoPicker));
  }
}
