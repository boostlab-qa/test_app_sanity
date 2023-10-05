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

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('03_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('08_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'건강검진 사용 병원인 경우'
if(Mobile.waitForElementPresent(findTestObject('09_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [접수/예약] 버튼 선택'
Mobile.tap(findTestObject('09_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 일반진료 바텀 시트 노출'
Mobile.verifyElementText(findTestObject('10_receipt/txt_view_title'), '일반진료', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [지금 방문할게요] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_receipt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'건강검진 미사용 병원인 경우'
if(Mobile.waitForElementPresent(findTestObject('09_hospital_detail/btn_left', [('text') : '바로접수']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('09_hospital_detail/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료대상 본인 선택'
Mobile.tap(findTestObject('10_receipt/txt_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//주민번호 뒷자리 미입력 상태인 경우 주민등록 번호 입력 화면으로 이동
if(Mobile.waitForElementPresent(findTestObject('10_receipt/input_back_number'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 주민번호 뒷자리 영역 선택'
	Mobile.tap(findTestObject('10_receipt/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "1111118" 입력'
	for(i = 1; i <= 6; i++)
	{
		Mobile.tap(findTestObject('11_family/btn_keypad_number_1'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	Mobile.tap(findTestObject('11_family/btn_keypad_number_8'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	Mobile.tap(findTestObject('10_receipt/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

//예외처리 - 간편결제 또는 비대면 진료 미사용 병원인 경우 진료방식 선택 영역 미노출
if(Mobile.waitForElementPresent(findTestObject('10_receipt/txt_setting', [('text') : '방문진료']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 진료방식 방문진료 선택'
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

Mobile.scrollToText('기타')

'STEP - 진료항목 {기타} 선택'
Mobile.tap(findTestObject('10_receipt/txt_item', [('text') : '기타']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

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

'STEP - 모바일 서류 설정 노출 시 팝업 닫기'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/btn_deny'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [다음에 하기] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_deny'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 간편결제 사용하는 병원의 경우 결제 방식 직접결제 선택'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/txt_payment_list_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - [병원에서 직접결제] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_direct'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [다음] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 접수 완료 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('10_receipt/txt_complete_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀

'STEP - [고유식별정보의 수집 및 이용 동의] 체크'
Mobile.tap(findTestObject('10_receipt/txt_cb_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 접수하기] 버튼 선택'
Mobile.tap(findTestObject('10_receipt/btn_complete_receipt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 사전문진 화면 노출 시 화면 닫기'
if(Mobile.waitForElementPresent(findTestObject('10_receipt/btn_question_close'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_question_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [종료하기] 버튼 선택'
	Mobile.tap(findTestObject('10_receipt/btn_question_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인화 영역 노출'
Mobile.verifyElementVisible(findTestObject('03_home/btn_cv_medical_status_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //영역

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('03_home/btn_cv_medical_status_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 진료내역 상세 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_detail_hospital'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_office'), '진료실', FailureHandling.CONTINUE_ON_FAILURE) //진료실명

'STEP - [접수취소] 버튼 선택'
Mobile.tap(findTestObject('04_receipt_history/btn_detail_receipt_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [접수취소] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [바로접수] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('04_receipt_history/btn_detail_now_receipt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [접수취소] 버튼 미노출'
Mobile.verifyElementNotVisible(findTestObject('04_receipt_history/btn_detail_receipt_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 취소 안내 문구 노출'
Mobile.verifyElementText(findTestObject('04_receipt_history/txt_detail_cancel_message'), '본인 요청으로 접수가 취소되었어요.', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')