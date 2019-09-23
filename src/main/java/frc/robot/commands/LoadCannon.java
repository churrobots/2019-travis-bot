/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.Extender;

public class LoadCannon extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LoadCannon(Cannon cannon, Extender extender) {
    addSequential(new UnlockExtender(extender));
    addSequential(new FoldDown(extender));
    addSequential(new IntakeUntilCannonLoaded(cannon));
    addSequential(new FoldUp(extender));
    addSequential(new LockExtender(extender));
  }
}
