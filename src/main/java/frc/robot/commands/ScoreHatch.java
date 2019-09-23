/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.HatchPlacer;
import frc.robot.subsystems.Drivetrain;

public class ScoreHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ScoreHatch(HatchPlacer hatchPlacer, Drivetrain drivetrain) {

    // Move forward while ejecting the hatch to get a solid attachment.
    addParallel(new DriveForTime(drivetrain, 0.5, 0.5, 0.6));
    addSequential(new EjectHatch(hatchPlacer));

    // Move reverse while still ejecting the hatch to cleanly separate from the
    // hatch before allowing the Hatch Placer to return to default position.
    addParallel(new DriveForTime(drivetrain, -0.5, -0.5, 1.0));
    addSequential(new EjectHatch(hatchPlacer));

  }
}
