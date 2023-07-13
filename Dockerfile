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


# Use an official Java runtime as a parent image
#FROM openjdk:11
#
## Set the working directory in the container
#WORKDIR /app
#
## Install sbt
#RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list
#RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list
#RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add
#RUN apt-get update
#RUN apt-get install sbt
#
## Copy only the build.sbt and related files initially,
## this way these steps of the docker file can be cached if these files do not change
#COPY ./project /app/project
#COPY ./build.sbt /app
#
## Run sbt update here so it can be cached
#RUN sbt -Dsbt.watch.mode=polling update
#
## Copy the rest of the source code
#COPY ./ /app
#
## Compile the application
#RUN sbt compile
#
## Run the application
#CMD ["sbt", "run"]