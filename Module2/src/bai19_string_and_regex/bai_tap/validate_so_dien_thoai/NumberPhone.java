package bai19_string_and_regex.bai_tap.validate_so_dien_thoai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhone {
    private static final String NUMBER_PHONE_REGEX = "^[(]+[0-9]{2}[)][-][(]+[0]+[0-9]{9}[)]$";

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NUMBER_PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
