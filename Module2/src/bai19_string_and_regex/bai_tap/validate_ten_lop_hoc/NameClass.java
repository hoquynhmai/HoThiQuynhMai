package bai19_string_and_regex.bai_tap.validate_ten_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static final String NAME_CLASS_REGEX = "^[C|A|P]+[0-9]{4}[G|H|I|K|L|M]$";

    public NameClass() {
    }

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NAME_CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
