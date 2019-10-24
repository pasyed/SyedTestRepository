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

not_run: WebUI.delay(delayForPageLoad)

not_run: CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_AccountType'), 
    accountType, 'Select by Value', (([25]) as int[]))

not_run: WebUI.delay(3)

CustomKeywords.'utilities.SafeActions.openBrowser'('https://q-www-firstview-net.faps.net/MVC/Account/Login', (([10]) as int[]))

CustomKeywords.'pages.Login.login'('ZenQRetail', 'P@ssword1')

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('Sale', 'Manually Keyed', 5)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), 60)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), '550', 'Enter Amount into Amount text box', 
        (([20]) as int[]))

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), 10)

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'('Sale', 'Card Not Present', 5)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), '4111111111111111', 'Entering Card Number', 
        (([10]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'September', 'Select Expiration Month', (([5]) as int[]))

//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    '2022', 'Select Expiration Year', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScrollOnLabel'(findTestObject('Pages/Sale/label_ExpirationYear'), 
    'Click on Exp Year label', (([GlobalVariable.PageLoadTime]) as int[]))

//CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'September')
//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
//CustomKeywords.'utilities.SafeActions.selectSeleniumCodeYear'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2022')
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_SecurityCode'), '111', 'Enter Security code', 
        (([GlobalVariable.delayForElement]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), 10)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), 10)

CustomKeywords.'pages.Sale.verifyIfAdditionalPromptingIsChecked'('Save to Vault?', 10)

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

WebUI.scrollToElement(findTestObject('Pages/Sale/input_VaultReferenceNumber'), 10)

vaultReference = CustomKeywords.'utilities.SafeActions.timeWithMilliSeconds'()

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_VaultReferenceNumber'), vaultReference, 
    'Enter Vault Reference Number', (([5]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_SaveToVault'), 'Click on Save To Vault button', 
        (([10]) as int[]))

popupFromMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/popupAfterClickOn_SaveToVault'), 
    GlobalVariable.PageLoadTime)

String saveToVaultPopUpMessage = ('Successfully Saved to Vault: Reference Number:' + ' ') + vaultReference

CustomKeywords.'utilities.SafeActions.verifyPopupMessage'(saveToVaultPopUpMessage, popupFromMessage)

WebUI.delay(3)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/close_TextBox'), 'Click on Close', 
        (([15]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([GlobalVariable.PageLoadTime]) as int[]))

WebUI.delay(5)

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/FirstPayVault/tab_FirstPayVault'), 'First Pay Vault Tab', 
        (([10]) as int[]))

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

/*CustomKeywords.'pages.FirstPayVault.deleteInvoiceRecord'(findTestObject('Pages/FirstPayVault/footer_NextButton'), findTestObject(
        'Pages/FirstPayVault/page_Number'), findTestObject('Pages/FirstPayVault/button_deleteFromVault'), vaultReference)

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

deleteVaultPopupMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/FirstPayVault/alertMessageAfterDeleteVault'), 
    GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.verifyPopupMessage'('Vault Deletion successfully completed', deleteVaultPopupMessage)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/FirstPayVault/closeLocatorForDeletePopupMessage'), 
    'Click on Close button', (([5]) as int[]))*/
WebUI.closeBrowser()

