package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class DynamicLocators {


	String idLocator = '//*[@id="%s"]'
	String checkBoxLabelLocator='//section[@id="p-%s"]//*[text()="%s"]'
	String labelLocator='//*[text()="%s"]/parent::div/following-sibling::div//label[text()="Yes"]'
	String dateLocator='//td[text()="%s" and @class="day"]'
	String locatorForCheckBox='//section[@id="p-%s"]//*[text()="%s"]/ancestor::div[1]/input'

	@Keyword
	def createDynamicLocators(String idValue){
		idLocator=String.format(idLocator,idValue)
		println idLocator
		TestObject testObj=new TestObject()
		testObj.addProperty("xpath",ConditionType.EQUALS,idLocator)
		return testObj
	}
	@Keyword
	def createDynamicCheckboxLocatorForCheckBox(String tabName,String checkBoxCardPresence){
		checkBoxLabelLocator=String.format(checkBoxLabelLocator, tabName,checkBoxCardPresence)
		TestObject testObj=new TestObject()
		testObj.addProperty("xpath",ConditionType.EQUALS,checkBoxLabelLocator)
		return testObj
	}
	@Keyword
	def createDynamicLocatorForCheckBox(String TabName,String checkBoxValue){
		locatorForCheckBox=String.format(locatorForCheckBox,TabName,checkBoxValue)
		println locatorForCheckBox
		TestObject testObj=new TestObject()
		testObj.addProperty("xpath",ConditionType.EQUALS,locatorForCheckBox)
		return testObj
	}

	@Keyword
	def createDynamicLocatorsForLabels(String labelValue){
		labelLocator=String.format(labelLocator,labelValue)
		println labelLocator
		TestObject testObj=new TestObject()
		testObj.addProperty("xpath",ConditionType.EQUALS,labelLocator)
		return testObj
	}

	@Keyword
	def createDynamicLocatorsForDate(String dateValue){
		dateLocator=String.format(dateLocator,dateValue)
		println dateValue
		TestObject testObj=new TestObject()
		testObj.addProperty("xpath",ConditionType.EQUALS,dateLocator)
		return testObj
	}
}
