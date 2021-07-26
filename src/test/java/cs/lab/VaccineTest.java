package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;


class VaccineTest {
    static final Logger logger = Logger.getLogger(Center.class.getName());
    long maxExecutionTimeAns = 200;
    long maxExecutionTimeNotif = 300;
    VaccineAlert v = VaccineAlert.getInstance();

    Center a = new Center("a");
    Center b = new Center("b");
    Center c = new Center("c");

    @Test(threadPoolSize = 80)
    public void testCase1() throws IOException
    {
        long startTime = System.currentTimeMillis();
        v.addCenter(a);
        v.addCenter(b);
        v.addCenter(c);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeAns);
    }

    @Test(threadPoolSize = 80)
    public void testCase2() throws IOException
    {
        long startTime = System.currentTimeMillis();
        v.removeCenter("a");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeNotif);
    }

    @Test
    public void testCase3() throws IOException {
        long startTime = System.currentTimeMillis();
        // insert test that checks answer
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeAns);
    }

    public void testCase4() throws IOException
    {
        long startTime = System.currentTimeMillis();
        //insert test that checks notification
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeAns);
    }
};