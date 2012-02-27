A Java project skeleton for newbie developers of Java project. Includes the basic Buildfile(for ant) and Shell-scripts.

------------------------------------------------

1. A simple structure for a new java project.

------------------------------------------------

2. Building (build.xml)
   A simple buildfile for Apache Ant.
   
   # clean all build generated files.
   ant cleanall
   
   # compile java
   ant compile

   # package jar (default!)
   ant package

   # javadoc
   ant javadoc
   
   # make distribution packages
   ant dist

   ...

   User customization:
   Just modify build.properties file to define your app.version and app.name.

------------------------------------------------

3. Shell-scripts (bin/*)
   In the bin directory, there are some shell scripts to make up the script-stsrem.
   This script-system make up the run-environment.

   bigdata-config.sh
   This shell script to set the configuration of the project.
   
   bigdata-daemon.sh
   This shell script to launch a local daenom.

   bigdata-daemon.sh
   This shell script to lanuch a daemon in a cluster, the cluster nodes are defined in conf/nodes.

   nodes.sh
   This shell script to execute command in a cluster, via SSH.

   * bigdata
   This shell script to execute any user defined Java class.

   * bigdata-env.sh
   This shell script to let user to set/customize environment setting.
   Usually, the user only need to modify this file for his/her specific platform.

   ~~~~~~~~~~~~~~~~~~~~

   ** helloworld-service-opts.sh
   This shell script is a template for setting user-customized options for a daemon.
   User can define his/her own such files for his/her daemons.
   
   ** helloworld-service
   This shell script is a template for writing a user daemon's start/stop script, include start/stop in a cluster.
   Use can write his/her own such files for his/her daemons.

------------------------------------------------

4. Configuration
   
   log4j.properties
   Log4j configuration file, it can use the varianbles defined in the script-system.

   commons-logging.properties
   Apache common-logging configuration files.

   nodes
   Define the node ipaddr/hostname of the cluster, one by line.

   jmxetric.xml
   jmxetric configuration file. jsketch integrated jmxetric to make it easy to integrate JMX and Ganglia.


------------------------------------------------

5. Examples to use jsketch
   
   (1) Download jsketch and build it
       $ ant

   (2) Run the HelloWorld class
       bin/bigdata com.bigdata.jsketch.HelloWorld Just do it
       This command will display following:
          _____________        _________      _____        
          ___  __ )__(_)______ ______  /_____ __  /______ _
          __  __  |_  /__  __ `/  __  /_  __ `/  __/  __ `/
          _  /_/ /_  / _  /_/ // /_/ / / /_/ // /_ / /_/ / 
          /_____/ /_/  _\__, / \__,_/  \__,_/ \__/ \__,_/
                       /____/   HelloWorld2
        Hello World!
        args[0] = Just
        args[1] = do
        args[2] = it.
  
    (3) start|stop the HelloWorld daemon local or clustering.
        bin/helloworld-service start | stop | start-cluster | stop-cluster
        Check logs directory to see the log files of the HelloWorld daemon.


------------------------------------------------

6. Done
   It is a very simple skeleton to develop, build and run(local or clustering) java project.
   Enjoy it.

Schubert Zhang 2010.10.1
