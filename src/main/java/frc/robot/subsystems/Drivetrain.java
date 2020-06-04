/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends PIDSubsystem {
  private static PIDController driveController = new PIDController(0.0, 0.0, 0.0);
  private TalonSRX mRTalon1 = new TalonSRX(DrivetrainConstants.kRTalon1ID);
  private TalonSRX mRTalon2 = new TalonSRX(DrivetrainConstants.kRTalon2ID);
  private TalonSRX mRTalon3 = new TalonSRX(DrivetrainConstants.kRTalon3ID);
  private TalonSRX mLTalon1 = new TalonSRX(DrivetrainConstants.kLTalon1ID);
  private TalonSRX mLTalon2 = new TalonSRX(DrivetrainConstants.kLTalon2ID);
  private TalonSRX mLTalon3 = new TalonSRX(DrivetrainConstants.kLTalon3ID);
  private PigeonIMU pigeon = new PigeonIMU(mLTalon1);

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    super(driveController);
    driveController.setTolerance(.05, 10);
    configTalon(mRTalon1, true, true);
    configTalon(mRTalon2, true, false);
    configTalon(mRTalon3, true, false);
    configTalon(mLTalon1, false, true);
    configTalon(mLTalon2, false, false);
    configTalon(mLTalon3, false, false);
  }

  private void configTalon(TalonSRX motor, boolean isRight, boolean isMaster) {
    motor.configFactoryDefault();
    motor.setNeutralMode(NeutralMode.Brake);
    motor.setInverted(isRight);
    if(isRight && !isMaster) {
      motor.set(ControlMode.Follower, DrivetrainConstants.kRTalon1ID);
    }
    if(!isRight && !isMaster) {
      motor.set(ControlMode.Follower, DrivetrainConstants.kLTalon1ID);
    }
    if(isMaster) {
      motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    }
  }

  public void arcadeDrive(double throttle, double rotation) {
    double rightSpeed = throttle - rotation;
    double leftSpeed = throttle + rotation;
    mRTalon1.set(ControlMode.PercentOutput, rightSpeed);
    mLTalon1.set(ControlMode.PercentOutput, leftSpeed);
  }

  public void stop() {
    mRTalon1.set(ControlMode.PercentOutput, 0);
    mLTalon1.set(ControlMode.PercentOutput, 0);
  }
  public void directDrive(double velocity) {
    mRTalon1.configMotionProfileTrajectoryPeriod(10);
    mLTalon1.configMotionProfileTrajectoryPeriod(10);
    mRTalon1.set(ControlMode.Velocity, velocity);
    mLTalon1.set(ControlMode.Velocity, velocity);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void useOutput(double output, double setpoint) {

  }

  @Override
  protected double getMeasurement() {
    return 0;
  }
}
