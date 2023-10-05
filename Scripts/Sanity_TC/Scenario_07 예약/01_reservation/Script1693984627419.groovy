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
import java.time.LocalDate;
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('03_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('08_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//건강검진 
'건강검진 사용 병원인 경우'
if(Mobile.waitForElementPresent(findTestObject('09_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [접수/예약] 버튼 선택'
Mobile.tap(findTestObject('09_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [날짜를 선택할게요.] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'건강검진 미사용 병원인 경우'
if(Mobile.waitForElementPresent(findTestObject('09_hospital_detail/btn_right', [('text') : '시간예약']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [시간예약] 버튼 선택'
Mobile.tap(findTestObject('09_hospital_detail/btn_right', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

//예외처리
'예약 패널티 현황 안내 팝업 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('00_common/txt_tvtitle', [('text') : '예약 페널티 현황 안내']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료대상 {영유아} 선택'
Mobile.tap(findTestObject('10_receipt/txt_name', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족 접수 알림 팝업 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민등록 뒷자리 미입력 상태인 경우 뒷자리 입력'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/txt_transmission_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 주민번호 뒷자리 선택'
	Mobile.tap(findTestObject('10_receipt/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "3333333" 입력'
	for(i = 1; i <= 7; i++)
	{
		Mobile.tap(findTestObject('11_family/btn_keypad_number_3'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	Mobile.tap(findTestObject('10_receipt/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 간편결제 또는 비대면 진료 사용 병원인 경우 진료방식 선택'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/txt_setting', [('text') : '방문진료']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	Mobile.tap(findTestObject('10_receipt/txt_setting', [('text') : '방문진료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료실 선택'
Mobile.tap(findTestObject('10_receipt/txt_name', [('text') : '진료실']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 공지 노출 시 팝업 닫기'
if(Mobile.waitForElementPresent(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료항목 영유아검진 선택'
Mobile.tap(findTestObject('10_receipt/txt_infant'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 결제수단 영역이 노출되면 직접결제로 전환'
if(Mobile.waitForElementPresent(findTestObject('00_common/txt_tvTitle', [('text') : '결제수단']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 결제수단 영역 선택'
	Mobile.tap(findTestObject('00_common/txt_tvTitle', [('text') : '결제수단']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'STEP - [병원에서 직접결제] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_direct'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 현재일 숫자형 정의'
LocalDate now = LocalDate.now()
int today = now.getDayOfMonth()
int tomorrow = today + 1

'STEP - 오늘 날짜 선택'
Mobile.tap(findTestObject('10_receipt/btn_day', [('text') : today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 오늘 예약 불가능한 경우 내일 날짜 선택'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/txt_tv_reservation_time_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == false)
{
	'STEP - 다음 날짜 선택'
	Mobile.tap(findTestObject('10_receipt/btn_day', [('text') : tomorrow]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 예약 시간 선택'
Mobile.tap(findTestObject('10_receipt/txt_reservation_minute'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'예약 날짜 시간 저장'
reservation = Mobile.getText(findTestObject('10_receipt/txt_reservation_time'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 간편결제 사용하는 병원의 경우 결제 방식 [직접결제] 선택'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/txt_payment_list_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - [병원에서 직접결제] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_direct'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [다음] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 예약완료 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('10_receipt/btn_complete_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [고유식별정보의 수집 및 이용 동의] 체크'
Mobile.tap(findTestObject('10_receipt/txt_cb_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 예약하기] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_complete_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 영유아 검진 문진표 작성 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '영유아 검진 문진표 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 문진표에 영유아검진 개월수가 노출된다.'
Mobile.verifyElementVisible(findTestObject('11_family/txt_titleTxt_infant'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //영유아 검진 문진표(30~36개월)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 개인화 영역에 예약 정보 카드 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_cv_medical_status_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 개인화 영역에 [영유아검진 작성] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_left', [('text') : '영유아검진 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('03_home/btn_cv_medical_status_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [영유아검진 작성] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('00_common/btn_commonBtnTitle', [('text') : '영유아검진 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 환자명이 노출된다.'
Mobile.verifyElementVisible(findTestObject('10_receipt/txt_name', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 병원명이 노출된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_detail_hospital'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 예약일이 노출된다.'
reservation_complete = Mobile.getText(findTestObject('04_receipt_history/txt_receipt_day'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyEqual(reservation, '-' + reservation_complete, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료실명이 노출된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_office'), '진료실', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료항목이 노출된다.'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_detail_tvSymptomTxt'), '영유아검진', FailureHandling.CONTINUE_ON_FAILURE)
//

//예약 취소
'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 확인 팝업에서 [예약취소] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [시간예약] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('04_receipt_history/btn_time_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [예약취소] 버튼이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('04_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')