
public class ParenthesesChaeck {
    public boolean strFormat(String str) {
        int round = 0, curly = 0, square = 0;

        for (char ch : str.toCharArray()) {

            switch (ch) {
                case '(':
                    round++;
                    break;
                case ')':
                    round--;
                    break;
                case '{':
                    curly++;
                    break;
                case '}':
                    curly--;
                    break;
                case '[':
                    square++;
                    break;
                case ']':
                    square--;
                    break;
                default:
                    break;
            }
            

            if (round < 0 || curly < 0 || square < 0){
                return false;
            }
        }

        return round == 0 && curly == 0 && square == 0;
    }
}
