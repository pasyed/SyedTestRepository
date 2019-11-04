package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utilities.DynamicLocators
import utilities.SafeActions

public class Sale {
	SafeActions safeObj=new SafeActions()
	DynamicLocators dl=new DynamicLocators()
	@Keyword
	def verify1stPayVposPage(TestObject testObj){
		boolean imgDisplayed = WebUI.verifyImagePresent(testObj)
		if(imgDisplayed){
			KeywordUtil.markPassed("The screen is 1stPayVPOS screen")
		}
		else{
			KeywordUtil.markFailed("The screen is not 1stPayVPOS screen")
		}
	}

	/*Pass Tab Name as "Sale" or "Refund" or other tab name if exists(first letter should be capital letter and remaining small)*/
	@Keyword
	def verifyIfEntryModeIsChecked(String tabName,String checkboxValue,int timeOut){
		TestObject checkboxObject = dl.createDynamicLocatorForCheckBox(tabName,checkboxValue)
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

	@Keyword
	def verifyIfAdditionalPromptingIsChecked(String labelValue,int timeOut){
		TestObject checkboxObject = dl.createDynamicLocatorsForLabels(labelValue)
		try{
			if(!WebUI.verifyElementChecked(checkboxObject, timeOut,FailureHandling.OPTIONAL)){
				WebUI.click(checkboxObject)
				KeywordUtil.logInfo("The specified checkbox is checked Now")
			}
			else{
				KeywordUtil.logInfo("The specified checkbox is checked by default")
			}
		}
		catch(StepFailedException e){
			//WebUI.click(checkboxObject)
			//WebUI.takeScreenshot(safeObj.reportsFolderPath+"/verifyIfAdditionalPromptingIsChecked.png")
			KeywordUtil.logInfo("This is the error from Catch block")
		}
		/*boolean checkElementStatus = WebUI.verifyElementChecked(checkboxObject, timeOut)
		 //boolean checkElementStatus = WebUI.verifyElementNotChecked(testObj, timeOut)
		 if(checkElementStatus){
		 KeywordUtil.logInfo("The specified checkbox is checked")
		 }
		 else{
		 WebUI.click(checkboxObject)
		 KeywordUtil.logInfo("Checked for specified checkbox")
		 }
		 }
		 catch(Exception e){
		 //KeywordUtil.markFailed("The specified checkbox is checked")
		 println e.getMessage()
		 }*/
		/*return checkElementStatus*/
	}


	@Keyword
	def verifyTransactionCompletePage(TestObject testObj){
		try{
			boolean headingDisplayed = WebUI.verifyElementPresent(testObj, 60)
			if(headingDisplayed){
				safeObj.highLightElement(testObj, GlobalVariable.delayBetweenTestSteps)
				KeywordUtil.markPassed("The screen is Transaction Complete screen")

			}
			else{
				KeywordUtil.markFailed("The screen is not Transaction Complete screen")
			}
		}
		catch(Exception e){
			//WebUI.takeScreenshot(safeObj.reportsFolderPath+"/verifyTransactionCompletePage.png")
			KeywordUtil.markFailed("unable to verify the Transaction Complete page")
		}
	}

	@Keyword
	def selectMonthYear(TestObject testObj,TestObject testObj1,String month,String yearToSelect){
		int year=Integer.parseInt(yearToSelect)
		String yearMonth_Value=WebUI.getText(testObj)
		println yearMonth_Value
		//String yearVal=Integer.toString(year)
		String monthYear=month+" "+yearToSelect
		println monthYear
		Calendar cal=Calendar.getInstance()
		int currentYear = cal.get(Calendar.YEAR)
		//String currentYear_Str=Integer.toString(currentYear)
		try{
			if(year>=currentYear){
				while(!yearMonth_Value.equalsIgnoreCase(monthYear)){
					println yearMonth_Value
					WebUI.click(testObj1)
					yearMonth_Value=WebUI.getText(testObj)
				}
			}
			else{
				KeywordUtil.markFailed("Year cannot be selected as the specified year is less than current year")
			}
		}
		catch(Exception e){
			KeywordUtil.markFailed("unable to select the specified Month and Year")
		}
		println currentYear
	}

	/*@Keyword
	 def getStringFromElement(WebElement ele){
	 String eleXpath = ele.toString()
	 return eleXpath.substring(eleXpath.lastIndexOf("-> xpath: ")+10, eleXpath.lastIndexOf("]"))
	 }*/


	@Keyword
	def selectDate(int date){
		try{
			String date_Str=Integer.toString(date)
			TestObject testObj=dl.createDynamicLocatorsForDate(date_Str)
			WebUI.click(testObj)
		}
		catch(Exception e){
			KeywordUtil.markFailed("unable to select the Date")
		}
	}




}
