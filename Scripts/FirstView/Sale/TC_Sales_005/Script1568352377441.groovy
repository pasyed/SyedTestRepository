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
    'ranjanatest2 - 888814981372/002 Account Type: Ecommerce', 'Select by Value', (([25]) as int[]))

not_run: WebUI.delay(3)

CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'pages.Login.login'(uName, password)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('Sale', 'Manually Keyed', GlobalVariable.delayBetweenTestSteps)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeTypeUsingJavascript'(findTestObject('Pages/Sale/input_Amount'), amount)

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), amount, 'Amount field', (([GlobalVariable.delayForElement]) as int[]))

not_run: CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), amount, 'Enter Amount into Amount text box', 
        (([GlobalVariable.PageLoadTime]) as int[]))

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), GlobalVariable.PageLoadTime)

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), GlobalVariable.PageLoadTime)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('Sale', 'Card Not Present', GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([GlobalVariable.PageLoadTime]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
//WebUI.delay(4)
CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    cardMonth, 'Enter Expiration Month', (([GlobalVariable.PageLoadTime]) as int[]))

//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    cardYear, 'Enter Expiration Year', (([GlobalVariable.PageLoadTime]) as int[]))

//WebUI.delay(2)
WebUI.scrollToElement(findTestObject('Pages/Sale/input_CustomerName'), GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CustomerName'), customerName, 'Enter Customer Name', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Address'), address, 'Enter Address', (([
            GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_PostalCode'), postalCode, 'Enter Postal Code', 
        (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.PageLoadTime)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.PageLoadTime)

//WebUI.executeJavaScript("document.getElementById('select-expiration-year').className='form-control parsley-success'", null)
/*CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'December')

WebUI.delay(4)*/
/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'December', 'Select by Value', (([20]) as int[]))*/
/*CustomKeywords.'utilities.SafeActions.safeClickWithoutScrollOnLabel'(findTestObject('Pages/Sale/label_ExpirationYear'), 
    'Click on Label', (([20]) as int[]))

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'March')

WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2035')

WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2025')*/
CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_Checkout'), 'Click on Checkout button', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

//WebUI.delay(GlobalVariable.PageLoadTime)
CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Transaction_Management/tab_TransactionManagement'), 
    'Transaction Management Tab', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Transaction_Management/button_Search'), 
    'Search', (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), GlobalVariable.PageLoadTime)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.Transaction_Management.verifyInvoiceRecord'(findTestObject('Pages/Transaction_Management/footer_NextButton'), 
    findTestObject('Pages/Transaction_Management/page_Number'), invoiceNumber, total_Amount)

WebUI.closeBrowser()

