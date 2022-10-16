public class DigitMsg {
    int pointer = 0;
    String[] digits = new String[]{"a","b","c","test","words"};

    public String getDigit(){
        if (pointer == digits.length){
            return "";
        }
        return digits[pointer++];
    }

    public boolean isLastDigit(){
        return pointer == digits.length;
    }
}
