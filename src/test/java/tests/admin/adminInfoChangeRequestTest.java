package tests.admin;

import base.baseTest;
import org.testng.annotations.Test;

public class adminInfoChangeRequestTest extends baseTest {
    loginTest login = new loginTest();

    @Test
    public void test(){
        login.performLogin(driver); // Pass the 'driver' from baseTest
    }



}
