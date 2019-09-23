package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.*
import org.openqa.selenium.support.ui.*

import java.text.DateFormat
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable as GlobalVariable

public class SafeActions {

	Sync syncObj = new Sync()

	@Keyword
	def openBrowser(String url,int... optionWaitTime){
		boolean bflag=true
		int waitTime=0
		try{
			KeywordUtil.logInfo("Opening Browser")
			waitTime = syncObj.getWaitTime(optionWaitTime)

			if(bflag){
				WebUI.openBrowser(url)
				WebUI.maximizeWindow()
				KeywordUtil.logInfo("Browser Launched Successfully")
			}
			else{
				KeywordUtil.markFailed("Unable to open browser with url:${url} in time - ${waitTime} Seconds")
			}
		}

		catch(StepFailedException e){
			KeywordUtil.markFailed("unable to open Browser with url:${url}")
		}
	}

	@Keyword
	def safeType(TestObject testObj,String text,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=0;
		try{
			waitTime = syncObj.getWaitTime(optionWaitTime)
			if(WebUI.verifyElementPresent(testObj,waitTime)){
				highLightElement(testObj,waitTime)
				WebUI.click(testObj)
				WebUI.setText(testObj, text)
			}
			else{
				KeywordUtil.markError(syncObj.getTestCaseName()+"unable to enter"+ text +" in "+friendlyWebElementName+" in time -"+waitTime+"seconds")
			}
		}
		catch(Exception e) {
			KeywordUtil.markError("unable to enter"+ text +" in "+friendlyWebElementName+" in time -"+waitTime+"seconds")
		}
	}
	
	@Keyword
	def safeType1(TestObject testObj,int text,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=0;
		try{
			waitTime = syncObj.getWaitTime(optionWaitTime)
			if(WebUI.verifyElementPresent(testObj,waitTime)){
				highLightElement(testObj,waitTime)
				WebUI.click(testObj)
				WebUI.setText(testObj, text)
			}
			else{
				KeywordUtil.markError(syncObj.getTestCaseName()+"unable to enter"+ text +" in "+friendlyWebElementName+" in time -"+waitTime+"seconds")
			}
		}
		catch(Exception e) {
			KeywordUtil.markError("unable to enter"+ text +" in "+friendlyWebElementName+" in time -"+waitTime+"seconds")
		}
	}

	@Keyword
	def safeSelectOptionInDropDownByVisibleText(TestObject testObj,String text,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=0;
		try{
			waitTime = syncObj.getWaitTime(optionWaitTime)
			if(WebUI.verifyElementPresent(testObj,waitTime)){
				highLightElement(testObj,waitTime)
				WebUI.click(testObj)
				WebUI.selectOptionByLabel(testObj, text, false)
			}
			else{
				KeywordUtil.markError(syncObj.getTestCaseName()+"unable to select"+ text +" in "+friendlyWebElementName+" in time -"+waitTime+"seconds")
			}
		}
		catch(Exception e) {
			KeywordUtil.markError(syncObj.getTestCaseName()+"unable to select"+ text +" in "+friendlyWebElementName+" in time -"+waitTime+"seconds")
		}
	}

	@Keyword
	def dropDownSelect(TestObject[] selectObj){
		WebUI.click(selectObj[0])
		WebUI.click(selectObj[1])
	}

	@Keyword
	def safeClickWithoutScroll(TestObject testObj,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=0;
		try{
			KeywordUtil.logInfo("Safe Click Without scroll")
			waitTime = syncObj.getWaitTime(optionWaitTime)
			if(waitUntilClickable(testObj,friendlyWebElementName,waitTime)){
				highLightElement(testObj,waitTime)
				WebUI.click(testObj)
				KeywordUtil.logInfo(syncObj.getTestCaseName()+" click on the "+friendlyWebElementName)
			}
			else{
				KeywordUtil.markFailed(syncObj.getTestCaseName()+friendlyWebElementName+" is not clickable in time - "+waitTime+"seconds")
			}
		}
		catch(Exception e){
			KeywordUtil.markError(syncObj.getTestCaseName()+friendlyWebElementName+" is not clickable in time - "+waitTime+"seconds")
		}
	}

	@Keyword
	def safeClickWithoutScrollOnLabel(TestObject testObj,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=0;
		try{
			KeywordUtil.logInfo("Safe Click Without scroll On Label")
			waitTime = syncObj.getWaitTime(optionWaitTime)
			KeywordUtil.logInfo(syncObj.getTestCaseName()+" click on the "+friendlyWebElementName)
			highLightElement(testObj,waitTime)
			WebUI.click(testObj)
		}
		catch(Exception e){
			KeywordUtil.markError(syncObj.getTestCaseName()+friendlyWebElementName+" is not clickable in time - "+waitTime+"seconds")
		}
	}

	@Keyword
	def waitUntilClickable(TestObject testObj,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=syncObj.getWaitTime(optionWaitTime)
		boolean bFlag=false
		try{
			KeywordUtil.logInfo(syncObj.getTestCaseName()+"waiting until "+friendlyWebElementName+" is Clickable")
			WebUI.waitForElementClickable(testObj,waitTime)
			if(WebUI.verifyElementVisible(testObj)){
				bFlag=true
				//KeywordUtil.logInfo(syncObj.getTestCaseName()+friendlyWebElementName+" is displayed and is Clickable")
			}
			else{
				KeywordUtil.markFailed(syncObj.getTestCaseName()+friendlyWebElementName+" is not visible to perform Click action")
			}
		}
		catch(Exception e){
			KeywordUtil.markError(syncObj.getTestCaseName()+friendlyWebElementName+" is not Clickable")
		}
	}

	@Keyword
	def safeClickwithScroll(TestObject testObj,String friendlyWebElementName,int... optionWaitTime){
		int waitTime=0
		try{
			waitTime=syncObj.getWaitTime(optionWaitTime)
			WebUI.scrollToElement(testObj, waitTime)
			if(waitUntilClickable(testObj, friendlyWebElementName, waitTime)){
				highLightElement(testObj,waitTime)
				WebUI.click(testObj)
				KeywordUtil.logInfo(syncObj.getTestCaseName()+" Clicked on the "+friendlyWebElementName)
			}
			else{
				KeywordUtil.markFailed(friendlyWebElementName+" is not clickable in time -"+waitTime+" seconds")
			}
		}
		catch(Exception e){
			KeywordUtil.markError(friendlyWebElementName+" was not found on the webpage")
		}
	}

	@Keyword
	def selectSeleniumCode(TestObject testObj,String value){
		WebElement ele=WebUiCommonHelper.findWebElement(testObj, 10)
		Select s=new Select(ele);
		//s.selectByIndex(value)
		//s.selectByValue(value)
		s.selectByVisibleText(value)
	}

	@Keyword
	def selectSeleniumCodeYear(TestObject testObj,String value){
		WebElement ele=WebUiCommonHelper.findWebElement(testObj, 10)
		Select s=new Select(ele);
		//s.selectByIndex(Value)
		s.selectByValue(value)
		//s.selectByVisibleText(value)
	}

	@Keyword
	def safeGetText(TestObject testObj,int waitTime){
		String sValue=null
		try{
			if(WebUI.verifyElementPresent(testObj, waitTime)){
				highLightElement(testObj,waitTime)
				sValue=WebUI.getText(testObj)
			}
			else{
				KeywordUtil.markFailed("Unable to element in time - "+waitTime)
			}
		}
		catch(Exception e){
			KeywordUtil.markError("Unable to element in time - "+waitTime)
		}
		println sValue
		return sValue
	}

	@Keyword
	def safeCheckForElement(TestObject testObj,int waitTime){
		try{
			if(WebUI.verifyElementPresent(testObj, waitTime)){
				highLightElement(testObj,waitTime)
				WebUI.check(testObj)
			}
			else{
				KeywordUtil.markFailed("Element is not visible to check")
			}
		}
		catch(Exception e){
			KeywordUtil.markError("Cannot check for Checkbox")
		}
	}
	@Keyword
	def verifyInvoicePresent(TestObject testObj){
		String invoiceNumber = WebUI.getText(testObj)
		return invoiceNumber
	}

	@Keyword
	def verifyPopupMessage(String expectedMessage,String popupMessage){
		println expectedMessage
		println popupMessage
		boolean flag=false
		if(expectedMessage.trim().equalsIgnoreCase(popupMessage.trim())){
			println "Matched"
			flag=true
			KeywordUtil.markPassed("Popup Message : ${popupMessage} matched with expected message : ${expectedMessage}")
		}
		else{
			flag=false
			println "Not Matched"
			KeywordUtil.markFailed("Popup Message : ${popupMessage} didnot match with expected message : ${expectedMessage}")
		}
		return flag
	}


	@Keyword
	def getAttributeValue(TestObject testObject,String tabName){
		String attributeValue=WebUI.getAttribute(testObject, "class")
		println attributeValue
		if(attributeValue.contains("active_tab")){

			KeywordUtil.markPassed("The screen is ${tabName} screen")
		}
		else{
			KeywordUtil.markFailed("The screen is not ${tabName} screen")
		}
		return attributeValue
	}

	@Keyword
	def getAttribute(TestObject testObject,String tabName){
		String attributeValue=WebUI.getAttribute(testObject, "value")
		println attributeValue
		/*if(attributeValue.contains("active_tab")){
		 KeywordUtil.markPassed("The screen is ${tabName} screen")
		 }
		 else{
		 KeywordUtil.markFailed("The screen is not ${tabName} screen")
		 }*/
		return attributeValue
	}

	@Keyword
	def highLightElement(TestObject testObject,int timeOut){
		if(GlobalVariable.HighLightElements.equalsIgnoreCase("true")){
			println "in highlight method"
			String attributeValue="border:2px solid blue";
			WebDriver driver = DriverFactory.getWebDriver()
			JavascriptExecutor je=(JavascriptExecutor)driver
			WebElement ele=WebUiCommonHelper.findWebElement(testObject, timeOut)
			String getAttribute=ele.getAttribute("style")
			je.executeScript("arguments[0].setAttribute('style',arguments[1]);", ele,attributeValue)
			//WebUI.executeJavaScript('arguments[0].setAttribute("style",attributeValue);', ele)
			try{
				Thread.sleep(500)
			}
			catch(InterruptedException e){
				KeywordUtil.markError(syncObj.getTestCaseName()+"Sleep Interrupted - ")
			}
			//WebUI.executeJavaScript('arguments[0].setAttribute("style",getAttribute);', ele)
			je.executeScript("arguments[0].setAttribute('style',arguments[1]);", ele,getAttribute)
		}
	}

	@Keyword
	def highLightElement(WebElement element,int timeOut){
		if(GlobalVariable.HighLightElements.equalsIgnoreCase("true")){
			println "in highlight method"
			String attributeValue="border:2px solid blue";
			WebDriver driver = DriverFactory.getWebDriver()
			JavascriptExecutor je=(JavascriptExecutor)driver
			//WebElement ele=WebUiCommonHelper.findWebElement(testObject, timeOut)
			String getAttribute=element.getAttribute("style")
			je.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,attributeValue)
			//WebUI.executeJavaScript('arguments[0].setAttribute("style",attributeValue);', ele)
			try{
				Thread.sleep(500)
			}
			catch(InterruptedException e){
				KeywordUtil.markError(syncObj.getTestCaseName()+"Sleep Interrupted - ")
			}
			//WebUI.executeJavaScript('arguments[0].setAttribute("style",getAttribute);', ele)
			je.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,getAttribute)
		}
	}

	/*@Keyword
	 def selectUsingJavascript(TestObject selectObject,TestObject optionObject,int timeOut){
	 WebDriver driver = DriverFactory.getWebDriver()
	 JavascriptExecutor je=(JavascriptExecutor)driver
	 WebElement selectEle=WebUiCommonHelper.findWebElement(selectObject, timeOut)
	 WebElement optionEle=WebUiCommonHelper.findWebElement(optionObject, timeOut)
	 je.executeScript("arguments[0].click();",selectEle)
	 Thread.sleep(200)
	 je.executeScript("arguments[0].click();",optionEle)
	 WebUI.executeJavaScript("arguments[0].click();", selectEle)
	 Thread.sleep(100)
	 WebUI.executeJavaScript("arguments[0].click();", optionEle)
	 }*/
	/*@Keyword
	 def selectUsingJavascript1(){
	 WebDriver driver = DriverFactory.getWebDriver()
	 JavascriptExecutor je=(JavascriptExecutor)driver
	 WebElement selectEle = driver.findElement(By.xpath("(//select[@id='select-expiration-month'])[1]"))
	 WebElement optionEle = driver.findElement(By.xpath("//section[@id='p-Sale']//*[@id='select-expiration-month']/option[text()='December']"))
	 //WebElement selectEle=WebUiCommonHelper.findWebElement(selectObject, timeOut)
	 //WebElement optionEle=WebUiCommonHelper.findWebElement(optionObject, timeOut)
	 je.executeScript("arguments[0].click();",selectEle)
	 Thread.sleep(200)
	 je.executeScript("arguments[0].click();",optionEle)
	 WebUI.executeJavaScript("arguments[0].click();", selectEle)
	 Thread.sleep(100)
	 WebUI.executeJavaScript("arguments[0].click();", optionEle)
	 }*/

	@Keyword
	def javascriptModifyClassAttribute(TestObject testObject,int timeOut){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement ele=WebUiCommonHelper.findWebElement(testObject, timeOut)
		JavascriptExecutor je=(JavascriptExecutor)driver
		je.executeScript("arguments[0].setAttribute('class',arguments[1]);", ele,"form-control parsley-success")
	}

	@Keyword
	def timeWithMilliSeconds(){
		Date date = new Date()
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
		String date_Str = formatDate.format(date)
		println date_Str
		return date_Str
	}
}
