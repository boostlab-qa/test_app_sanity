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

'STEP - 홈 [가족관리] 메뉴 선택'
Mobile.tap(findTestObject('03_home/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '가족관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//자녀 추가
'STEP - [자녀추가] 버튼 선택'
Mobile.tap(findTestObject('11_family/btn_child_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀추가 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '자녀추가']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이름 입력'
Mobile.setText(findTestObject('11_family/input_add_family_name'), GlobalVariable.son, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민번호 앞자리 입력'
Mobile.setText(findTestObject('11_family/input_add_ssn_front_number'), GlobalVariable.son_birth_date, GlobalVariable.fixedTime)

'STEP - 주민번호 뒷자리 영역 선택'
Mobile.tap(findTestObject('11_family/input_add_ssn_back_number'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 주민번호 뒷자리 "3333333" 입력'
for(i = 1; i <= 7; i++)
{
	Mobile.tap(findTestObject('11_family/btn_keypad_number_3'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 화면 스크롤 이동된다.'
Mobile.scrollToText('고유식별정보의 수집 및 이용 동의')

'STEP - 이용약관 가족 대리 접수 동의 체크 선택'
Mobile.tap(findTestObject('11_family/btn_add_use', [('text') : '자녀 대리 접수 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이용약관 똑닥 QR 진료카드 체크 선택'
Mobile.tap(findTestObject('11_family/btn_add_use', [('text') : '고유식별정보의 수집 및 이용 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('11_family/btn_add_complet'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 추가한 자녀 정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('11_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('11_family/txt_birthday', [('text') : GlobalVariable.son_info]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //생년월일

'STEP - 자녀 선택'
Mobile.tap(findTestObject('11_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [정보보기] 버튼 노출되면 선택'
if(Mobile.waitForElementPresent(findTestObject('11_family/btn_info'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [정보보기] 버튼 선택'
	Mobile.tap(findTestObject('11_family/btn_info'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 자녀정보 바텀시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('11_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementText(findTestObject('11_family/txt_child_ssn'), '230301-3333333', FailureHandling.CONTINUE_ON_FAILURE) //주민등록번호
//

//자녀 편집
'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('11_family/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '가족 관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민번호 뒷자리 선택'
Mobile.tap(findTestObject('11_family/input_add_ssn_back_number'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 주민번호 뒷자리 "8888888" 수정'
for(i = 1; i <= 7; i++)
{
	Mobile.tap(findTestObject('11_family/btn_keypad_number_8'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 주소 입력 영역 선택'
Mobile.tap(findTestObject('11_family/input_adress', [('text') : '주소 입력하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 검색하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '주소 검색하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('06_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('06_adress_setting/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('06_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 상세주소 입력 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '상세주소 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 상세주소 입력'
Mobile.setText(findTestObject('06_adress_setting/input_adress_detail_adress_detail'), '1234', GlobalVariable.fixedTime)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀 상세 팝업에 수정된 주소가 노출된다.'
Mobile.verifyElementVisible(findTestObject('11_family/input_adress', [('text') : '경기 시흥시 배곧전원로 12-1 (배곧동) 1234 (15010)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'[정보보기] 버튼 노출되면 선택'
if(Mobile.waitForElementPresent(findTestObject('11_family/btn_info'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [정보보기] 버튼 선택'
	Mobile.tap(findTestObject('11_family/btn_info'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 수정된 자녀정보 바텀시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('11_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementText(findTestObject('11_family/txt_child_ssn'), '230301-8888888', FailureHandling.CONTINUE_ON_FAILURE) //주민등록번호
Mobile.verifyElementText(findTestObject('11_family/txt_adress'), '경기 시흥시 배곧전원로 12-1 ', FailureHandling.CONTINUE_ON_FAILURE) //주소

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('11_family/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '가족관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')



