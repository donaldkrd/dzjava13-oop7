import java.util.ArrayList;
import java.util.List;

public class Presenter {
    public StringBuilder sortValue(String client) {
        String finds = "qwertyuiop[]asdfghjkl;'zxcvbnmйцукенгшщзхъфывапрол=джэячсмитьбю!\"№%:?()ё~`@#$^&{}><";
        boolean flagOper = false;
        String[] getString = client.toLowerCase().split(" ");
        List<String> list = new ArrayList<>();
        for (String item : getString) {
            list.add(item);
        }
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] find = list.get(i).split("");
            for (String s : find) {
                newList.add(s);
            }
            for (int nl = 0; nl < newList.size(); nl++) {
                if (finds.contains(newList.get(nl))) {
                    newList.remove(nl);
                    nl = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int nl = 0; nl < newList.size(); nl++) {
            if (newList.get(nl).equals("+") || newList.get(nl).equals("-")
                    || newList.get(nl).equals("/") || newList.get(nl).equals("*")) {
                flagOper = true;
                sb.append(" ");
                sb.append(newList.get(nl));
                sb.append(" ");
            } else {
                sb.append(newList.get(nl));
            }
        }
        if (flagOper == false && !(client.equals("end"))) {
            System.out.println("Не корректный ввод, нет оператора, сервер зарован");
            return null;
        } else {
            return sb;
        }
    }

    public Double getX(StringBuilder client) {
        String temp = String.format("%s", client);
        String[] resultC = temp.split(" ");
        double a = Double.parseDouble(resultC[0]);
        return a;
    }

    public String getOper(StringBuilder client) {
        String temp = String.format("%s", client);
        String[] resultC = temp.split(" ");
        String oper = resultC[1];
        return oper;
    }

    public Double getY(StringBuilder client) {
        String temp = String.format("%s", client);
        String[] resultC = temp.split(" ");
        double b = Double.parseDouble(resultC[2]);
        return b;
    }
}
