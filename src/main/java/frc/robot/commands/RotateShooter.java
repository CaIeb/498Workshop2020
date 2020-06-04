/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Shooter;

public class RotateShooter extends CommandBase {
  private double kTolerance = 10;
  private double kSpeed = .9;
  private boolean isDone = false;
  private final Shooter shooter;
  private final double position;
  /**
   * Creates a new RotateShooter.
   */
  public RotateShooter(Shooter shooter, double position) {
    this.shooter = shooter;
    this.position = position;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error = position - shooter.getPosition();
    if(error > kTolerance) {
      shooter.rotate(kSpeed);
    }
    if (error < kTolerance) {
      shooter.rotate(-kSpeed);
    }
    if (Math.abs(error) < kTolerance) {
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.rotate(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
