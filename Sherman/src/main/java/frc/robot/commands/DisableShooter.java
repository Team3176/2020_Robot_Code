package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.ShooterConstants;
import frc.robot.subsystems.Shooter;

public class DisableShooter extends CommandBase {
  private Shooter m_Shooter = Shooter.getInstance();

  public DisableShooter() {
    addRequirements(m_Shooter);
  }

  @Override
  public void initialize() {
    m_Shooter.setFlywheelPercentControl(0);//THis may kill flywheel? Does it kill power or BRAKE the system?
    m_Shooter.setBoosterPercentControl(0);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.setFlywheelPercentControl(0);//THis may kill flywheel? Does it kill power or BRAKE the system?
    m_Shooter.setBoosterPercentControl(0);
  }

  @Override
  public boolean isFinished() {
    if(m_Shooter.getFlywheelSpeed()<=0){
      return true;//Spinning down the motor needs to be a separate command so it can come after the conveyor shoot
    }
    return false;
  }
}
