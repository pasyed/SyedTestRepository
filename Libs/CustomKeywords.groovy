
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import org.openqa.selenium.WebElement


def static "pages.Login.login"(
    	String uName	
     , 	String pwd	) {
    (new pages.Login()).login(
        	uName
         , 	pwd)
}

def static "utilities.DynamicLocators.createDynamicLocators"(
    	String idValue	) {
    (new utilities.DynamicLocators()).createDynamicLocators(
        	idValue)
}

def static "utilities.DynamicLocators.createDynamicLocatorForCheckBox"(
    	String TabName	
     , 	String checkBoxValue	) {
    (new utilities.DynamicLocators()).createDynamicLocatorForCheckBox(
        	TabName
         , 	checkBoxValue)
}

def static "utilities.DynamicLocators.createDynamicLocatorsForLabels"(
    	String labelValue	) {
    (new utilities.DynamicLocators()).createDynamicLocatorsForLabels(
        	labelValue)
}

def static "utilities.DynamicLocators.createDynamicLocatorsForDate"(
    	String dateValue	) {
    (new utilities.DynamicLocators()).createDynamicLocatorsForDate(
        	dateValue)
}

def static "pages.Transaction_Management.verifyInvoiceRecord"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String invoice	
     , 	String amount	) {
    (new pages.Transaction_Management()).verifyInvoiceRecord(
        	nextObj
         , 	numberOfPages
         , 	invoice
         , 	amount)
}

def static "pages.Transaction_Management.getInvoiceColumnCount"() {
    (new pages.Transaction_Management()).getInvoiceColumnCount()
}

def static "pages.SendCode.verifyPage"() {
    (new pages.SendCode()).verifyPage()
}

def static "pages.SendCode.clickonUserSettings"() {
    (new pages.SendCode()).clickonUserSettings()
}

def static "pages.FirstPayVault.verifyVaultSaved"(
    	boolean flag	) {
    (new pages.FirstPayVault()).verifyVaultSaved(
        	flag)
}

def static "pages.FirstPayVault.clickOnEdit"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).clickOnEdit(
        	nextObj
         , 	numberOfPages
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.clickOnMakeAPayment"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).clickOnMakeAPayment(
        	nextObj
         , 	numberOfPages
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.clickOnDelete"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	TestObject deleteVaultButton	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).clickOnDelete(
        	nextObj
         , 	numberOfPages
         , 	deleteVaultButton
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.getRowAndColumn"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).getRowAndColumn(
        	nextObj
         , 	numberOfPages
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.deleteInvoiceRecord"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	TestObject deleteVaultButton	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).deleteInvoiceRecord(
        	nextObj
         , 	numberOfPages
         , 	deleteVaultButton
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.verifyInvoiceRecord"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).verifyInvoiceRecord(
        	nextObj
         , 	numberOfPages
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.getCount"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String vaultRefNumber	) {
    (new pages.FirstPayVault()).getCount(
        	nextObj
         , 	numberOfPages
         , 	vaultRefNumber)
}

def static "pages.FirstPayVault.verifyAllRecordsFilteredByCardNumber"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String creditCardNumber	) {
    (new pages.FirstPayVault()).verifyAllRecordsFilteredByCardNumber(
        	nextObj
         , 	numberOfPages
         , 	creditCardNumber)
}

def static "pages.FirstPayVault.getInvoiceColumnCount"(
    	String columnName	) {
    (new pages.FirstPayVault()).getInvoiceColumnCount(
        	columnName)
}

def static "pages.FirstPayVault.verifyAmountIsNotZero"(
    	String amount	) {
    (new pages.FirstPayVault()).verifyAmountIsNotZero(
        	amount)
}

def static "pages.FirstPayVault.verifyStrings"(
    	String expectedMessage	
     , 	String popupMessage	) {
    (new pages.FirstPayVault()).verifyStrings(
        	expectedMessage
         , 	popupMessage)
}

def static "pages.FirstPayVault.verifyCardNumber"(
    	String expectedMessage	
     , 	String popupMessage	) {
    (new pages.FirstPayVault()).verifyCardNumber(
        	expectedMessage
         , 	popupMessage)
}

def static "pages.Future_Payments.verifyInvoiceRecord"(
    	TestObject nextObj	
     , 	TestObject numberOfPages	
     , 	String invoice	
     , 	String amount	) {
    (new pages.Future_Payments()).verifyInvoiceRecord(
        	nextObj
         , 	numberOfPages
         , 	invoice
         , 	amount)
}

def static "pages.Future_Payments.getInvoiceColumnCount"() {
    (new pages.Future_Payments()).getInvoiceColumnCount()
}

def static "pages.Sale.verify1stPayVposPage"(
    	TestObject testObj	) {
    (new pages.Sale()).verify1stPayVposPage(
        	testObj)
}

def static "pages.Sale.verifyIfEntryModeIsChecked"(
    	String tabName	
     , 	String checkboxValue	
     , 	int timeOut	) {
    (new pages.Sale()).verifyIfEntryModeIsChecked(
        	tabName
         , 	checkboxValue
         , 	timeOut)
}

def static "pages.Sale.verifyIfAdditionalPromptingIsChecked"(
    	String labelValue	
     , 	int timeOut	) {
    (new pages.Sale()).verifyIfAdditionalPromptingIsChecked(
        	labelValue
         , 	timeOut)
}

def static "pages.Sale.verifyTransactionCompletePage"(
    	TestObject testObj	) {
    (new pages.Sale()).verifyTransactionCompletePage(
        	testObj)
}

def static "pages.Sale.selectMonthYear"(
    	TestObject testObj	
     , 	TestObject testObj1	
     , 	String month	
     , 	String yearToSelect	) {
    (new pages.Sale()).selectMonthYear(
        	testObj
         , 	testObj1
         , 	month
         , 	yearToSelect)
}

def static "pages.Sale.selectDate"(
    	int date	) {
    (new pages.Sale()).selectDate(
        	date)
}

def static "utilities.Sync.getWaitTime"(
    	int[] optionalWaitArray	) {
    (new utilities.Sync()).getWaitTime(
        	optionalWaitArray)
}

def static "utilities.SafeActions.openBrowser"(
    	String url	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).openBrowser(
        	url
         , 	optionWaitTime)
}

def static "utilities.SafeActions.safeType"(
    	TestObject testObj	
     , 	String text	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).safeType(
        	testObj
         , 	text
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.safeType1"(
    	TestObject testObj	
     , 	int text	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).safeType1(
        	testObj
         , 	text
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.safeSelectOptionInDropDownByVisibleText"(
    	TestObject testObj	
     , 	String text	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).safeSelectOptionInDropDownByVisibleText(
        	testObj
         , 	text
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.dropDownSelect"(
    	TestObject[] selectObj	) {
    (new utilities.SafeActions()).dropDownSelect(
        	selectObj)
}

def static "utilities.SafeActions.safeClickWithoutScroll"(
    	TestObject testObj	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).safeClickWithoutScroll(
        	testObj
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.safeClickWithoutScrollOnLabel"(
    	TestObject testObj	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).safeClickWithoutScrollOnLabel(
        	testObj
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.waitUntilClickable"(
    	TestObject testObj	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).waitUntilClickable(
        	testObj
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.safeClickwithScroll"(
    	TestObject testObj	
     , 	String friendlyWebElementName	
     , 	int[] optionWaitTime	) {
    (new utilities.SafeActions()).safeClickwithScroll(
        	testObj
         , 	friendlyWebElementName
         , 	optionWaitTime)
}

def static "utilities.SafeActions.selectSeleniumCode"(
    	TestObject testObj	
     , 	String value	) {
    (new utilities.SafeActions()).selectSeleniumCode(
        	testObj
         , 	value)
}

def static "utilities.SafeActions.selectSeleniumCodeYear"(
    	TestObject testObj	
     , 	String value	) {
    (new utilities.SafeActions()).selectSeleniumCodeYear(
        	testObj
         , 	value)
}

def static "utilities.SafeActions.safeGetText"(
    	TestObject testObj	
     , 	int waitTime	) {
    (new utilities.SafeActions()).safeGetText(
        	testObj
         , 	waitTime)
}

def static "utilities.SafeActions.safeCheckForElement"(
    	TestObject testObj	
     , 	int waitTime	) {
    (new utilities.SafeActions()).safeCheckForElement(
        	testObj
         , 	waitTime)
}

def static "utilities.SafeActions.verifyInvoicePresent"(
    	TestObject testObj	) {
    (new utilities.SafeActions()).verifyInvoicePresent(
        	testObj)
}

def static "utilities.SafeActions.verifyPopupMessage"(
    	String expectedMessage	
     , 	String popupMessage	) {
    (new utilities.SafeActions()).verifyPopupMessage(
        	expectedMessage
         , 	popupMessage)
}

def static "utilities.SafeActions.getAttributeValue"(
    	TestObject testObject	
     , 	String tabName	) {
    (new utilities.SafeActions()).getAttributeValue(
        	testObject
         , 	tabName)
}

def static "utilities.SafeActions.getAttribute"(
    	TestObject testObject	
     , 	String tabName	) {
    (new utilities.SafeActions()).getAttribute(
        	testObject
         , 	tabName)
}

def static "utilities.SafeActions.highLightElement"(
    	TestObject testObject	
     , 	int timeOut	) {
    (new utilities.SafeActions()).highLightElement(
        	testObject
         , 	timeOut)
}

def static "utilities.SafeActions.safeTypeUsingJavascript"(
    	TestObject testObject	
     , 	String amount	) {
    (new utilities.SafeActions()).safeTypeUsingJavascript(
        	testObject
         , 	amount)
}

def static "utilities.SafeActions.highLightElement"(
    	WebElement element	
     , 	int timeOut	) {
    (new utilities.SafeActions()).highLightElement(
        	element
         , 	timeOut)
}

def static "utilities.SafeActions.javascriptModifyClassAttribute"(
    	TestObject testObject	
     , 	int timeOut	) {
    (new utilities.SafeActions()).javascriptModifyClassAttribute(
        	testObject
         , 	timeOut)
}

def static "utilities.SafeActions.javascriptclick"(
    	TestObject testObject	
     , 	int timeOut	) {
    (new utilities.SafeActions()).javascriptclick(
        	testObject
         , 	timeOut)
}

def static "utilities.SafeActions.timeWithMilliSeconds"() {
    (new utilities.SafeActions()).timeWithMilliSeconds()
}
