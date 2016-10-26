package ca.ulaval.glo4002.atm.rest;

import ca.ulaval.glo4002.atm.AtmServer;
import ca.ulaval.glo4002.atm.contexts.DevContext;
import ca.ulaval.glo4002.atm.contexts.TestContext;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ WithdrawResourceRestTest.class })
public class RestTestSuite {

    public static final int TEST_SERVER_PORT = 9292;

    private static AtmServer atmServer;

    @BeforeClass
    public static void setUpClass() {
        atmServer = new AtmServer();
        atmServer.start(TEST_SERVER_PORT, new TestContext());
    }

    @AfterClass
    public static void tearDownClass() {
        atmServer.stop();
    }

}
