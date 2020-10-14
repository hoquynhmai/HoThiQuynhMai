package service;

import org.springframework.stereotype.Service;

@Service
public class TranslateImpl implements Translate {
    String[] english = {"today", "is", "monday", "tomorrow", "i", "go", "sleep"};
    String[] vietnamese = {"Hôm Nay", "Là", "Thứ Hai", "Ngày Mai", "Tôi", "đi", "ngủ"};

    public String translate(String word) {
        if (word.equals("")) {
            return "Do not leave it blank";
        }
        for (int i = 0; i < english.length; i++) {
            if (word.equals(english[i])) {
                return word + " mean: " + vietnamese[i];
            }
        }
        return word + " is not in the dictionary";
    }
}
