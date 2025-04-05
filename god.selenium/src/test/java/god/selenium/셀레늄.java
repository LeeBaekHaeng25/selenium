package god.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class 셀레늄 {

	WebDriver driver;

	@BeforeEach
	void setup() {
//		driver = new ChromeDriver();

		// 크롬 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled"); // 봇 감지 우회

//		options.addArguments("--headless"); // 헤드리스 모드 활성화
//		options.addArguments("--disable-gpu"); // GPU 비활성화 (필요한 경우)
//		options.addArguments("--window-size=1920x1080"); // 화면 크기 설정

		driver = new ChromeDriver(options);
	}

	@Test
	void test() {
		if (log.isDebugEnabled()) {
			log.debug("셀레늄");
		}

		// https://www.selenium.dev/documentation/webdriver/getting_started/using_selenium/

		driver.get("https://www.google.com/");

		String title = driver.getTitle();
		if (log.isDebugEnabled()) {
			log.debug("title={}", title);
		}

		// given

		// document.querySelectorAll('#APjFqb')
		// document.querySelectorAll('[name="q"]')

//		WebElement qWebElement = driver.findElement(By.id("APjFqb"));
		WebElement qWebElement = driver.findElement(By.name("q"));

		if (log.isDebugEnabled()) {
			log.debug("q.value={}", qWebElement.getAttribute("value"));
		}

		String qkeysToSend = "이백행";

		qWebElement.sendKeys(qkeysToSend);

		if (log.isDebugEnabled()) {
			log.debug("q.value={}", qWebElement.getAttribute("value"));
		}

		// when
		qWebElement.sendKeys(Keys.ENTER);

		WebElement qWebElement2 = driver.findElement(By.name("q"));
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
