package keywords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class lifeEventOpen {

	def openWindow() {
		//Creating Life Event Below
		WebUI.click(findTestObject('MSS/EventsAndLifeMenu_btn'))
		WebUI.click(findTestObject('MSS/LifeEventsBtn'))

		WebUI.selectOptionByLabel(findTestObject('MSS/selectLifeEvent'), 'Administrative Event', false)

		// Calculating appropriate date to set for opening admin event
		Calendar avb = Calendar.getInstance()

		int y = avb.get(Calendar.YEAR)

		int d = avb.get(Calendar.DAY_OF_MONTH)

		int m = avb.get(Calendar.MONTH) + 1

		if (d == 1)
		{
			if (m == 1)
			{
				m = 12

				y = (y - 1)
			}
			else
			{
				m = (m - 1)
			}

			d = 28
		}
		else
		{
			d--
		}

		// End of Calculation
		WebUI.selectOptionByLabel(findTestObject('MSS/selectEventMonth'), String.valueOf(m), false)

		WebUI.selectOptionByLabel(findTestObject('MSS/selectEventDate'), String.valueOf(d), false)

		WebUI.selectOptionByLabel(findTestObject('MSS/selectEventYear'), String.valueOf(y), false)

		WebUI.click(findTestObject('MSS/optbtnDocNotReq'))

		WebUI.click(findTestObject('MSS/LifeEventContinuebtn'))

		WebUI.click(findTestObject('MSS/LifeEventPage2Continue'))

	}

}

