import java.util.*;

public class Main {
    private static Map<String, List<String>> phoneBook = new HashMap<String, List<String>>();

    public static void main(String[] args) {
        addAll("Иванов И.И.", addPhones("+8 800 2000 500", "+8 800 200 600"));
        addAll("Петров П.П.", addPhones("+8 800 2000 700"));
        addAll("Сидоров С.С.", addPhones("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000"));
        final Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО абонента: ");
        final String name = in.nextLine();
        final List<String> phones = getPhonesByName(name);
        if (phones != null) {
            for (int i = 0; i < phones.size(); i++) {
                System.out.println(i + 1 + ". " + phones.get(i));
            }
        } else {
            System.out.println("Такого абонента в БД нет!");
        }
    }

    // По-хорошему, нужно использовать MultiMap из библиотеки guava, но постановка задачи другая
    private static void addAll(String name, List<String> numbers) {
        phoneBook.put(name, numbers);
    }

    public static List<String> addPhones(String... numbers) {
        List<String> phonesList = new ArrayList<String>();
        Collections.addAll(phonesList, numbers);
        return phonesList;
    }

    private static List<String> getPhonesByName(String name) {
        return phoneBook.get(name);
    }
}
