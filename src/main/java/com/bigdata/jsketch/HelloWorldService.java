package com.bigdata.jsketch;

import java.lang.management.ManagementFactory;
import java.util.Random;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldService implements HelloWorldServiceMBean  {
  private static Logger logger = LoggerFactory.getLogger(HelloWorldService.class);  
  private static int helloMetric = 0;
  private static HelloWorldService instance = new HelloWorldService();
  
  //////////////////////////////
  // register JMX
  //////////////////////////////
  static {
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    try {
        String mbeanName = "com.bigdata.jsketch:type=HelloWorldService";
        mbs.registerMBean(instance, new ObjectName(mbeanName));
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
  }

  @Override
  public int getHelloMetric() {
    return helloMetric;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    logger.info("Hello World Service start!");
        
    for (int i = 0; i < args.length; i++) {
      logger.info("args[{}] = {}", i, args[i]);
    }
    
    Random random = new Random();
    long startTime = System.currentTimeMillis();
    
    while (true) {
      try {
        helloMetric = 1000 + random.nextInt(100);
        Thread.sleep(5000);
        logger.info("Hello World Service is alive, age: {}ms", System.currentTimeMillis()-startTime);
      } catch (InterruptedException ex) {
        logger.error(ex.toString());
        break;
      }
    }
    
    logger.info("Hello World Service end!");
  }

}