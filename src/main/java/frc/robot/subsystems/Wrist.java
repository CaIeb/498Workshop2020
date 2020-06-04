/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  public enum WristPosition {
    Up(1000), 
    Score(800), 
    Load(600), 
    Down(0);
    public double position;
    private WristPosition(double position) {
      this.position = position;
    }
  }
  private final TalonSRX mWristMotor = new TalonSRX(WristConstants.kWristMotorID);
  private final Encoder mEncoder = new Encoder(WristConstants.kEncoderAID, WristConstants.kEncoderBID, false);
  private final DigitalInput mUpSensor = new DigitalInput(WristConstants.kUpSensorID);
  private final DigitalInput mDownSensor = new DigitalInput(WristConstants.kDownSensorID);
  /**
   * Creates a new Wrist.
   */
  public Wrist() {
    mWristMotor.configFactoryDefault();
  }

  public void set(double speed) {
    mWristMotor.set(ControlMode.PercentOutput, speed);
  }
  public void stop() {
    mWristMotor.set(ControlMode.PercentOutput, 0);
  }

  public double getWristPosition() {
    mEncoder.get();
  }
  public boolean isUp() {
    mUpSensor.get();
  }
  public boolean isDown() {
    mDownSensor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
