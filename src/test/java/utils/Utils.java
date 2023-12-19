package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static String normalizeString(String input) {
        input = input.trim();
        input = input.replaceAll("\\s+", " ");
        return input;
    }

    public static void scrollToElement(WebElement element, WebDriver drv) {
        ((JavascriptExecutor) drv).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String replaceSpacesAndNewlinesWithPluses(String input) {
        input = input.replaceAll("[ \n\r]+", "+");
        input = input.replaceAll("\\+{2,}", "+");

        return input;
    }

    public static String extractSubstringStartingAt(String input) {
        int atIndex = input.indexOf('@');
        if (atIndex != -1) {
            return input.substring(atIndex);
        }
        return input;
    }
}
