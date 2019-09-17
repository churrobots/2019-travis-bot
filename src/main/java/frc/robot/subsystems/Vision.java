package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.StreamVideo;

public class Vision extends Subsystem {

  private CameraServer _cameraServer;

  public Vision(CameraServer cameraServer) {
    _cameraServer = cameraServer;
  }

  public void startStreaming() {
    UsbCamera _camera = _cameraServer.startAutomaticCapture();
    _camera.setResolution(320, 240);
    _camera.setFPS(25);
  }

  public void stopStreaming() {
    System.out.println("cannot stop streaming yet");
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StreamVideo(this));
  }
}
