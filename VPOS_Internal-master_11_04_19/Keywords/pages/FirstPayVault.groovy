package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert
import org.openqa.selenium.By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utilities.SafeActions

public class FirstPayVault {

	WebDriver driver=DriverFactory.getWebDriver()
	def map_Tablecount=[:]
	SafeActions safeActions=new SafeActions()

	@Keyword
	def verifyVaultSaved(boolean flag){
		if(flag){
			KeywordUtil.logInfo("Successfully created Vault")
			WebUI.closeBrowser()
		}
		else{
			KeywordUtil.markFailed("Creation of Vault failed")
			WebUI.closeBrowser()
		}
	}

	@Keyword
	def clickOnEdit(TestObject nextObj,TestObject numberOfPages,String vaultRefNumber){
		int rowNumber=getRowAndColumn(nextObj,numberOfPages,vaultRefNumber)
		getInvoiceColumnCount("Edit")
		int columnCount = map_Tablecount['Edit']
		if(rowNumber==-1){
			KeywordUtil.markFailed("Transaction is not visible to perform Edit action")
		}
		else{
			rowNumber=rowNumber+1
			columnCount=columnCount+1
			String editXpath=String.format("//table[@id='transactionTable']/tbody/tr[%d]/td[%d]/div/img",rowNumber,columnCount)
			WebElement editElement=driver.findElement(By.xpath(editXpath))
			safeActions.highLightElement(editElement, GlobalVariable.delayBetweenTestSteps)
			editElement.click()
		}
	}

	@Keyword
	def clickOnMakeAPayment(TestObject nextObj,TestObject numberOfPages,String vaultRefNumber){
		int rowNumber=getRowAndColumn(nextObj,numberOfPages,vaultRefNumber)
		getInvoiceColumnCount("Make Payment")
		int columnCount = map_Tablecount['Make Payment']
		if(rowNumber==-1){
			KeywordUtil.markFailed("Transaction is not visible to perform Make Payment action")
		}
		else{
			rowNumber=rowNumber+1
			columnCount=columnCount+1
			String paymentXpath=String.format("//table[@id='transactionTable']/tbody/tr[%d]/td[%d]/div/img",rowNumber,columnCount)
			WebElement paymentElement=driver.findElement(By.xpath(paymentXpath))
			safeActions.highLightElement(paymentElement, GlobalVariable.delayBetweenTestSteps)
			paymentElement.click()
		}
	}

	@Keyword
	def clickOnDelete(TestObject nextObj,TestObject numberOfPages,TestObject deleteVaultButton,String vaultRefNumber){
		int rowNumber=getRowAndColumn(nextObj,numberOfPages,vaultRefNumber)
		getInvoiceColumnCount("Delete")
		int columnCount = map_Tablecount['Delete']
		if(rowNumber==-1){
			KeywordUtil.markFailed("Transaction is not visible to perform Delete action")
		}
		else{
			rowNumber=rowNumber+1
			columnCount=columnCount+1
			String deleteXpath=String.format("//table[@id='transactionTable']/tbody/tr[%d]/td[%d]/div/img",rowNumber,columnCount)
			WebElement deleteElement=driver.findElement(By.xpath(deleteXpath))
			safeActions.highLightElement(deleteElement, GlobalVariable.delayBetweenTestSteps)
			deleteElement.click()
			WebUI.delay(4)
			safeActions.highLightElement(deleteVaultButton, GlobalVariable.delayBetweenTestSteps)
			WebUI.click(deleteVaultButton)
		}
	}

	@Keyword
	def getRowAndColumn(TestObject nextObj,TestObject numberOfPages,String vaultRefNumber){
		getInvoiceColumnCount("Vault Ref #")
		int rowNumber=-1
		boolean foundValue=false
		boolean lastpage=false

		WebElement table
		while(!lastpage && !foundValue){
			table= driver.findElement(By.xpath("//table[@id='transactionTable']/tbody"))
			List<WebElement> rows=table.findElements(By.tagName('tr'))
			String pagesCount=WebUI.getText(numberOfPages)
			String[] pages=pagesCount.trim().split(" ")
			for(int i=0;i<rows.size();i++){
				println i
				List<WebElement> cols=rows.get(i).findElements(By.tagName('td'))
				//for(int j=0;j<cols.size();j++){
				String cellVaultReference = cols.get(map_Tablecount['Vault Ref #']).getText()
				println cellVaultReference
				if(cellVaultReference.equalsIgnoreCase(vaultRefNumber)){
					KeywordUtil.markPassed("The Vault is found in page "+pages[1])
					rowNumber=i
					WebUI.delay(6)
					foundValue=true
					lastpage=true
					break
				}

			}
			if(pages[1].equalsIgnoreCase(pages[3])){
				if(foundValue){
				}
				else{
					KeywordUtil.markFailed("The Vault is not found in all the pages")
					lastpage=true
					foundValue=true
				}
			}
			else{
				if(foundValue){

				}
				else{
					WebUI.delay(5)
					safeActions.highLightElement(nextObj, GlobalVariable.delayBetweenTestSteps)
					WebUI.click(nextObj)
				}
			}

		}
		println rowNumber
		return rowNumber

	}

	@Keyword
	def deleteInvoiceRecord(TestObject nextObj,TestObject numberOfPages,TestObject deleteVaultButton,String vaultRefNumber){
		getInvoiceColumnCount("Vault Ref #")
		boolean foundValue=false
		boolean lastpage=false
		//WebDriver driver=DriverFactory.getWebDriver()
		WebElement table
		while(!lastpage && !foundValue){
			table= driver.findElement(By.xpath("//table[@id='transactionTable']/tbody"))
			List<WebElement> rows=table.findElements(By.tagName('tr'))
			String pagesCount=WebUI.getText(numberOfPages)
			String[] pages=pagesCount.trim().split(" ")
			for(int i=0;i<rows.size();i++){
				println i
				List<WebElement> cols=rows.get(i).findElements(By.tagName('td'))
				//for(int j=0;j<cols.size();j++){
				String cellVaultReference = cols.get(map_Tablecount['Vault Ref #']).getText()
				println cellVaultReference
				if(cellVaultReference.equalsIgnoreCase(vaultRefNumber)){
					KeywordUtil.markPassed("The Vault is found in page "+pages[1])
					WebUI.delay(2)
					safeActions.highLightElement(cols.get(0), GlobalVariable.delayBetweenTestSteps)
					WebElement deleteEle=cols.get(0).click()
					WebUI.delay(4)
					safeActions.highLightElement(deleteVaultButton, GlobalVariable.delayBetweenTestSteps)
					WebUI.click(deleteVaultButton)
					//deleteEle.click()
					foundValue=true
					lastpage=true
					break
				}

			}
			//if(!foundValue){
			//String pagesCount=WebUI.getText(numberOfPages)
			//String[] pages=pagesCount.split(" ")
			if(pages[1].equalsIgnoreCase(pages[3])){
				if(foundValue){
					//KeywordUtil.markPassed()
				}
				else{
					KeywordUtil.markFailed("The Vault is not found in all the pages")
					lastpage=true
					foundValue=true
				}
			}
			else{
				if(foundValue){

				}
				else{
					WebUI.delay(5)
					safeActions.highLightElement(nextObj, GlobalVariable.delayBetweenTestSteps)
					WebUI.click(nextObj)
				}
			}

		}
		//}
	}

	@Keyword
	def verifyInvoiceRecord(TestObject nextObj,TestObject numberOfPages,String vaultRefNumber){
		getInvoiceColumnCount("Vault Ref #")
		boolean foundValue=false
		boolean lastpage=false
		WebElement table
		while(!lastpage && !foundValue){
			table= driver.findElement(By.xpath("//table[@id='transactionTable']/tbody"))
			List<WebElement> rows=table.findElements(By.tagName('tr'))
			String pagesCount=WebUI.getText(numberOfPages)
			String[] pages=pagesCount.trim().split(" ")
			for(int i=0;i<rows.size();i++){
				println i
				List<WebElement> cols=rows.get(i).findElements(By.tagName('td'))
				//for(int j=0;j<cols.size();j++){
				String cellVaultReference = cols.get(map_Tablecount['Vault Ref #']).getText()
				println cellVaultReference
				if(cellVaultReference.equalsIgnoreCase(vaultRefNumber)){
					KeywordUtil.markPassed("The Vault is found in page "+pages[1])
					safeActions.highLightElement(cols.get(map_Tablecount['Vault Ref #']), GlobalVariable.delayBetweenTestSteps)
					foundValue=true
					lastpage=true
					break
				}

			}
			if(pages[1].equalsIgnoreCase(pages[3])){
				if(foundValue){

				}
				else{
					KeywordUtil.markFailed("The Vault is not found in all the pages")
					lastpage=true
					foundValue=true
				}
			}
			else{
				if(foundValue){

				}
				else{
					WebUI.delay(5)
					safeActions.highLightElement(nextObj, GlobalVariable.delayBetweenTestSteps)
					WebUI.click(nextObj)
				}
			}

		}
		//}
	}
	//}


	@Keyword
	def getCount(TestObject nextObj,TestObject numberOfPages,String vaultRefNumber){
		boolean flag=true
		boolean lastpage=false
		String pagesCount=WebUI.getText(numberOfPages)
		String[] pages=pagesCount.trim().split(" ")
		int i = Integer.parseInt(pages[3])
		return i
	}

	@Keyword
	def verifyAllRecordsFilteredByCardNumber(TestObject nextObj,TestObject numberOfPages,String creditCardNumber){
		getInvoiceColumnCount("Last 4")
		int columnCount = map_Tablecount['Last 4']
		columnCount = columnCount + 1
		int pagesCount = getCount(nextObj,numberOfPages,creditCardNumber)
		boolean flag=true
		WebElement table = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody"))
		for(int i=1;i<=pagesCount;i++){
			List<WebElement> rows=table.findElements(By.tagName('tr'))
			for(int rowCount=0;rowCount<rows.size();rowCount++){
				println rowCount
				List<WebElement> cols = rows.get(rowCount).findElements(By.tagName('td'))
				String cellCardNumber = cols.get(map_Tablecount['Last 4']).getText()
				println cellCardNumber
				if(creditCardNumber.trim().substring(creditCardNumber.lastIndexOf("1")-3).equalsIgnoreCase(cellCardNumber.trim())){

				}
				else{
					flag=false
					break
				}
			}
			if(flag){
				WebUI.delay(1)
				WebUI.click(nextObj)
				WebUI.delay(2)
			}
			else{
				break
			}
		}
		if(flag){
			KeywordUtil.markPassed("All filtered Records have expected card Number")
		}
		else{
			KeywordUtil.markFailed("Filtered Records donot contain the expected card Number")
		}
	}


	@Keyword
	def getInvoiceColumnCount(String columnName){

		WebDriver driver=DriverFactory.getWebDriver()
		WebElement table= driver.findElement(By.xpath("//table[@id='transactionTable']/thead"))
		List<WebElement> rows=table.findElements(By.tagName('tr'))
		for(int i=0;i<rows.size();i++){
			List<WebElement> cols=rows.get(i).findElements(By.tagName('th'))
			for(int j=0;j<cols.size();j++){
				if(cols.get(j).getText().equalsIgnoreCase(columnName)){
					map_Tablecount[columnName]=j
				}
			}
		}
		println map_Tablecount
	}

	@Keyword
	def verifyAmountIsNotZero(String amount){
		String noAmount=amount.substring(1)
		Assert.assertNotEquals("0.00",noAmount)
	}

	@Keyword
	def verifyStrings(String expectedMessage,String popupMessage){
		println expectedMessage
		println popupMessage
		boolean flag=false
		if(expectedMessage.trim().equalsIgnoreCase(popupMessage.trim())){
			println "Matched"
			flag=true
			KeywordUtil.markPassed("Actual String : ${popupMessage} matched with Expected message : ${expectedMessage}")
		}
		else{
			flag=false
			println "Not Matched"
			KeywordUtil.markFailed("Actual String : ${popupMessage} didnot match with expected String : ${expectedMessage}")
		}
		return flag
	}

	@Keyword
	def verifyCardNumber(String expectedMessage,String popupMessage){
		println expectedMessage
		println popupMessage
		boolean flag=false
		if(expectedMessage.trim().substring(expectedMessage.lastIndexOf("1")-3).equalsIgnoreCase(popupMessage.trim().substring(expectedMessage.lastIndexOf("1")-3))){
			println "Matched"
			flag=true
			KeywordUtil.markPassed("Actual String : ${popupMessage} matched with Expected message : ${expectedMessage}")
		}
		else{
			flag=false
			println "Not Matched"
			KeywordUtil.markFailed("Actual String : ${popupMessage} didnot match with expected String : ${expectedMessage}")
		}
		return flag
	}


}
