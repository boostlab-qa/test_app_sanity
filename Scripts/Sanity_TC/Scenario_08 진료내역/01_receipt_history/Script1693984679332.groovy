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

'STEP - 진료내역 메뉴 선택'
Mobile.tap(findTestObject('03_home/btn_menu_history'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [리뷰 관리] 버튼 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_review'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 리뷰 관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '리뷰 관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//
'STEP - 리뷰 존재 유무에 따른 화면 확인'
if(Mobile.waitForElementPresent(findTestObject('04_receipt_history/area_rvReviewList'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'기대결과 - 리뷰 상태 이미지가 노출된다.'
	Mobile.verifyElementVisible(findTestObject('04_receipt_history/img_ivReviewState'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 병원명이 노출된다.'
	Mobile.verifyElementVisible(findTestObject('04_receipt_history/txt_tvReviewHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	'기대결과 - 리뷰 리스트 없는 경우 안내문구가 노출된다.'
	Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : '똑닥으로 진료 받고\n병원 리뷰를 남겨주세요.']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [전체대상] 필터 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_filter', [('text') : '전체대상']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text'): '진료대상 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//자녀 필터 선택
'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('04_receipt_history/txt_family_filter', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면에 {영유아 | 부모} 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('04_receipt_history/txt_reception_name', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('04_receipt_history/txt_user_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - [시간예약] 버튼이 노출된다.'
Mobile.verifyElementText(findTestObject('00_common/btn_tvCommonButtonView'), '시간예약', FailureHandling.CONTINUE_ON_FAILURE)
//

//시간예약 동작 확인
'STEP - [시간예약] 버튼 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_common_view', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 예약하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('10_receipt/txt_reservation_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [X] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)
//

//본인 필터 선택 
'STEP - [전체대상] 필터 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_filter', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text'): '진료대상 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 본인 필터 선택'
Mobile.tap(findTestObject('04_receipt_history/txt_family_filter', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면에 본인 이름 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('04_receipt_history/txt_tv_reception_user_name', [('text') : GlobalVariable.user_name]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - {영유아} 이름 목록 미노출'
Mobile.verifyElementNotVisible(findTestObject('04_receipt_history/txt_reception_name', [('text') : '영유아']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//바로접수 동작 확인
'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_common_view', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 접수하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('10_receipt/txt_receipt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [X] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)
//

//진료내역 상세
'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('04_receipt_history/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')