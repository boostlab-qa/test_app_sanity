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

Mobile.delay(3)

'STEP - 가상 키보드 닫기'
Mobile.pressBack()

'최근 검색어 존재 시 전체 삭제'
if(Mobile.waitForElementPresent(findTestObject('08_search/btn_all_delete'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	Mobile.tap(findTestObject('08_search/btn_all_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

//병원 검색
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('08_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('08_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 검색 결과가 노출된다.'
Mobile.verifyElementText(findTestObject('08_search/txt_hospital_name'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 필터 버튼이 노출된다.'
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [진료중] [지도보기] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('08_search/btn_filter_open'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[진료중]
Mobile.verifyElementVisible(findTestObject('08_search/btn_map'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[지도보기]

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//'기대결과 - 병원상세로 이동되고, [시간예약] 버튼이 노출된다.'
//Mobile.verifyElementVisible(findTestObject('09_hospital_detail/btn_right', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'기대결과 - 병원상세로 이동되고, [바로접수] 버튼이 노출된다.'
//Mobile.verifyElementVisible(findTestObject('09_hospital_detail/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementText(findTestObject('08_search/input_search'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - [x] 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색어 삭제되고 최근 검색어가 노출된다.' 
Mobile.verifyElementText(findTestObject('08_search/txt_recent_list'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 최근 검색어 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_recent_list_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('08_search/txt_recent_list'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//질병 검색
String[] disease = ['감기', '장염']

'STEP - 질병 검색'
for(i=0; i<=1; i++)
{
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('08_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 질병 검색어 입력'
Mobile.setText(findTestObject('08_search/input_search'), disease[i], GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 목록 첫번째 검색어 선택'
Mobile.tap(findTestObject('08_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 질벙졍보 설명 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('08_search/txt_disease_description'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('08_search/btn_see'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[보기] 버튼

'기대결과 - 질병 검색 결과가 노출된다.'
Mobile.verifyElementVisible(findTestObject('08_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[필터] 버튼
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
	
'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STE[ - 이전 화면으로 이동'
Mobile.pressBack()

'STEP - [x] 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 최근 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_recent_list_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('08_search/txt_recent_list'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//진료과목 검색
String[] medical_department = ['내과', '소아청소년과']

'STEP - 진료과목으로 검색'
for(i=0; i<=1; i++)
{
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('08_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과 검색어 입력'
Mobile.setText(findTestObject('08_search/input_search'), medical_department[i], GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 검색 결과 첫번째 검색어 선택'
Mobile.tap(findTestObject('08_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)
	
'기대결과 - 진료과 검색 결과 목록 노출'
Mobile.verifyElementVisible(findTestObject('08_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[필터] 버튼
Mobile.verifyElementText(findTestObject('08_search/input_search'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) //검색 영역
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('08_search/txt_main_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //대표진료과목 영역

'STEP - 검색어 [x] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 최근 검색어 영역에 입력한 검색어가 노출된다.'
Mobile.verifyElementText(findTestObject('08_search/txt_recent_list'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) 
	
'STEP - 최근 검색어 [x] 버튼 선택'
Mobile.tap(findTestObject('08_search/btn_recent_list_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('08_search/txt_recent_list'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')

