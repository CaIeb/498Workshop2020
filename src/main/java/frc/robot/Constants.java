/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class DrivetrainConstants {
        public static final int kRTalon1ID = 1;
        public static final int kRTalon2ID = 2;
        public static final int kRTalon3ID = 3;
        public static final int kLTalon1ID = 4;
        public static final int kLTalon2ID = 5;
        public static final int kLTalon3ID = 6;
    }
    public final class TrajectoryConstants {
        public static final int kSensorUnitsPerRotation = 8192;
        public static final int kPrimaryPIDSlot = 1;
    }
    public final class WristCostants {
        public static final int kWristMotorID = 7;
        public static final int kEncoderAID = 0;
        public static final int kEncoderBID = 1;
        public static final int kUpSensorID = 2;
        public static final int kDownSensorID = 3;
    }
    public final class ShooterConstants {
        public static final int kShooterMotorID = 8;
        public static final int kAlignMotorID = 9;
        public static final int kPositionEncoderAID = 4;
        public static final int kPositionEncoderBID = 5;
    }
}
