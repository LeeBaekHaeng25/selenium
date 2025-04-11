package god.selenium.a01_업무지원시스템.a01_대메뉴_일.a01_중메뉴_일.a02_소메뉴_이;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class a01_게시판관리_등록_화면 {

	WebDriver driver;
	JavascriptExecutor js;

	long millis1000 = 1000;
	long millis2000 = 2000;
	long millis3000 = 3000;

//	@BeforeEach
	@BeforeAll
	void setup() {
//		setupA();
		setupB();

		setupC();
	}

	void setupA() {
		// 크롬
//		driver = new ChromeDriver();

		// chromedriver.exe 경로 설정
		System.setProperty("webdriver.chrome.driver", "C:\\EGOV-4.3.0-SELENIUM\\chromedriver-win64\\chromedriver.exe");

		// 크롬 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled"); // 봇 감지 우회
//
//		options.addArguments("--headless"); // 헤드리스 모드 활성화
//		options.addArguments("--disable-gpu"); // GPU 비활성화 (필요한 경우)
//		options.addArguments("--window-size=1920x1080"); // 화면 크기 설정

		driver = new ChromeDriver(options);
	}

	void setupB() {
		// 엣지

		// msedgedriver.exe 경로 직접 지정
		System.setProperty("webdriver.edge.driver", "C:\\EGOV-4.3.0-SELENIUM\\edgedriver_win64\\msedgedriver.exe");

		// 엣지 옵션 설정
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled"); // 봇 감지 우회

//		driver = new EdgeDriver();
		driver = new EdgeDriver(options);
	}

	void setupC() {
		driver.manage().window().maximize();

		driver.get("http://localhost:8080/egovframework-all-in-one/");
//		sleep(millis3000);
		sleep();

		String title = driver.getTitle();
		if (log.isDebugEnabled()) {
			log.debug("title={}", title);
		}

		// 메인페이지 프레임 _content
		driver.switchTo().frame("_content");
		js = (JavascriptExecutor) driver;
//		sleep(millis3000);

		// given

		// 아이디 입력
		WebElement idWebElement = driver.findElement(By.id("id"));
		idWebElement.sendKeys("USER");
//		sleep(millis3000);
		sleep();

		// 비밀번호 입력
		WebElement passwordWebElement = driver.findElement(By.id("password"));
		passwordWebElement.sendKeys("rhdxhd12");
//		sleep(millis3000);
		sleep();

		// when

		// 로그인 버튼 클릭
		js.executeScript("actionLogin();");
		sleep();

		// 3. 프레임 밖으로 나가기
//		driver.switchTo().defaultContent();

//		// then

		WebElement aWebElement = driver.findElement(By.cssSelector("body > a"));
		if (log.isDebugEnabled()) {
			log.debug("getText={}", aWebElement.getText());
			log.debug("href={}", aWebElement.getAttribute("href"));
		}
		assertEquals("로그아웃", aWebElement.getText());
		assertEquals("http://localhost:8080/egovframework-all-in-one/uat/uia/actionLogout.do",
				aWebElement.getAttribute("href"));
	}

	@Test
//	@RepeatedTest(5)
//	@RepeatedTest(2)
	void test() {
		if (log.isDebugEnabled()) {
			log.debug("셀레늄");
		}

//		driver.get("http://localhost:8080/egovframework-all-in-one/");
////		sleep(millis3000);
//		sleep();
//
//		String title = driver.getTitle();
//		if (log.isDebugEnabled()) {
//			log.debug("title={}", title);
//		}
//
//		// 메인페이지 프레임 _content
//		driver.switchTo().frame("_content");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
////		sleep(millis3000);
//
//		// given
//
//		// 아이디 입력
//		WebElement idWebElement = driver.findElement(By.id("id"));
//		idWebElement.sendKeys("USER");
////		sleep(millis3000);
//		sleep();
//
//		// 비밀번호 입력
//		WebElement passwordWebElement = driver.findElement(By.id("password"));
//		passwordWebElement.sendKeys("rhdxhd12");
////		sleep(millis3000);
//		sleep();
//
//		// when
//
//		// 로그인 버튼 클릭
//		js.executeScript("actionLogin();");
//		sleep();
//
//		// 3. 프레임 밖으로 나가기
////		driver.switchTo().defaultContent();
//
////		// then
//
//		WebElement aWebElement = driver.findElement(By.cssSelector("body > a"));
//		if (log.isDebugEnabled()) {
//			log.debug("getText={}", aWebElement.getText());
//			log.debug("href={}", aWebElement.getAttribute("href"));
//		}
//		assertEquals("로그아웃", aWebElement.getText());
//		assertEquals("http://localhost:8080/egovframework-all-in-one/uat/uia/actionLogout.do",
//				aWebElement.getAttribute("href"));

		// 180. 게시판관리

		// 셀레늄 단위 테스트: 180. 게시판관리 등록

		// 게시판관리 목록 화면
		driver.get("http://localhost:8080/egovframework-all-in-one/cop/bbs/selectBBSMasterInfs.do");
		sleep();

		// 등록 버튼 클릭

		// 게시판관리 등록 화면
		driver.get("http://localhost:8080/egovframework-all-in-one/cop/bbs/insertBBSMasterView.do?cmmntyId=");
		sleep();

		LocalDateTime now = LocalDateTime.now();
		String prefix = "test 아키텍트팀 이백행 ";
		String suffix = " " + now;

		// 게시판명 필수 입력
		WebElement bbsNmWebElement = driver.findElement(By.id("bbsNm"));
		bbsNmWebElement.sendKeys(prefix + "게시판명" + suffix);
		sleep();

		// 게시판소개내용 필수 입력
		WebElement bbsIntrcnWebElement = driver.findElement(By.id("bbsIntrcn"));
		bbsIntrcnWebElement.sendKeys(prefix + "게시판소개내용" + suffix);
		sleep();

		// 게시판 유형 필수 선택/입력
		WebElement bbsTyCodeWebElement = driver.findElement(By.id("bbsTyCode"));
		bbsTyCodeWebElement.sendKeys("통합게시판");

		// 답장가능여부 필수 선택/입력
		WebElement replyPosblAtWebElement = driver.findElement(By.id("replyPosblAt"));
		replyPosblAtWebElement.sendKeys("예");
		sleep();

		// 파일첨부가능여부 필수 선택/입력
		WebElement fileAtchPosblAtWebElement = driver.findElement(By.id("fileAtchPosblAt"));
		fileAtchPosblAtWebElement.sendKeys("예");
		sleep();

		// 첨부가능파일숫자 필수 선택/입력
		WebElement atchPosblFileNumberWebElement = driver.findElement(By.id("atchPosblFileNumber"));
		atchPosblFileNumberWebElement.sendKeys("1");
		sleep();

		// 사용여부 필수 선택/입력
		WebElement useAtWebElement = driver.findElement(By.id("useAt"));
		useAtWebElement.sendKeys("예");
		sleep();

		// 등록 버튼 클릭
		WebElement sSubmitWebElement = driver.findElement(By.cssSelector(".s_submit"));
		sSubmitWebElement.click();
		sleep();

		// 팝업으로 전환
		Alert alert = driver.switchTo().alert();

		// 팝업 내용 출력
		if (log.isDebugEnabled()) {
			log.debug("팝업 메시지: {}", alert.getText());
		}

		// 확인 버튼 클릭 (OK)
		alert.accept(); // 취소는 alert.dismiss()
	}

	@AfterEach
	void teardown() {
//		driver.quit();
	}

	void sleep() {
		sleep(millis1000);
	}

	void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}
	}

}
