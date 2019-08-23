package org.noahsark;

import org.noahsark.bean.Word;
import org.noahsark.bean.WordBook;
import org.noahsark.util.XmlBeanUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordTransition {

    private static final String FILE_PATH = "E:\\lab\\docx2xml\\src\\main\\resources\\words-2000.txt";

    public static void main(String[] args) {
        readWrodText();
    }

    private static void readWrodText() {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));

            String line = null;
            String regex = null;
            Pattern pattern = null;
            Matcher matcher = null;
            WordBook wordBook = new WordBook();
            List<Word> item = new ArrayList<>();
            wordBook.setItem(item);
            Word word = null;

            regex = "^(\\d+)\\s+([a-zA-Z]+)\\s+(\\[.*\\])\\s+(.*)$";

            pattern = Pattern.compile(regex);

            while ((line = reader.readLine()) != null) {

                if (Pattern.matches(regex,line)) {
                    matcher = pattern.matcher(line);

                    if (matcher.find()) {
                        word = new Word();

                        System.out.println(matcher.group(0));

                        word.setWord(matcher.group(2));
                        word.setPhonetic(matcher.group(3));
                        word.setTrans(matcher.group(4));
                        item.add(word);

                        //System.out.printf("%s:%s:%s:%s\n",matcher.group(1),matcher.group(2),matcher.group(3),matcher.group(4));
                    }

                }
            }

            System.out.println(XmlBeanUtils.parseBean2Xml(WordBook.class, wordBook));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

