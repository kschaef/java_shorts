package shorts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class stopwords{
    public static String getText(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String text = doc.body().text();
        return text;
    }

    public static ArrayList<String> filterStopwords(String[] splitWords) throws IOException {
        String stopwordsUrl = "http://ir.dcs.gla.ac.uk/resources/linguistic_utils/stop_words";
        String[] stopwords = getText(stopwordsUrl).split(" ");

        ArrayList<String> cleanedWords = new ArrayList<String>();
        for (String a : splitWords){
            if (!Arrays.asList(stopwords).contains(a)){
                cleanedWords.add(a);
            }
        }
        return cleanedWords;
    }

    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Micrometre";
        String webpageWords = getText(url);
        System.out.println(webpageWords);
        String[] splitPage = webpageWords.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        ArrayList<String> filteredWords = filterStopwords(splitPage);
        System.out.println(filteredWords);
    }
}