# Getting Started

1. Make sure you can run the development environment.

    * If you have a Mac: [Install Docker Desktop for macOS](https://download.docker.com/mac/stable/Docker.dmg)
    * If you have a PC: [Install Docker Desktop for Windows](https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe)
    * [Install VSCode](https://code.visualstudio.com/download)
    * Open VSCode → Click View...Extensions → Search for "Remote Development" → Click "Install"

2. Make sure you can collaborate using Github.

    * [Create a Github account](https://github.com/join) if you don't have one
    * [Install Github Desktop](https://desktop.github.com/) or commandline if you prefer
    * [Request to join our Github Organization](https://github.com/orgs/epa-robotics)
    * [Clone the robot code](https://github.com/epa-robotics/travis-bot) using the green button

3. **You're ready to code! Every time you want to edit/build/deploy to the robot, just**:

    * Open the robot code in VSCode
    * If VSCode shows a popup in the bottom-right → Click "Reopen in Container"
    * **To build:** Click the "W" icon in the upper-right → "WPILib: Build Robot Code"
    * **To deploy:** Click the "W" icon in the upper-right → "WPILib: Deploy Robot Code"
        * _Note: you need to be connected to the robot's wifi radio to do this_

# Todo

* Figure out git credentials inside remote development containers. Docs: https://code.visualstudio.com/docs/remote/containers#_sharing-git-credentials-with-your-container
* Make sure gradle env can be pre-built so we don't need internet at competition --- Downloading https://services.gradle.org/distributions/gradle-5.0-bin.zip
* Design work session with students
  1. Ensure basics of Classes and Functions
  2. Discuss RobotMap (integers)
  3. Design Subsystems
  4. Foreach(subsystem) --> Design Commands
    * bonus: can we set it up in ShuffleBoard easily?
  5. Design OI mappings to Commands