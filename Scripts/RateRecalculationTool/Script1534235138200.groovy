import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DF
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import java.awt.List as List
import java.lang.Math as Math
import javax.swing.JPasswordField as JPasswordField
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.swing.JOptionPane as JOptionPane
import org.openqa.selenium.Keys as Keys
import java.util.List as List

WebUI.openBrowser('')


if (((GlobalVariable.environment.equals('x') || GlobalVariable.environment.equals('y')) || GlobalVariable.environment.equals(
	'w')) || GlobalVariable.environment.equals('p')) {
	WebUI.navigateToUrl(('https://cba' + GlobalVariable.environment) + '-int.hewitt.com/safe/')
} else {
	WebUI.navigateToUrl(('https://master-q' + GlobalVariable.environment) + '.cba.qa.alight.com/safe/')
}

WebUI.setText(findTestObject('Login/input_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Login/input_password'), GlobalVariable.password)

WebUI.click(findTestObject('Login/Click_LogOn'))

WebUI.selectOptionByLabel(findTestObject('Login/Select_option'), 'Rate Recalculation Tool', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Login/input_btnGo'))

WebUI.maximizeWindow()


if(GlobalVariable.environment.equals("x")||GlobalVariable.environment.equals("x2")||GlobalVariable.environment.equals("x3")||GlobalVariable.environment.equals("x4"))
WebUI.selectOptionByLabel(findTestObject('RateRecalc/selER'), 'X Deployment Verification Client Exchange', false, FailureHandling.STOP_ON_FAILURE)
else if(GlobalVariable.environment.equals("w")||GlobalVariable.environment.equals("w2")||GlobalVariable.environment.equals("w3")||GlobalVariable.environment.equals("w4"))
WebUI.selectOptionByLabel(findTestObject('RateRecalc/selER'), 'W Deployment Verification Client', false, FailureHandling.STOP_ON_FAILURE)
else if(GlobalVariable.environment.equals("y")||GlobalVariable.environment.equals("y2")||GlobalVariable.environment.equals("y3")||GlobalVariable.environment.equals("y4"))
WebUI.selectOptionByLabel(findTestObject('RateRecalc/selER'), 'Y Deployment Verification Client', false, FailureHandling.STOP_ON_FAILURE)
else if(GlobalVariable.environment.equals("p")||GlobalVariable.environment.equals("p2")||GlobalVariable.environment.equals("p3")||GlobalVariable.environment.equals("p4"))
WebUI.selectOptionByLabel(findTestObject('RateRecalc/selER'), 'P Deployment Verification Client', false, FailureHandling.STOP_ON_FAILURE)



WebUI.click(findTestObject('RateRecalc/schedulenew'))

WebUI.click(findTestObject('RateRecalc/backbtn'))



WebUI.click(findTestObject('General/lgout'))

