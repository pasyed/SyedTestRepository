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

WebUI.delay(6)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    'ranjanatest2 - 888814981372/001 Account Type: Retail', 'Select by Value', (([25]) as int[]))

WebUI.delay(3)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('radio-manual', 60)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), 60)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), '550', 'Enter Amount into Amount text box', 
        (([20]) as int[]))

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), 10)

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('radio-card-not-present', 60)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), '4111111111111111', 'Entering Card Number', 
        (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'September', 'Enter Expiration Month', (([5]) as int[]))

//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    '2022', 'Enter Expiration Year', (([5]) as int[]))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), 10)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), 10)

CustomKeywords.'pages.Sale.verifyIfAdditionalPromptingIsChecked'('Set as Future Payment?', 10)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/date_FuturePayment'), 'Click on Date Input', 
        (([5]) as int[]))

CustomKeywords.'pages.Sale.selectMonthYear'(findTestObject('Pages/Sale/link_MonthYear'), findTestObject('Pages/Sale/calender_NextButton'), 
    'September', 2020)

CustomKeywords.'pages.Sale.selectDate'(22)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_Checkout'), 'Click on Checkout button', 
        (([60]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

WebUI.delay(6)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([10]) as int[]))

WebUI.delay(5)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Future_Payments/tab_FuturePayments'), 'Click on Future Payments Tab', 
        (([10]) as int[]))

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Future_Payments/search_Button'), 'Search', 
        (([10]) as int[]))

