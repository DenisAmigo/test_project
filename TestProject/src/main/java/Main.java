import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String IP_PATTERN = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите начальную границу IP-диапазона: ");
        final String firstRange = in.next();
        checkIPValues(firstRange);
        System.out.print("Введите конечную границу IP-диапазона: ");
        final String secondRange = in.next();
        checkIPValues(secondRange);
        final Long firstValue = ipToLong(firstRange);
        final Long secondValue = ipToLong(secondRange);
        checkCorrectRange(firstValue, secondValue);
        for (Long i = firstValue+1; i < secondValue; i++) {
            System.out.println(longToIp(i));
        }
    }

    /**
     * Данный метод преобразует адрес IP в Long
     * @param ip - IP-адрес в виде строки
     * @return - возвращает значение Long
     */
    public static long ipToLong(String ip) {
        String[] ipSplit = ip.split("\\.");
        long longIp = 0;
        for (int i = 0; i < ipSplit.length; i++) {
            longIp += Integer.parseInt(ipSplit[i]) * Math.pow(256, 3 - i);
        }
        return longIp;
    }

    /**
     * Данный метод преобразует Long в строку IP-адреса
     * @param longIp - Long-значение
     * @return - строка IP
     */
    public static String longToIp(long longIp) {
        return ((longIp >> 24) & 0xFF) + "." +
                ((longIp >> 16) & 0xFF) + "." +
                ((longIp >> 8) & 0xFF) + "." +
                (longIp & 0xFF);
    }

    private static void checkIPValues(String ip) {
        Pattern p = Pattern.compile(IP_PATTERN);
        Matcher m = p.matcher(ip);
        if (!m.matches()) {
            System.out.println("Неккоректная граница IP-диапазона");
            System.exit(0);
        }
    }

    private static void checkCorrectRange(Long ip1, Long ip2) {
        if (ip1 >= ip2) {
            System.out.println("Верхняя граница не может быть меньше или равна нижней границе!");
            System.exit(0);
        }
    }
}
