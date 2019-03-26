package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            boolean doContains = false;
            for (char c : url.toCharArray()) {
                if (Character.isDigit(c)) {
                    doContains=true;
                    break;
                }
            }

            if(doContains){
                sb.append("Invalid URL!");
            }else{
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean doContains = false;
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) {
                    doContains = true;
                    break;
                }
            }
            if (doContains) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
