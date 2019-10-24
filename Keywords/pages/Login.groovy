package pages

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utilities.SafeActions

public class Login {
	SafeActions safe = new SafeActions()
	@Keyword
	def login(String uName,String pwd) {
		safe.safeType(findTestObject('Object Repository/Pages/Login/userName'),uName,"Enter userName",(([10]) as int[]))
		safe.safeType(findTestObject('Object Repository/Pages/Login/password'),pwd,"Enter password",(([10]) as int[]))
		safe.safeClickWithoutScroll(findTestObject('Object Repository/Pages/Login/login'), "Click on Login", (([10]) as int[]))
	}
}
