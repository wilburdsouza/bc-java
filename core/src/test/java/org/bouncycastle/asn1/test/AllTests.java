package org.bouncycastle.asn1.test;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.bouncycastle.PrintTestResult;
import org.bouncycastle.util.test.SimpleTestResult;

public class AllTests
    extends TestCase
{
    public void testASN1()
    {
        org.bouncycastle.util.test.Test[] tests = RegressionTest.tests;

        for (int i = 0; i != tests.length; i++)
        {
            SimpleTestResult result = (SimpleTestResult)tests[i].perform();

            if (!result.isSuccessful())
            {
                fail(result.toString());
            }
        }
    }

    public static void main(String[] args)
    {
        PrintTestResult.printResult(junit.textui.TestRunner.run(suite()));
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite("ASN.1 Tests");

        suite.addTestSuite(AllTests.class);
        suite.addTestSuite(GetInstanceTest.class);
        suite.addTestSuite(ASN1SequenceParserTest.class);

        return new BCTestSetup(suite);
    }

    static class BCTestSetup
        extends TestSetup
    {
        public BCTestSetup(Test test)
        {
            super(test);
        }

        protected void setUp()
        {

        }

        protected void tearDown()
        {

        }
    }
}
