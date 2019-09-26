package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilities.SafeActions
import internal.GlobalVariable

public class Transaction_Management {
	def map_TableCount = [:]
	SafeActions safeActions=new SafeActions()


	@Keyword
	def verifyInvoiceRecord(TestObject nextObj,TestObject numberOfPages,String invoice,String amount){
		try{
			getInvoiceColumnCount()
			println map_TableCount['Transaction Status']
			println map_TableCount['Amount']
			println map_TableCount['Invoice']
			boolean foundValue=false
			boolean lastpage=false
			WebDriver driver=DriverFactory.getWebDriver()
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
					String cellTransactionValue = cols.get(map_TableCount['Invoice']).getText()
					String cellAmountValue = cols.get(map_TableCount['Amount']).getText()
					String cellTransactionStatus = cols.get(map_TableCount['Transaction Status']).getText()
					println cellTransactionValue
					println cellAmountValue
					println amount
					if(cellTransactionValue.equalsIgnoreCase(invoice) && cellAmountValue.equalsIgnoreCase(amount) && cellTransactionStatus.equalsIgnoreCase("Pending")){
						safeActions.highLightElement(cols.get(map_TableCount['Invoice']), GlobalVariable.delayBetweenTestSteps)
						safeActions.highLightElement(cols.get(map_TableCount['Amount']), GlobalVariable.delayBetweenTestSteps)
						safeActions.highLightElement(cols.get(map_TableCount['Transaction Status']), GlobalVariable.delayBetweenTestSteps)
						println cellTransactionValue
						KeywordUtil.markPassed("The Transaction is found in page "+pages[1])
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
						KeywordUtil.markFailed("The Transaction is not found in all the pages")
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
		}
		catch(Exception e){
			WebUI.takeScreenshot(safeActions.reportsFolderPath+"/verifyInvoiceRecord_TransactionManagement.png")
			KeywordUtil.markFailed("unable to verify InvoiceRecord in TransactionManagement Screen")
		}
	}
	//}

	@Keyword
	def getInvoiceColumnCount(){
		try{

			WebDriver driver=DriverFactory.getWebDriver()
			WebElement table= driver.findElement(By.xpath("//table[@id='transactionTable']/thead"))
			List<WebElement> rows=table.findElements(By.tagName('tr'))
			for(int i=0;i<rows.size();i++){
				List<WebElement> cols=rows.get(i).findElements(By.tagName('th'))
				for(int j=0;j<cols.size();j++){
					if(cols.get(j).getText().equalsIgnoreCase("Transaction Status")){
						map_TableCount['Transaction Status']=j
					}
					else if(cols.get(j).getText().equalsIgnoreCase("Invoice")){
						map_TableCount['Invoice']=j
					}
					else if(cols.get(j).getText().equalsIgnoreCase("Amount")){
						map_TableCount['Amount']=j
					}
				}
			}
		}
		catch(Exception e){
			WebUI.takeScreenshot(safeActions.reportsFolderPath+"/getInvoiceColumnCount_TransactionManagement.png")
			KeywordUtil.markFailed("unable to get InvoiceRecord column number in TransactionManagement Screen")
		}
		println map_TableCount
		//return map_TableCount
	}
}
