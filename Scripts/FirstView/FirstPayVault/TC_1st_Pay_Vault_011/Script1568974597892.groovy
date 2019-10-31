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

CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'pages.Login.login'(uName, password)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

WebUI.focus(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'))

CustomKeywords.'utilities.SafeActions.javascriptclick'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), GlobalVariable.PageLoadTime)

WebUI.delay(GlobalVariable.delayForElement)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), 'Click on FistPayVault tab', 
        (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_CreateVault'), 
    'Click on CreateVault button', (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/input_VaultReferenceNumber'), 5)

vaultReference = CustomKeywords.'utilities.SafeActions.timeWithMilliSeconds'()

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_VaultReferenceNumber'), vaultReference, 
    'Entering Vault Reference Number', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_CreditCardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([GlobalVariable.PageLoadTime]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
not_run: WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDown_ExpirationMonth'), 
    cardMonth, 'Expiration Month', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/FirstPayVault/dropDown_ExpirationYear'), 
    cardYear, 'year', (([GlobalVariable.PageLoadTime]) as int[]))

not_run: WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_ContactName'), customerName, 'Enter Contact Name', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_PostalCode'), postalCode, 'Enter Postal Code', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_Address'), address, 'Enter ddress', 
        (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/chekBox_AddShippingInformation'), 
    GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/input_ShippingMethod'), shippingMethod, 
    'Enter Shipping Method', (([GlobalVariable.PageLoadTime]) as int[]))

CustomKeywords.'utilities.SafeActions.safeCheckForElement'(findTestObject('Pages/FirstPayVault/checkbox_SameAsBillingInformation'), 
    GlobalVariable.PageLoadTime)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Create'), 'Click on Create Button', 
        (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.delay(2)

popupSavedToVaultMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/popup_SavedToVaultMessage'), 
    GlobalVariable.PageLoadTime)

flag = CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Successfully Saved to Vault', popupSavedToVaultMessage)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_SearchVault_InPopup'), 
    'Search Vault in Popup', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/FirstPayVault/filter_SearchPayVaultByVaultReferenceNumber'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/FirstPayVault/filter_SearchPayVaultByVaultReferenceNumber'), 
    vaultReference, 'Enter Vault Reference Number', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_Search'), 'Click On Search button', 
        (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), GlobalVariable.PageLoadTime)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.FirstPayVault.verifyInvoiceRecord'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), vaultReference)

not_run: WebUI.delay(2)

/*WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/button_SearchVault_InPopup'), 
    'Click on Search Vault in Popup', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

WebUI.delay(1)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/button_Search'), 'Click On Search button', 
        (([5]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 5)

CustomKeywords.'pages.FirstPayVault.deleteInvoiceRecord'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), findTestObject('Pages/FirstPayVault/button_deleteFromVault'), vaultReference)

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

deleteVaultPopupMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/alertMessageAfterDeleteVault'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Vault Deletion successfully completed', deleteVaultPopupMessage)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/closeLocatorForDeletePopupMessage'), 
    'Click on Close button', (([5]) as int[]))
*/
WebUI.closeBrowser()

