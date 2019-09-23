package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile GlobalVariables_VPOS : URL of VPOS application</p>
     */
    public static Object URL
     
    /**
     * <p>Profile GlobalVariables_VPOS : Page Loading Time</p>
     */
    public static Object PageLoadTime
     
    /**
     * <p></p>
     */
    public static Object delayForElement
     
    /**
     * <p></p>
     */
    public static Object RetailAccountOption
     
    /**
     * <p></p>
     */
    public static Object delayBetweenTestSteps
     
    /**
     * <p></p>
     */
    public static Object visaCardNumber
     
    /**
     * <p></p>
     */
    public static Object emailAddress
     
    /**
     * <p></p>
     */
    public static Object HighLightElements
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            URL = selectedVariables['URL']
            PageLoadTime = selectedVariables['PageLoadTime']
            delayForElement = selectedVariables['delayForElement']
            RetailAccountOption = selectedVariables['RetailAccountOption']
            delayBetweenTestSteps = selectedVariables['delayBetweenTestSteps']
            visaCardNumber = selectedVariables['visaCardNumber']
            emailAddress = selectedVariables['emailAddress']
            HighLightElements = selectedVariables['HighLightElements']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
