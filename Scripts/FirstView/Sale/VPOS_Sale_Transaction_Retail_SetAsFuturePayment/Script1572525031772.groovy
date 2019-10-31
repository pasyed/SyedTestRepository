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

not_run: CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.Old_URL, (([GlobalVariable.PageLoadTime]) as int[]))

not_run: WebUI.delay(6)

not_run: CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    'ranjanatest2 - 888814981372/001 Account Type: Retail', 'Select by Value', (([25]) as int[]))

not_run: WebUI.delay(3)

not_run: CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('radio-manual', 60)

CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'pages.Login.login'(uName, password)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

WebUI.delay(GlobalVariable.delayForElement)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, entryModeCheckBox, GlobalVariable.delayBetweenTestSteps)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeTypeUsingJavascript'(findTestObject('Pages/Sale/input_Amount'), amountInput)

not_run: WebUI.focus(findTestObject('Pages/Sale/input_Amount'))

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), amountInput, 'Amount field', 
        (([GlobalVariable.delayForElement]) as int[]))

not_run: CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), amountInput, 'Enter Amount into Amount text box', 
        (([20]) as int[]))

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, cardInformationCheckBox, GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    cardMonth, 'Select Expiration Month', (([5]) as int[]))

//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    cardYear, 'Select Expiration Year', (([5]) as int[]))

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.delayBetweenTestSteps)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.delayBetweenTestSteps)

not_run: CustomKeywords.'pages.Sale.verifyIfAdditionalPromptingIsChecked'('Set up Recurring Payment?', GlobalVariable.delayBetweenTestSteps)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
not_run: WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), 60)

not_run: CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), '550', 'Enter Amount into Amount text box', 
        (([20]) as int[]))

not_run: total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), 10)

not_run: WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)

not_run: CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('radio-card-not-present', 60)

not_run: CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), '4111111111111111', 
    'Entering Card Number', (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
not_run: WebUI.delay(4)

not_run: CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'September', 'Enter Expiration Month', (([5]) as int[]))

//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
not_run: CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    '2022', 'Enter Expiration Year', (([5]) as int[]))

not_run: WebUI.delay(2)

not_run: WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), 10)

not_run: invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), 
    10)

CustomKeywords.'pages.Sale.verifyIfAdditionalPromptingIsChecked'('Set as Future Payment?', GlobalVariable.delayForElement)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/date_FuturePayment'), 'Click on Date Input', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'pages.Sale.selectMonthYear'(findTestObject('Pages/Sale/link_MonthYear'), findTestObject('Pages/Sale/calender_NextButton'), 
    cardMonth, cardYear)

CustomKeywords.'pages.Sale.selectDate'(start_date_Value)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_Checkout'), 'Click on Checkout button', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

not_run: WebUI.delay(6)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

not_run: WebUI.delay(5)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Future_Payments/tab_FuturePayments'), 'Click on Future Payments Tab', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

not_run: WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Future_Payments/search_Button'), 'Search', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

println(invoiceNumber)

println(total_Amount)

WebUI.scrollToElement(findTestObject('Pages/Future_Payments/invoiceForTransaction'), GlobalVariable.delayBetweenTestSteps)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.Future_Payments.verifyInvoiceRecord'(findTestObject('Pages/Future_Payments/footer_NextButton'), findTestObject(
        'Pages/Future_Payments/page_Number'), invoiceNumber, total_Amount)

WebUI.closeBrowser()

