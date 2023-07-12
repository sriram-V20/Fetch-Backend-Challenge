## Use an official OpenJDK runtime as a parent image
#FROM openjdk:11-jdk
#
## Install utilities
#RUN apt-get update && apt-get install -y curl unzip
#
## Install sbt
#RUN \
#  curl -L -o sbt-1.5.5.zip https://github.com/sbt/sbt/releases/download/v1.5.5/sbt-1.5.5.zip && \
#  unzip sbt-1.5.5.zip -d /usr/local && \
#  rm sbt-1.5.5.zip
#
## Add sbt to PATH
#ENV PATH $PATH:/usr/local/sbt/bin
#
## Set the working directory in the container to /app
#WORKDIR /app
#
## Copy the local package files to the container's workspace
#ADD . /app
#
## Compile the application
#RUN sbt update && \
#    sbt compile && \
#    sbt test
#
## Make port 9000 available for links and/or publish
#EXPOSE 9000
#
## Run the application when the container launches
#CMD sbt run


# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk

# Install utilities
RUN apt-get update && apt-get install -y curl unzip

# Install sbt
RUN \
  curl -L -o sbt-1.5.5.zip https://github.com/sbt/sbt/releases/download/v1.5.5/sbt-1.5.5.zip && \
  unzip sbt-1.5.5.zip -d /usr/local && \
  rm sbt-1.5.5.zip

# Add sbt to PATH
ENV PATH $PATH:/usr/local/sbt/bin

# Set the working directory in the container to /app
WORKDIR /app

# Copy the local package files to the container's workspace
ADD . /app

# Compile the application
RUN sbt update && \
    sbt compile && \
    sbt test

# Make port 9000 available for links and/or publish
EXPOSE 9000

# Run the application when the container launches
CMD sbt run
