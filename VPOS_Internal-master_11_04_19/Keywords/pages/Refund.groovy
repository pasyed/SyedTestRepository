package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import utilities.DynamicLocators
import utilities.SafeActions
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class Refund {
	SafeActions safeObj=new SafeActions()
	DynamicLocators dl=new DynamicLocators()

	@Keyword
	def verifyIfCardInformationIsChecked(String tabName,String checkboxValue,int timeOut){
		TestObject checkboxObject = dl.createDynamicCheckboxLocatorForCheckBox(tabName,checkboxValue)
		boolean checkElementStatus
		try{
			checkElementStatus = WebUI.verifyElementChecked(checkboxObject, timeOut, FailureHandling.OPTIONAL)
		}
		catch(Exception e){
			//WebUI.click(checkboxObject)
			//WebUI.takeScreenshot(safeObj.reportsFolderPath+"/verifyIfEntryModeIsChecked.png")
			KeywordUtil.logInfo("This is the error from Catch block")
		}
		//boolean checkElementStatus = WebUI.verifyElementNotChecked(testObj, timeOut)
		if(checkElementStatus){
			KeywordUtil.logInfo("The specified checkbox is checked")
		}
		else{
			WebUI.check(checkboxObject)
			KeywordUtil.logInfo("Checked for specified checkbox")
		}
		return checkElementStatus
	}
}
