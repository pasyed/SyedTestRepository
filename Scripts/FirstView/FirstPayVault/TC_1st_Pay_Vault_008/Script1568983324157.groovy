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

CustomKeywords.'utilities.SafeActions.openBrowser'('https://q-www-firstview-net.faps.net/MVC/Account/Login', (([10]) as int[]))

CustomKeywords.'pages.Login.login'('ZenQRetail', 'P@ssword1')

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), 'Click on FirstPayVault tab', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_CreateVault'), 
    'Click on CreateVault button', (([5]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_VaultReferenceNumber'), 5)

vaultReference = CustomKeywords.'utilities.SafeActions.timeWithMilliSeconds'()

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_VaultReferenceNumber'), vaultReference, 
    'Entering Vault Reference Number', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_CreditCardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDown_ExpirationMonth'), 
    cardMonth, 'Expiration Month', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDown_ExpirationYear'), 
    cardYear, 'year', (([5]) as int[]))

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_ContactName'), customerName, 'Enter Contact Name', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_PostalCode'), '76102', 'Enter Postal Code', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_Address'), 'James Street', 'Enter ddress', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/chekBox_AddShippingInformation'), 
    5)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_ShippingMethod'), 'DTDC', 'Enter Shipping Method', 
        (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/checkbox_SameAsBillingInformation'), 
    5)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Create'), 'Click on Create Button', 
        (([5]) as int[]))

WebUI.delay(2)

popupSavedToVaultMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/popup_SavedToVaultMessage'), 
    5)

flag = CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Successfully Saved to Vault', popupSavedToVaultMessage)

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_RunSaleWithThisVault_InPopup'), 
    'Click on Run Sale With This Vault in Popup', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

WebUI.delay(1)

value = CustomKeywords.'utilities.SafeActions.getAttributeValue'(findTestObject('Pages/FirstPayVault/tab_1stPayVault_Active'), 
    '1st_PayVault')

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_Amount'), 5)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_Amount'), '450', 'Enter Amount', 
        (([5]) as int[]))

salesTax = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/input_SalesTaxUnderAmount'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.FirstPayVault.verifyAmountIsNotZero'(salesTax)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_CreditCardNumberForVerification'), GlobalVariable.delayBetweenTestSteps)

cardNumber = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/input_CreditCardNumberForVerification'), 
    '1st Pay Vault')

CustomKeywords.'pages.FirstPayVault.verifyCardNumber'(cardNumber, GlobalVariable.visaCardNumber)

/*expirationMonth = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/dropDownExpirationMonthForVerification'), 
    '1st Pay Vault')

CustomKeywords.'pages.FirstPayVault.verifyStrings'(expirationMonth, cardMonth)*/
expirationYear = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/dropDownExpirationYearForVerification'), 
    '1st Pay Vault')

CustomKeywords.'pages.FirstPayVault.verifyStrings'(expirationYear, cardYear)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_VerifyCardHolderName'), 5)

name = CustomKeywords.'utilities.SafeActions.getAttribute'(findTestObject('Pages/FirstPayVault/input_VerifyCardHolderName'), 
    '1stPayVault')

CustomKeywords.'pages.FirstPayVault.verifyStrings'(name, customerName)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/checkbox_TaxExempt'), 5)

salesTax = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/amount_UnderPurchaseCardInformation'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'pages.FirstPayVault.verifyAmountIsNotZero'(salesTax)

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/checkbox_TaxExempt'), 5)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Checkout'), 'Click on Checkout', 
        (([5]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_ReturnToSale_InTransactionComplete'), 
    'Click On Return Button', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_SearchVault'), 'Click on Search Vault', 
        (([10]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_Search'), 'Click On Search button', 
        (([5]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 5)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.FirstPayVault.verifyInvoiceRecord'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), vaultReference)

WebUI.delay(2)

CustomKeywords.'pages.FirstPayVault.clickOnMakeAPayment'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), vaultReference)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_Amount'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_Amount'), '450', 'Enter Amount', 
        (([10]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/checkBox_SetAsFuturePayment'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/checkBox_SetAsFuturePayment'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Checkout'), 'Click on Checkout', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/label_RecurringPayment_TransactionCompleteScreen'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/date_StartDate'), 'Click on Date Input', 
        (([5]) as int[]))

CustomKeywords.'pages.Sale.selectMonthYear'(findTestObject('Pages/Sale/link_MonthYear'), findTestObject('Pages/Sale/calender_NextButton'), 
    cardMonth, cardYear)

CustomKeywords.'pages.Sale.selectDate'(start_date_Value)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/date_EndDate'), 'Click on Date Input', 
        (([5]) as int[]))

CustomKeywords.'pages.Sale.selectMonthYear'(findTestObject('Pages/Sale/link_MonthYear'), findTestObject('Pages/Sale/calender_NextButton'), 
    cardMonth, cardYear)

CustomKeywords.'pages.Sale.selectDate'(end_date_Value)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_Frequency_TransactionComplete'), 
    'Weekly', 'Select By Value', (([10]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/text_PaymentAmount_TransactionComplete'), 
    '650', 'Enter Amount', (([10]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/Sale/checkBox_Label_EmailReceipt_TransactionComplete'), 
    5)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/textBox_EmailAddress_TransactionComplete'), 
    GlobalVariable.emailAddress, 'Enter EmailAddress into text box', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_SaveAndReturn_TransactionCompletePage'), 
    'Click on Save and Return', (([10]) as int[]))

popUpMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/popupMessage_TransactionComplete'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Your Recurring Payment Setup has been completed. Please click ok to return to the main vault screen.', 
    popUpMessage)

WebUI.closeBrowser()

