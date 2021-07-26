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
    VaccineAlert v2 = VaccineAlert.getInstance();

    Center a = new Center("a");
    Center b = new Center("b");
    Center c = new Center("c");
    Center d = new Center("d");

    @Test(threadPoolSize = 50)
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

    @Test(threadPoolSize = 50)
    public void testCase2() throws IOException
    {
        long startTime = System.currentTimeMillis();
        v.addCenter(a);
        v.removeCenter("a");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeNotif);
    }

    @Test(threadPoolSize = 50)
    public void testCase3() throws IOException {
        long startTime = System.currentTimeMillis();
        String un = "Jesus";
        String up = "12345";
        v.subscribe(un, up);
        v.addCenter(b);
        v.notifyUsers("b");
        v.unsubscribe(un);
        v2.subscribe(un, up);
        v2.unsubscribe(un);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeAns);
    }

    @Test(threadPoolSize = 50)
    public void testCase4() throws IOException
    {
        long startTime = System.currentTimeMillis();
        v.addCenter(d);
        float avance = 4;
        float cobertura = 30;
        int vp = 5;
        int vc = 3;
        v.setInfo("d", avance, cobertura, vp, vc);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        var responseTime = "Time Response: " + String.valueOf(executionTime);
        logger.info(responseTime);
        Assert.assertTrue(executionTime < maxExecutionTimeAns);
    }
};