import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.selectOptionByLabel(findTestObject('Login/Select_option'), 'Manager Self-Service', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Login/input_btnGo'))

WebUI.maximizeWindow()


if (WebUI.verifyElementClickable(findTestObject('MSS/Left links/a_Advanced Search'), FailureHandling.STOP_ON_FAILURE))
{
//Advance search
WebUI.click(findTestObject('MSS/Left links/a_Advanced Search'))

WebUI.waitForElementPresent(findTestObject('MSS/Left links/selectemployer_drpdn'), 30)


	WebUI.selectOptionByLabel(findTestObject('MSS/Left links/selectemployer_drpdn'), 'P Deployment Verification Client', false)


WebUI.selectOptionByLabel(findTestObject('MSS/advSearch_selectEligGroup'),'Active', false)

int year =  Calendar.getInstance().get(Calendar.YEAR)

GlobalVariable.planYear = String.valueOf(year)


	WebUI.selectOptionByLabel(findTestObject('MSS/Left links/MSS_SearchEmployeeSelectEligibilityGroup'), ( 'LE Group'+ ' : ') + GlobalVariable.planYear, false)

WebUI.click(findTestObject('MSS/Left links/MSS_SearchEmployeeClickSearch'))



KeywordUtil.markPassed('MSS is deployed sucessfully ')
GlobalVariable.Apps_Status =GlobalVariable.Apps_Status+'<br>HRAPlus(MSS) is Up.'
}
else
{
	KeywordUtil.markPassed('MSS is not deployed')
	GlobalVariable.Apps_Status =GlobalVariable.Apps_Status+'<br>HRAPlus(MSS) is Down.'
}
