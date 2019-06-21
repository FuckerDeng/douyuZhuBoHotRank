package df.utils;

import org.jsoup.Jsoup;

import java.io.IOException;

public class MyUtils {
    public static void dengdeng(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String getHtml(String url) {
        String result = "";
        try {
            result = Jsoup.connect(url)
                    .timeout(600000)
                    .ignoreContentType(true)
                    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")
                    .execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
