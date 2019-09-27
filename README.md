# Getting Started

1. Make sure you can run the development environment.

    * If you have a Mac: [Install Docker Desktop for macOS](https://download.docker.com/mac/stable/Docker.dmg)
    * If you have a PC: [Install Docker Desktop for Windows](https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe)
    * Start Docker. You do _not_ need to log in if it asks you, just close it to skip.
    * [Install Visual Studio Code](https://code.visualstudio.com/download)
    * Open Visual Studio Code → Click View...Extensions → Search for "Remote - Containers" → Click "Install"

2. Make sure you can collaborate using Github.

    * [Create a Github account](https://github.com/join) if you don't have one
    * [Request to join our Github Organization](https://github.com/orgs/epa-robotics)
    * [Install Github Desktop](https://desktop.github.com/) or commandline if you prefer
    * [Clone the robot code](https://github.com/epa-robotics/travis-bot) using the green button

3. **You're ready to code! Every time you want to edit/build/deploy to the robot, just**:

    * Open Github Desktop
        * Make sure "Current Repository" (upper right) is `travis-bot`
        * Make sure "Current Branch" (next one) is **not** `master`. If it is, create a new branch for your work.
    * Click "Open in Visual Studio Code"
    * Visual Studio Code should show an alert in the bottom-right → Click "Reopen in Container"
    * **To build:** Click the "W" icon in the upper-right → "WPILib: Build Robot Code"
    * **To deploy:** Click the "W" icon in the upper-right → "WPILib: Deploy Robot Code"
        * _Note: you need to be connected to the robot's wifi radio to do this_

# Todo

* Update our [CodeHS curriculum](https://codehs.com/section/80279/course/692/activity_progress/module/1309) to include some robot-specific and practice sessions
* Figure out how to manage multi-user Github + VSCode checkouts with a pool of laptops
  * initially, we could use the `epa-robotics-team` account for all commits and pushes, keep that auth on each laptop, and just ask the kids to put their name in the commit message
  * next we want to figure out how to make it work better for individual commits, getting comfortable using their own Github account
  * idea: looks like we could symlink the `/Users/USERNAME/Documents/GitHub` path to USB drive, or at least clear this on login
  * idea: can [clear github credentials](https://help.github.com/en/articles/updating-credentials-from-the-osx-keychain) on login each time using `git credential-osxkeychain erase`
* Figure out how to incorporate quick-mapping of ports without needing to upload new code at competition. This introspects the `RobotMap` onto the Shuffleboard for example:
```java
    for (Field field : obj.getClass().getDeclaredFields()) {
      Object shuffleBoardValue = null;
      String shuffleBoardTitle = String.format("%s.%s", objName, field.getName());
      try {
        shuffleBoardValue = field.get(obj);
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } finally {
        Shuffleboard.getTab(shuffleBoardTabName).add(shuffleBoardTitle, shuffleBoardValue);
      }
    }
```