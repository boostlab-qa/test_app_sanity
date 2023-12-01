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
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement


'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 나의 똑닥 메뉴 선택'
Mobile.tap(findTestObject('03_home/btn_menu_myddocdoc'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 나의 똑닥 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_tv_title', [('text') : '나의 똑닥']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 새로고침 안내 배너가 노출되면 [확인 했어요!] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('14_myddocdoc/btn_confirm'), GlobalVariable.waitTime))
{
	'STEP - 나의 똑닥 메뉴 선택'
	Mobile.tap(findTestObject('14_myddocdoc/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [진료실 대기 현황을 확인해 보세요!] 버튼 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_receipt_status'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료실 대기 현황 바텀 시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_tv_title', [('text') : '진료실 대기 현황']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 접수하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('10_receipt/txt_receipt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 나의 똑닥 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_tv_title', [('text') : '나의 똑닥']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [시간예약] 버튼 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_right', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 예약하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('10_receipt/txt_reservation_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('14_myddocdoc/txt_tv_title', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_tv_title', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [진료실 대기 현황] 버튼 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_tv_waiting_status'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료실 대기 현황 바텀 시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_tv_title', [('text') : '진료실 대기 현황']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('09_hospital_detail/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 나의 똑닥 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_tv_title', [('text') : '나의 똑닥']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 찜한 약국 탭 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_drugstore'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 찜한 약국 유무에 따른 약국 즐겨찾기 등록 및 해제'
if(Mobile.waitForElementPresent(findTestObject('14_myddocdoc/btn_button_deeplink'), GlobalVariable.waitTime))
{
	'STEP - 약국 목록 선택'
	Mobile.tap(findTestObject('14_myddocdoc/tv_drugstore_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 약국 상세 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_drugStoreName'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 약국 이름 저장'
	drugStoreName1 = Mobile.getText(findTestObject('14_myddocdoc/txt_drugStoreName'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 약국 즐겨찾기 등록 버튼 선택'
	Mobile.tap(findTestObject('14_myddocdoc/btn_bookMarkBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [<] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 찜한 약국 목록이 노출된다.'
	Mobile.verifyElementVisible(findTestObject('14_myddocdoc/tv_drugstore_name', [('text') : drugStoreName1]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - [약국 지도 보러가기] 버튼이 노출되지 않는다.'
	Mobile.verifyElementNotVisible(findTestObject('14_myddocdoc/btn_button_deeplink'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 약국 목록 선택'
	Mobile.tap(findTestObject('14_myddocdoc/tv_drugstore_name', [('text') : drugStoreName1]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 약국 즐겨찾기 해제 버튼 선택'
	Mobile.tap(findTestObject('14_myddocdoc/btn_bookMarkBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [<] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 찜한 약국 화면에 [약국 지도 보러가기] 버튼이 노출된다.'
	Mobile.verifyElementVisible(findTestObject('14_myddocdoc/btn_button_deeplink'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	'STEP - 약국 목록 선택'
	Mobile.tap(findTestObject('14_myddocdoc/tv_drugstore_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 약국 상세 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('14_myddocdoc/txt_drugStoreName'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 약국 이름 저장'
	drugStoreName2 = Mobile.getText(findTestObject('14_myddocdoc/txt_drugStoreName'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 약국 즐겨찾기 해제 버튼 선택'
	Mobile.tap(findTestObject('14_myddocdoc/btn_bookMarkBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [<] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 찜한 약국 목록 개수에 따른 분기'
	if(Mobile.waitForElementNotPresent(findTestObject('14_myddocdoc/btn_button_deeplink'), GlobalVariable.waitTime))
	{
		'기대결과 - 찜한 약국 목록이 2개 이상인 경우 목록에서 즐겨찾기 해제한 약국이 비노출된다.'
		Mobile.verifyElementNotVisible(findTestObject('14_myddocdoc/tv_drugstore_name', [('text') : drugStoreName2]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	else
	{
		'기대결과 - 찜한 약국 목록이 1개인 경우 찜한 약국 없는 화면이 노출된다.'
		Mobile.verifyElementVisible(findTestObject('14_myddocdoc/btn_button_deeplink'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

'STEP - 복약 관리 탭 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_drugs'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 복약 관리 화면이 노출된다.'
Mobile.verifyElementVisible(findTestObject('14_myddocdoc/btn_tv_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 다녀온 병원 탭 선택'
Mobile.tap(findTestObject('14_myddocdoc/btn_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')