package god.selenium.a01_업무지원시스템.a01_대메뉴_일.a01_중메뉴_일.a01_소메뉴_일;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class a01_프로그램_일 {

	WebDriver driver;

	@BeforeEach
	void setup() {
		// 크롬
//		driver = new ChromeDriver();

//		// 크롬 옵션 설정
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-blink-features=AutomationControlled"); // 봇 감지 우회
//
//		options.addArguments("--headless"); // 헤드리스 모드 활성화
//		options.addArguments("--disable-gpu"); // GPU 비활성화 (필요한 경우)
//		options.addArguments("--window-size=1920x1080"); // 화면 크기 설정

//		driver = new ChromeDriver(options);

		// 엣지

		// 엣지 옵션 설정
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled"); // 봇 감지 우회

//		driver = new EdgeDriver();
		driver = new EdgeDriver(options);
	}

	@Test
	void test() {
		if (log.isDebugEnabled()) {
			log.debug("셀레늄");
		}

		// https://www.selenium.dev/documentation/webdriver/getting_started/using_selenium/

		driver.get("https://www.google.com/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}

		String title = driver.getTitle();
		if (log.isDebugEnabled()) {
			log.debug("title={}", title);
		}

		// given

		// document.querySelectorAll('#APjFqb')
		// document.querySelectorAll('[name="q"]')

		WebElement qWebElement = driver.findElement(By.id("APjFqb"));
//		WebElement qWebElement = driver.findElement(By.name("q"));

		if (log.isDebugEnabled()) {
			log.debug("q.value={}", qWebElement.getAttribute("value"));
		}

		String qkeysToSend = "이백행";

		qWebElement.sendKeys(qkeysToSend);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}

		if (log.isDebugEnabled()) {
			log.debug("q.value={}", qWebElement.getAttribute("value"));
		}

		// when
		qWebElement.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}

		WebElement qWebElement2 = driver.findElement(By.id("APjFqb"));
//		WebElement qWebElement2 = driver.findElement(By.name("q"));
		String qWebElement2value = qWebElement2.getAttribute("value");

		if (log.isDebugEnabled()) {
			log.debug("q2.value={}", qWebElement2value);
		}

		// then
		assertEquals(qkeysToSend, qWebElement2value);
	}

	@AfterEach
	void teardown() {
//		driver.quit();
	}

}
