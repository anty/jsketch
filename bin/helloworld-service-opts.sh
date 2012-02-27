# *************************************************************************
# Copyright (c) 2009~ , BIGDATA. All Rights Reserved.
# *************************************************************************

# This is the supplement of bigdata-env.sh, which is the base env file.
# Included in all the BIGDATA scripts with source command, should not be 
# executable directly, and always to be sourced after bigdata-config.sh.

# Define the helloworld-service customized runtime options (of JVM) here.


# ----------------------------------------------------------------------
# helloworld-customized JVM HEAP size definition.
# These definitions will override the default HEAP options.
# ----------------------------------------------------------------------
export BIGDATA_HEAP_MIN_COPTS=64m
export BIGDATA_HEAP_MAX_COPTS=64m

# ----------------------------------------------------------------------
# Build the helloworld-customized BIGDATA_COPTS. (eg. -ea for assert)
#   JMX options
# ----------------------------------------------------------------------
export BIGDATA_COPTS="-Dcom.sun.management.jmxremote.port=18081 \
                      -Dcom.sun.management.jmxremote.ssl=false \
                      -Dcom.sun.management.jmxremote.authenticate=false"

# ----------------------------------------------------------------------
# Build the helloworld-customized BIGDATA_COPTS, continue...
#   Misc...
# ----------------------------------------------------------------------
export BIGDATA_COPTS="$BIGDATA_COPTS \
                      -XX:+UseThreadPriorities \
                      -Djava.net.preferIPv4Stack=true"

# ----------------------------------------------------------------------
# Build the helloworld-customized BIGDATA_COPTS, continue...
#   javaagent for JMX --> Ganglia
# ----------------------------------------------------------------------
if [ -f "$BIGDATA_CONF_DIR/jmxetric.xml" ]; then
  # jmxetric jar path
  JMXETRIC_JARPATH="$BIGDATA_HOME/lib/bigdata-jmxetric-0.0.6.jar"
    
  # jmxetric options
  JMXETRIC_CONF="config=$BIGDATA_CONF_DIR/jmxetric.xml"
  
  # javaagent
  JAVAAGENT="-javaagent:$JMXETRIC_JARPATH=$JMXETRIC_CONF"
  
  # append BIGDATA_COPTS
  if [ "x$JAVAAGENT" != "x" ]; then
    export BIGDATA_COPTS="$BIGDATA_COPTS $JAVAAGENT"
  fi
fi

# ----------------------------------------------------------------------
# helloworld-customized classpath
# ----------------------------------------------------------------------
# export BIGDATA_CLASSPATH_COPTS=
