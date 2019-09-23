# Getting Started

1. Make sure you can run the development environment.

    * If you have a Mac: [Install Docker Desktop for macOS](https://download.docker.com/mac/stable/Docker.dmg)
    * If you have a PC: [Install Docker Desktop for Windows](https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe)
    * Start Docker. You do _not_ need to log in if it asks you, just close it to skip.
    * [Install Visual Studio Code](https://code.visualstudio.com/download)
    * Open Visual Studio Code → Click View...Extensions → Search for "Remote Development" → Click "Install"

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

* Figure out how to manage multi-user Github + VSCode checkouts with a pool of laptops
  * could [create a MacOS user account that uses external USB](https://www.lifewire.com/move-macs-home-folder-new-location-2260157) and students can boot with that USB
* Update our [CodeHS curriculum](https://codehs.com/section/80279/course/692/activity_progress/module/1309) to include some robot-specific and practice sessions
