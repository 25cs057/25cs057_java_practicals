package exercise2;

/**
 * Sample test suite with a combination of annotated @Run test methods
 * and unannotated helper routines.
 */
public class SampleTestSuite {

    public void unannotatedHelperMethod() {
        System.out.println("    [HELPER] This helper should NOT be executed by the test runner.");
    }

    @Run(description = "Verify Database Connectivity")
    public void testDatabaseConnection() {
        System.out.println("    [TEST] Running testDatabaseConnection -> Connection pool verified: OK.");
    }

    @Run(description = "Verify User Login Credentials")
    public void testUserAuthentication() {
        System.out.println("    [TEST] Running testUserAuthentication -> JWT verification: OK.");
    }

    public void internalTearDown() {
        System.out.println("    [HELPER] Cleanup routine (unannotated).");
    }

    @Run(description = "Verify Payment Processing Flow")
    public void testPaymentGateway() {
        System.out.println("    [TEST] Running testPaymentGateway -> Stripe sandbox charge: OK.");
    }
}

