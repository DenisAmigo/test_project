import java.util.Scanner;

/**
 * Created by Амиго on 22.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final Long firstRange = ipToLong(in.next());
        final Long secondRange = ipToLong(in.next());
        for (Long i = firstRange; i < secondRange; i++) {
            System.out.println(longToIp(i));
        }
    }

    private static long ipToLong(String ip) {
        String[] ipSplit = ip.split("\\.");
        long longIp = 0;
        for (int i = 0; i < ipSplit.length; i++) {
            longIp += Integer.parseInt(ipSplit[i]) * Math.pow(256, 3 - i);
        }
        return longIp;
    }

    private static String longToIp(long longIp) {
        return ((longIp >> 24) & 0xFF) + "." +
                ((longIp >> 16) & 0xFF) + "." +
                ((longIp >> 8) & 0xFF) + "." +
                (longIp & 0xFF);
    }
}
