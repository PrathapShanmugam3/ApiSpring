# FROM openjdk:8
# # tzdata for timzone
# RUN apt-get install -y tzdata
 
# # timezone env with default
# ENV TZ Asia/Kolkata
# WORKDIR /usr/src/myapp
# COPY target/devarCabs.jar /usr/src/myapp/ROOT.jar
# EXPOSE 3506
# ENTRYPOINT ["java","-jar","-Xmx1024m", "-Xms512m","ROOT.jar"]


FROM openjdk:8

# Install tzdata for timezone
RUN apt-get update && apt-get install -y tzdata

# Set timezone environment variable with default
ENV TZ Asia/Kolkata

# Set the working directory
WORKDIR /usr/src/myapp

# Copy the JAR file to the container
COPY target/devarCabs.jar /usr/src/myapp/ROOT.jar

# Expose the application port
EXPOSE 3506

# Set the entry point with adjusted heap size
ENTRYPOINT ["java", "-Xmx512m", "-Xms256m", "-jar", "ROOT.jar"]



