import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.selectOptionByLabel(findTestObject('Login/SelectModule'), 'Rapid Implementation', false)

WebUI.click(findTestObject('Login/ClickGo'))

WebUI.click(findTestObject('RI/RIProdP'))



	

 KeywordUtil.markPassed('RI is deployed sucessfully')
 GlobalVariable.Apps_Status = GlobalVariable.Apps_Status+'<br>RPRapidImp(RI) is Up.'
 
 WebUI.click(findTestObject('Login/ClickLogOut'))

