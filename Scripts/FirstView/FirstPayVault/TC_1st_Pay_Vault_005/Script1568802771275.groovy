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

CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.delay(6)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    'ranjanatest2 - 888814981372/001 Account Type: Retail', 'Select by Value', (([25]) as int[]))

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

CustomKeywords.'pages.FirstPayVault.verifycardNumber'(cardNumber, GlobalVariable.visaCardNumber)

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

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_Return_InTransactionComplete'), 
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

CustomKeywords.'pages.FirstPayVault.clickOnEdit'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), vaultReference)

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/dropDownExpirationMonthForVerification'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDownExpirationMonthForVerification'), 
    cardMonthUpdate, 'Update expiration Month', (([5]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/button_Update'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Update'), 'Click On Update', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

WebUI.delay(2)

popupUpdatedToVaultMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/popup_SavedToVaultMessage'), 
    5)

flag = CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Successfully Saved to Vault', popupUpdatedToVaultMessage)

WebUI.delay(2)

WebUI.closeBrowser()

