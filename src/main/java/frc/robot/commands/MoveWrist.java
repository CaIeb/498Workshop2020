/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

public class MoveWrist extends CommandBase {
  private final Wrist wrist;
  private final WristPosition position;
  private double wristError;
  private boolean isDone;
  private final double kTolerance = 5;
  private final double SPEED = .8;
  /**
   * Creates a new MoveWrist.
   */
  public MoveWrist(Wrist wrist, WristPosition position) {
    this.wrist = wrist;
    this.position = position;
    addRequirements(wrist);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Wrist.isUp || Wrist.isDown) {
      isDone = true;
    }
    if(Wrist.getWristPosition < position) {
      wrist.set(SPEED);
    }
    if(Wrist.getWristPosition > position) {
      wrist.set(-SPEED);
    }
    wristError = position - Wrist.getWristPosition;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wrist.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(wristError) <= kTolerance || isDone;
  }
}
