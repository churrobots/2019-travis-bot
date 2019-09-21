############################################################################################
# Based on the VSCode Java development container example.
# Copyright (c) Microsoft Corporation. All rights reserved.
# Licensed under the MIT License. See LICENSE in the project root for license information.
############################################################################################

FROM maven:3.6-jdk-11

ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update \
  && apt-get -y install --no-install-recommends apt-utils dialog 2>&1 \
  && apt-get -y install git procps lsb-release sudo ssh \
  && apt-get autoremove -y \
  && apt-get clean -y \
  && rm -rf /var/lib/apt/lists/*
ENV DEBIAN_FRONTEND=

RUN if [ ! -d "/docker-java-home" ]; then ln -s "${JAVA_HOME}" /docker-java-home; fi

RUN groupadd --gid $USER_GID $USERNAME
RUN useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME
RUN echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME
RUN chmod 0440 /etc/sudoers.d/$USERNAME
USER $USERNAME

# No reinstalls of extensions so that an accidental container
# rebuild without an internet connection won't break the project.
# https://code.visualstudio.com/docs/remote/containers-advanced#_avoiding-extension-reinstalls-on-container-rebuild
RUN mkdir -p ~/.vscode-server

# Make sure git works inside the container
RUN mkdir -p ~/.ssh && ssh-keyscan github.com >> ~/.ssh/known_hosts

# Predownload build dependencies so that Gradle doesn't
# try to connect to the internet every time it needs to
# recreate a build daemon.
ARG FRC_YEAR=2019
ARG FRC_VENDOR_PATH=/home/$USERNAME/frc$FRC_YEAR

RUN mkdir -p $FRC_VENDOR_PATH $FRC_VENDOR_PATH/maven
WORKDIR $FRC_VENDOR_PATH
RUN wget https://github.com/CrossTheRoadElec/Phoenix-Releases/releases/download/Phoenix_v5.14.1.2/CTRE_Phoenix_FRC_nonWindows_5.14.1.zip \
  && unzip CTRE_Phoenix_FRC_nonWindows_5.14.1.zip

# Warm up the gradle cache so we don't need to be online for builds.
WORKDIR /tmp
COPY .wpilib/wpilib_preferences.json .wpilib/wpilib_preferences.json
COPY gradle gradle
COPY build.gradle build.gradle
COPY gradlew gradlew
COPY settings.gradle settings.gradle
RUN ./gradlew build -Dorg.gradle.java.home="/docker-java-home"
