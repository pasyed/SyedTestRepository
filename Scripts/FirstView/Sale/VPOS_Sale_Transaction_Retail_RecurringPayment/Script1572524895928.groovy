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

not_run: WebUI.delay(GlobalVariable.delayForElement)

not_run: CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    GlobalVariable.RetailAccountOption, 'Select by Value', (([25]) as int[]))

not_run: WebUI.delay(GlobalVariable.delayBetweenTestSteps)

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

CustomKeywords.'pages.Sale.verifyIfAdditionalPromptingIsChecked'('Set up Recurring Payment?', GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_Checkout'), 'Click on Checkout button', 
        (([60]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/label_RecurringPayment_TransactionCompleteScreen'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/date_StartDate_TransactionComplete'), 
    'Click on Date Input', (([5]) as int[]))

CustomKeywords.'pages.Sale.selectMonthYear'(findTestObject('Pages/Sale/link_MonthYear'), findTestObject('Pages/Sale/calender_NextButton'), 
    cardMonth, cardYear)

not_run: CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_SaveAndReturnToSale_TransactionComplete'), 
    'Click on Save and Return To Sale button', (([10]) as int[]))

CustomKeywords.'pages.Sale.selectDate'(start_date_Value)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/date_EndDate_TransactionComplete'), 
    'Click on Date Input', (([5]) as int[]))

CustomKeywords.'pages.Sale.selectMonthYear'(findTestObject('Pages/Sale/link_MonthYear'), findTestObject('Pages/Sale/calender_NextButton'), 
    cardMonth, cardYear)

CustomKeywords.'pages.Sale.selectDate'(end_date_Value)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_Frequency_TransactionComplete'), 
    'Weekly', 'Select By Value', (([10]) as int[]))

not_run: CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/text_PaymentAmount_TransactionComplete'), 
    amountInput, 'Enter Amount', (([10]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/Sale/checkBox_Label_EmailReceipt_TransactionComplete'), 
    5)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/textBox_EmailAddress_TransactionComplete'), GlobalVariable.emailAddress, 
    'Enter EmailAddress into text box', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_SaveSetup'), 'Click on SaveSetup', 
        (([GlobalVariable.delayForElement]) as int[]))

WebUI.delay(2)

popupFromMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/popupText_AfterClickOn_SaveAndReturnToSale_TransactionComplete'), 
    5)

CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Your Setup has been completed.', popupFromMessage)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/close_TextBox'), 'Click on SaveSetup', 
        (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([15]) as int[]))

WebUI.delay(5)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Future_Payments/tab_FuturePayments'), 'Click on Future Payments Tab', 
        (([10]) as int[]))

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Future_Payments/search_Button'), 'Search', 
        (([10]) as int[]))

println(invoiceNumber)

println(total_Amount)

WebUI.scrollToElement(findTestObject('Pages/Future_Payments/invoiceForTransaction'), GlobalVariable.delayBetweenTestSteps)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.Future_Payments.verifyInvoiceRecord'(findTestObject('Pages/Future_Payments/footer_NextButton'), findTestObject(
        'Pages/Future_Payments/page_Number'), invoiceNumber, total_Amount)

WebUI.closeBrowser()

