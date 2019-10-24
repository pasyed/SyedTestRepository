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

not_run: CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.PageLoadTime]) as int[]))

not_run: WebUI.delay(6)

not_run: CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    'ranjanatest2 - 888814981372/002 Account Type: Ecommerce', 'Select by Value', (([25]) as int[]))

not_run: WebUI.delay(3)

CustomKeywords.'utilities.SafeActions.openBrowser'('https://q-www-firstview-net.faps.net/MVC/Account/Login', (([10]) as int[]))

CustomKeywords.'pages.Login.login'('ZenQEcom', 'P@ssword1')

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('Sale', 'Manually Keyed', GlobalVariable.delayBetweenTestSteps)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), 60)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), '550', 'Enter Amount into Amount text box', 
        (([20]) as int[]))

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), 10)

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('Sale', 'Card Not Present', GlobalVariable.delayBetweenTestSteps)

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

WebUI.scrollToElement(findTestObject('Pages/Sale/input_CustomerName'), 5)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CustomerName'), 'Venkata Sai', 'Enter Customer Name', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Address'), 'Street12334', 'Enter Address', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_PostalCode'), '76102', 'Enter Postal Code', 
        (([5]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), 10)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), 10)

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
        (([60]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

WebUI.delay(6)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([10]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Transaction_Management/tab_TransactionManagement'), 
    'Transaction Management Tab', (([10]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Transaction_Management/button_Search'), 
    'Search', (([10]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 5)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.Transaction_Management.verifyInvoiceRecord'(findTestObject('Pages/Transaction_Management/footer_NextButton'), 
    findTestObject('Pages/Transaction_Management/page_Number'), invoiceNumber, total_Amount)

WebUI.closeBrowser()

