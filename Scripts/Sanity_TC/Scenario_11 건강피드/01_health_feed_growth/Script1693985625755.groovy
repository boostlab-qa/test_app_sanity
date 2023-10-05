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

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('03_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 건강피드 선택'
Mobile.tap(findTestObject('05_mypage/btn_healthy_feed'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_child_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//아들
'STEP - 자녀 선택' 
Mobile.tap(findTestObject('13_healthy_feed/txt_filter_list_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//건강피드 TAB에서 키 등록
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [키 등록] 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_add', [('text') : '키 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '성장관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력 영역 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키 직접 입력 팝업 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '키 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력'
Mobile.setText(findTestObject('13_healthy_feed/input_number'), '50', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementText(findTestObject('13_healthy_feed/txt_growth'), '50cm', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 tab 화면 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_left_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키 스위치 상태
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_right'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게 

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/txt_height_weight', [('text') : '50cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //50cm 문구 포함
//

//키 등록 (성장관리)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [키 등록] 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_add', [('text') : '키 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '성장관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력 영역 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키 직접 입력 팝업 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '키 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력'
Mobile.setText(findTestObject('13_healthy_feed/input_number'), '60', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementText(findTestObject('13_healthy_feed/txt_growth'), '60cm', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면 성장관리 tab 노출'
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_right'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_left_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키 스위치 상태


'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/txt_height_weight', [('text') : '60cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //60cm 문구 포함
//

//몸무게 등록 (건강피드)
'STEP - 건강피드 tab 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_tab', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [몸무게 등록] 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_add', [('text') : '몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '성장관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력 영역 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 몸무게 직접 입력 팝업 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '몸무게 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력'
Mobile.setText(findTestObject('13_healthy_feed/input_number'), '5', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 등록한 몸무게 데이터 노출'
Mobile.verifyElementText(findTestObject('13_healthy_feed/txt_growth'), '5kg', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 tab에 등록한 몸무게 노출'
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_left'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_right_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게 스위치 상태
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/txt_height_weight', [('text') : '5kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //50cm 문구 포함
//

//몸무게 등록 (성장관리)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [몸무게 등록] 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_add', [('text') : '몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '성장관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력 영역 선택'
Mobile.tap(findTestObject('13_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 몸무게 직접 입력 팝업 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '몸무게 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력'
Mobile.setText(findTestObject('13_healthy_feed/input_number'), '10', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('13_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 등록한 몸무게 데이터 노출'
Mobile.verifyElementText(findTestObject('13_healthy_feed/txt_growth'), '10kg', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 tab에 등록한 몸무게 노출'
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_left'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/btn_right_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게 스위치 상태
Mobile.verifyElementVisible(findTestObject('13_healthy_feed/txt_height_weight', [('text') : '10kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //50cm 문구 포함
//

//홈 화면 이동
'STEP - [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)


'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')