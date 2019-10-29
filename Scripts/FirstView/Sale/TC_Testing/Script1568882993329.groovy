import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.Old_URL, (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.delay(GlobalVariable.delayForElement)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    GlobalVariable.RetailAccountOption, 'Select by Value', (([25]) as int[]))

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, entryModeCheckBox, GlobalVariable.delayBetweenTestSteps)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), amountInput, 'Enter Amount into Amount text box', 
        (([20]) as int[]))

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, cardInformationCheckBox, GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    cardMonth, 'Month', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.javascriptModifyClassAttribute'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    GlobalVariable.delayBetweenTestSteps)

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    cardYear, 'Year', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.javascriptModifyClassAttribute'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.delayBetweenTestSteps)

