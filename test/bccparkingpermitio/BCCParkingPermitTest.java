/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bccparkingpermitio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author admin
 */
public class BCCParkingPermitTest {
    
    public BCCParkingPermitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BCCParkingPermit. Ignored as console based interaction required.
     */
    @Ignore
    public void testMain() {
        System.out.println("main");
    }

    /**
     * Test of calculatePermit method, of class BCCParkingPermit.Ignored as console based interaction required.
     */
    @Ignore
    @Test
    public void testCalculatePermit() {
        System.out.println("calculatePermit");
        int code = 0;
        int q = 0;
        BCCParkingPermit.calculatePermit(code, q);
    }

    /**
     * Test of checkIsPremiumCode method, of class BCCParkingPermit.
     * code has to be >0 and <=3 to be true
     */
    @Ignore
    @Test
    public void testCheckIsPremiumCode() {
        System.out.println("checkIsPremiumCode");
        int code = 3;
        boolean expResult = true;
        boolean result = BCCParkingPermit.checkIsPremiumCode(code);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkIntUpper method, of class BCCParkingPermit. 
     * i has to be >0 and <= max to be true
     */
    @Ignore
    @Test
    public void testCheckIntRange() {
        System.out.println("checkIntUpper");
        int i = 0;
        int max = 5;
        boolean expResult = true;
        boolean result = BCCParkingPermit.checkIntRange(i, max);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcDiscount method, of class BCCParkingPermit.
     * q will always be more than 1 if discount calc being applied
     * but the calulation is
     */
    @Test
    public void testCalcDiscount() {
        System.out.println("calcDiscount");
        int q = 3;
        double totalprem = 75.0;
        double expResult = 62.5;
        double result = BCCParkingPermit.calcDiscount(q, totalprem);
        System.out.println(result);
        assertEquals(expResult, result, 0.0);
    }
    
}
