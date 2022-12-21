import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/*WebUI.openBrowser('')


if (((GlobalVariable.environment.equals('x') || GlobalVariable.environment.equals('y')) || GlobalVariable.environment.equals('w')) || GlobalVariable.environment.equals('p'))
{
	WebUI.navigateToUrl('https://cba' + GlobalVariable.environment + '-int.hewitt.com/safe/')
}
	
else
{
	WebUI.navigateToUrl('https://master-q' + GlobalVariable.environment + '.cba.qa.alight.com/safe/')
}
*/

//WebUI.setText(findTestObject('Login/input_username'), GlobalVariable.username)

//WebUI.setText(findTestObject('Login/input_password'), GlobalVariable.password)

//WebUI.click(findTestObject('Login/Click_LogOn'))

//import internal.GlobalVariable as GlobalVariable
WebUI.selectOptionByLabel(findTestObject('Login/Select_option'), 'Portal Design Manager', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Login/input_btnGo'))

WebUI.maximizeWindow()

WebUI.waitForElementPresent(findTestObject('PDM/client/select_Create New ClientAdvanc'), 30)

	// This area is failing for some reason, that it was unable to find text. i.e X Deployment ...
	WebUI.selectOptionByLabel(findTestObject('PDM/client/select_Create New ClientAdvanc'), 'Deployment Verification Client - (114-qp3.cba.qa.alight.com)', false)



 if(WebUI.verifyElementClickable(findTestObject('PDM/client/a_Update Client'), FailureHandling.CONTINUE_ON_FAILURE))
 {
	 KeywordUtil.markPassed("PDM has been deployed successfully")
	  GlobalVariable.Apps_Status ='PDM is Up.'
}
 else
 {
	 KeywordUtil.markFailed("PDM has not been deployed")
	 GlobalVariable.Apps_Status ='PDM is Down.'
 }
WebUI.click(findTestObject('/Login/ClickLogOut'))

