package service;

import org.springframework.stereotype.Service;

@Service
public class TranslateImpl implements Translate {
   String[] english = {"today", "is","monday","tomorrow","i","go","sleep"};
   String[] vietnamese = {"Hôm Nay","Là","Thứ Hai","Ngày Mai", "Tôi","đi","ngủ"};
     public String translate(String word) {
        if (word.equals("")){
            return "Invalid Word";
        }
        for (int i = 0; i< english.length; i++){
            english[i].equals(word);
            return english[i] + " mean: " + vietnamese[i];
        } return "The entered word "+ word + " is not in the dictionary";
    }
}
