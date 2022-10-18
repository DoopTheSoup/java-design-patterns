import lombok.Getter;

public class DigitMsg {
    @Getter private String producer;
    @Getter private int id;
    int pointer = 0;
    String[] digits = new String[]{"a","b","c","test","words"};

    // Get current digit - case added for pointer being at the end
    public String getDigit(){
        if (pointer == digits.length){
            return "";
        }
        return digits[pointer++];
    }

    // Check if last digit
    public boolean isLastDigit(){
        return pointer == digits.length;
    }
}
