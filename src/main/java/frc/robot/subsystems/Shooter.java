/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  private final TalonSRX mShooterMotor = new TalonSRX(ShooterConstants.kShooterMotorID);
  private final TalonSRX mAlignMotor = new TalonSRX(ShooterConstants.kAlignMotorID);
  private final Encoder mPositionEncoder = new Encoder(ShooterConstants.kPositionEncoderAID, ShooterConstants.kPositionEncoderBID);
  public Shooter() {
 
  }
  public void shoot(double speed) {
    mShooterMotor.set(ControlMode.PercentOutput, speed);
  }
  public void stop() {
    mShooterMotor.set(ControlMode.PercentOutput, 0);
  }
  public void rotate(double speed) {
    mAlignMotor.set(ControlMode.PercentOutput, speed);
  }
  public double getPosition() {
    return mPositionEncoder.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
