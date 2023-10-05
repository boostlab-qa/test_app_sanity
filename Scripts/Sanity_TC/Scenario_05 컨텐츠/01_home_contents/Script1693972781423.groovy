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

//동네 인기 병원
'STEP - {동네 인기 병원} 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_local_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementText(findTestObject('08_search/input_search'), '인기 많은 똑닥 병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '인기순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

//지금 문연 병원
'STEP - {지금 문연 병원} 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_open_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementVisible(findTestObject('08_search/btn_filter_open_on'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[진료중] 필터 버튼 ON
Mobile.verifyElementText(findTestObject('08_search/input_search'), '지금문연병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
// 

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//추천 - 복약관리
'STEP - 추천 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/img_mom_recommend'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 복약 관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('00_common/txt_page_titleTxt', [('text') : '복약 관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 (진료과로 병원 찾기) 아이콘 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('03_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.waitTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.scrollToText('소아청소년과')
}
	
//진료과로 병원 찾기 {소아청소년과}
'STEP - {소아청소년과} 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/btn_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //진료과목 필터 문구
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - [진료과목] 필터 선택'
Mobile.tap(findTestObject('08_search/btn_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2)

'기대결과 - 진료과목 바텀 시트 노출'
Mobile.verifyElementText(findTestObject('08_search/txt_bottom_seat_title'), '진료과목', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과목 {내과} 선택'
Mobile.tap(findTestObject('08_search/txt_medical_department_filter_list', [('text') : '내과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 필터 문구 {내과} 노출'
Mobile.verifyElementText(findTestObject('08_search/btn_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목이 내과인 병원 목록 노출'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//진료과로 병원 찾기 {이비인후과}
'STEP - {이비인후과} 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_find_hospital_otolaryngology'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '이비인후과', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/btn_medical_department'), '이비인후과', FailureHandling.CONTINUE_ON_FAILURE) //진료과목 필터 문구
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '이비인후과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '이비인후과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '이비인후과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'컨텐츠 높이 정의 & 스와이프 우측 이동'
int position_hospital_paediatrics = Mobile.getElementTopPosition(findTestObject('03_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime)
Mobile.swipe(500, position_hospital_paediatrics, 100, position_hospital_paediatrics)

//진료과로 병원 찾기 {내과}
'STEP - {내과} 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_find_hospital_medicine'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/btn_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //진료과목 필터 문구
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '내과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 스와이프 맨 좌측으로 이동'
Mobile.swipe(100, position_hospital_paediatrics, 1000, position_hospital_paediatrics)

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('똑닥 예약 병원')

//이런 병원 찾고 계신가요? 독감예방접종
'STEP - 이런 병원 찾고 계신가요? [독감예방접종] 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_like_hospital_flu'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면이 노출된다.'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '독감예방접종', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//이런 병원 찾고 계신가요? {똑닥 예약 병원}
'STEP - 이런 병원 찾고 계신가요? [똑닥 예약 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '똑닥 예약 병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//이런 병원 찾고 계신가요? {일요일 진료}
'STEP - 이런 병원 찾고 계신가요? [일요일 진료] 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_like_hospital_sunday'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '일요일 진료', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 스와이프 우측으로 이동'
int position_hospital_reservation = Mobile.getElementTopPosition(findTestObject('03_home/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime)
Mobile.swipe(800, position_hospital_reservation, 100, position_hospital_reservation)

//이런 병원 찾고 계신가요? {입원 가능한 소아과}
'STEP - 이런 병원 찾고 계신가요? [입원 가능한 소아과] 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/txt_like_hospital_hospitalize_pediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('08_search/input_search'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/btn_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //진료과목 필터 문구
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementText(findTestObject('08_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //병원 대표 진료과목

'STEP - [필터] 버튼 선택'	
Mobile.tap(findTestObject('08_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2)

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('일반병실')

'기대결과 - 필터 화면에 병원 시설 [일반병실] 버튼 on 상태로 노출'
Mobile.verifyElementVisible(findTestObject('08_search/btn_filter_general_on'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'홈 {이런 병원 찾고 계신가요?} 스와이프 맨 좌우측으로 이동'
Mobile.swipe(100, position_hospital_reservation, 1000, position_hospital_reservation)

'홈 컨텐츠 (영유아 검진 예약하기) 이미지가 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('03_home/02_contents/img_infant_check-up'), GlobalVariable.waitTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.swipe(45, 2000, 45, 1000)
}

//{영유아 검진 예약하기} 
'STEP - [영유아 검진 예약하기] 컨텐츠 선택'
Mobile.tap(findTestObject('03_home/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('08_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementText(findTestObject('08_search/input_search'), '영유아검진', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('08_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('08_search/txt_badge', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //영유아검진 뱃지
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('03_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원 추천 영역
'STEP - 홈 병원 추천(a) 리스트 영역 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('03_home/area_rv_recommend_hospital'), GlobalVariable.waitTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.swipe(45, 1080, 45, 700)
}

'STEP - 앱 종료'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.terminateApp('com.bbros.sayup.debug')

