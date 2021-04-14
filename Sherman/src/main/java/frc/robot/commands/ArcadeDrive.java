package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase {
  private Drivetrain m_Drivetrain = Drivetrain.getInstance();
  private DoubleSupplier xSpeed;
  private DoubleSupplier rotSpeed;
  private BooleanSupplier shift;

  public ArcadeDrive(DoubleSupplier xSpeed, DoubleSupplier rotSpeed, BooleanSupplier shift) {
    this.xSpeed = xSpeed;
    this.rotSpeed = rotSpeed;
    this.shift = shift;
    addRequirements(m_Drivetrain);
  }

  @Override
  public void execute() {
    // Calls the universal drive function of Drivetrain and passes it a ChassisSpeeds object that has been created with the desired linear and rotational speeds
    m_Drivetrain.drive(new ChassisSpeeds(xSpeed.getAsDouble(), 0.0, rotSpeed.getAsDouble()));
    if (shift.getAsBoolean()) {
      m_Drivetrain.shift();
    }
  }
}
