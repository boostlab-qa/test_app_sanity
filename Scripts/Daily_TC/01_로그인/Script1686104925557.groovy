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


//카카오 전환 유도 팝업 예외처리
'카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('03_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('03_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//홈 팝업 예외처리
'마케팅 수신동의 팝업 노출 시 [좋아요] 선택'
if (Mobile.waitForElementPresent(findTestObject('03_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('03_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'똑닥 어떠셨나요? 팝업 노출 시 [다시 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('03_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('03_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//홈 화면이 아닌경우 최근목록 삭제 진행
if(Mobile.waitForElementPresent(findTestObject('03_home/btn_frame_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == false)
{
'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)
}
//

//로그인 상태
'STEP - 로그인 상태인 경우 로그아웃 진행'
if(Mobile.waitForElementPresent(findTestObject('03_home/btn_login'), GlobalVariable.fixedTime) == false)
{
	'STEP- [마이페이지] 메뉴 선택'
	Mobile.tap(findTestObject('03_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [수정] 버튼 선택'
	Mobile.tap(findTestObject('05_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [로그아웃] 버튼 선택'
	Mobile.tap(findTestObject('05_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 로그아웃 [확인] 버튼 선택'
	Mobile.tap(findTestObject('05_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 홈 메뉴 선택'
	Mobile.tap(findTestObject('03_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

//비로그인 상태
'STEP - 홈 [시작하기] 버튼 선택'
Mobile.tap(findTestObject('03_home/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [카카오로 시작하기] 버튼 선택'
Mobile.tap(findTestObject('01_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [카카오톡으로 간편로그인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text') : '카카오톡으로 간편로그인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//홈 팝업 예외처리
'똑닥 어떠셨나요? 팝업 노출 시 [다시 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('03_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('03_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 로그인 완료되고 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_frame_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[찜한목록] 버튼
Mobile.verifyElementNotVisible(findTestObject('03_home/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[시작하기] 버튼 미노출

//로그아웃
'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('03_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('05_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('05_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그아웃 [확인] 버튼 선택'
Mobile.tap(findTestObject('05_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//이메일 로그인
'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('05_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('01_onboarding/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('02_login/input_etEmail'), GlobalVariable.email_id, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('02_login/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('02_login/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//카카오 전환 유도 팝업 예외처리
'카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('03_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('03_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('03_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)