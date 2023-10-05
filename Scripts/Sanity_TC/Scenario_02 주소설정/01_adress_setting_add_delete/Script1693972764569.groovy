import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

//주소설정 화면 진입		
'STEP - 홈 주소이름 [v] 버튼 선택'
Mobile.tap(findTestObject('03_home/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
//

//주소 등록
'주소 등록 가능한 상태면 주소 등록'
if (Mobile.waitForElementPresent(findTestObject('06_adress_setting/btn_different_location'), GlobalVariable.waitTime) == true)	
{
'STEP - [다른 위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('06_adress_setting/btn_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 주소 검색하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 검색하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
	
'STEP - 주소 영역 선택'
Mobile.tap(findTestObject('06_adress_setting/input_adress_search_adress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 주소 입력'
Mobile.setText(findTestObject('06_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('06_adress_setting/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('06_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)
	
'기대결과 - 상세주소 입력 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '상세주소 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
	
'STEP - 상세주소 입력'
Mobile.setText(findTestObject('06_adress_setting/input_adress_detail_adress_detail'), '1234', GlobalVariable.fixedTime)
	
'STEP - 주소이름 입력'
Mobile.setText(findTestObject('06_adress_setting/input_adress_detail_adress_name'), 'TEST', GlobalVariable.fixedTime)	
	
'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 주소설정 화면으로 이동된다'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 주소설정 화면에 등록된 주소이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('06_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소설정 화면에 등록된 주소가 노출된다.'
Mobile.verifyElementVisible(findTestObject('06_adress_setting/txt_different_adress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//주소 삭제
'STEP - [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('06_adress_setting/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 주소이름 선택'
Mobile.tap(findTestObject('03_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('06_adress_setting/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 편집 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 편집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'[삭제] 버튼이 노출되면 주소 삭제'
while(true)
{
if(Mobile.waitForElementPresent(findTestObject('06_adress_setting/btn_delete'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [삭제] 버튼 선택'
	Mobile.tap(findTestObject('06_adress_setting/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'STEP - 확인 팝업 [삭제] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)		
}
else
	{
		break
	}
}

'기대결과 - 삭제한 주소 정보 미노출'
Mobile.verifyElementNotVisible(findTestObject('06_adress_setting/txt_edit_address_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 삭제한 주소 이름이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('06_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - [다른 위치에서 병원 찾기] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('06_adress_setting/btn_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 안내문구가 노출된다.'
Mobile.verifyElementNotVisible(findTestObject('06_adress_setting/txt_max_adress_guide'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')
