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

    DriveForTime forwardALittleBit = new DriveForTime(drivetrain, 0.5, 0.5, 0.6);
    DriveForTime reverseALittleBit = new DriveForTime(drivetrain, -0.5, -0.5, 1.0);

    addSequential(forwardALittleBit);
    addSequential(new CloseBeak(hatchPlacer));
    addSequential(new PunchHatch(hatchPlacer));
    addSequential(reverseALittleBit);
    addSequential(new RetractPuncher(hatchPlacer));

  }
}
