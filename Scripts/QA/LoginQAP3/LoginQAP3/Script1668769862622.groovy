import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.Document.OutputSettings

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

GlobalVariable.environment = 'p3'


WebUI.openBrowser('')




	WebUI.navigateToUrl('https://master-qp3.cba.qa.alight.com/safe/version.jsp')
	

if (WebUI.verifyElementPresent(findTestObject('Login/EnvironmentDown'), 15,FailureHandling.OPTIONAL))
{
	
	GlobalVariable.version = "Not Available"
	GlobalVariable.Apps_Status = "SAFE is down"
	KeywordUtil.markFailedAndStop('Environment is down')
	
}
else
{
	GlobalVariable.version = WebUI.getText(findTestObject("Login/versionjsp"))
	WebUI.navigateToUrl('https://master-qp3.cba.qa.alight.com/safe')
	
	WebUI.callTestCase(findTestCase('QA/PDM/PDMQAP3'), [:], FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.callTestCase(findTestCase('QA/RI/RIQAP3'), [:], FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.callTestCase(findTestCase('QA/MSS/MSSQAP3'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

File input = new File(System.getProperty("user.dir")+"\\Report.HTML")

Document doc = Jsoup.parse(input,"UTF-8")
doc.outputSettings(new OutputSettings().prettyPrint(false))

PrintWriter writer = new PrintWriter(input,"UTF-8")

Element environmentTag = doc.getElementById('P Server').html(GlobalVariable.environment)
println(environmentTag)

Element versionTag = doc.getElementById('P Version').html(GlobalVariable.version)
println(versionTag)

Element appStatus = doc.getElementById('P Status').html(GlobalVariable.Apps_Status)
println(appStatus)


writer.write(doc.html())
writer.newLine()
writer.flush()
writer.close()

