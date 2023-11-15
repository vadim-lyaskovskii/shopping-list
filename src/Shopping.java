import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");
        String[] shoppingList = new String[8];
        int productCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                // добавить товар
                if (productCount < shoppingList.length) {
                    System.out.println("Название товара должно быть написано без пробелов. " +
                            "Несколько слов нужно соединять символом подчёркивания. " +
                            "Например, так: «зерновой_хлеб».");
                    System.out.println("Введите название нового товара:");
                    String productName = scanner.next();
                    boolean isNotMatchProductName = true;
                    for (int i = 0; i < productCount; i++) {
                        if (productName.equals(shoppingList[i])) {
                            System.out.println("Такой товар уже есть в списке");
                            System.out.format("Позиция товара в списке № %d, название товара - «%s».\n",
                                    (i + 1), shoppingList[i]);
                            isNotMatchProductName = false;
                            break;
                        }
                    }
                    if (isNotMatchProductName) {
                        shoppingList[productCount] = productName;
                        System.out.format("Товар «%s» добавлен в список под номером %d.\n",
                                productName, (productCount + 1));
                        productCount++;
                    }
                } else {
                    System.out.println("Список товаров переполнен");
                    System.out.println("Сколько товаров нужно добавить в список? Введите число:");
                    int lengthNewArray = shoppingList.length + scanner.nextInt();
                    String[] swap = new String[shoppingList.length];
                    System.arraycopy(shoppingList, 0, swap, 0, swap.length);
                    shoppingList = new String[lengthNewArray];
                    System.arraycopy(swap, 0, shoppingList, 0, swap.length);
                }
            } else if (actionNumber == 2) {
                // показать список
                if (productCount > 0) {
                    System.out.println("Список товаров:");
                    for (int i = 0; i < productCount; i++) {
                        System.out.println((i + 1) + ". " + shoppingList[i]);
                    }
                    System.out.println("Всего товаров в списке: " + productCount);
                } else {
                    System.out.println("Список товаров пуст.");
                }
            } else if (actionNumber == 3) {
                // очистить список
                for (int i = 0; i < productCount; i++) {
                    shoppingList[i] = null;
                }
                productCount = 0;
                System.out.println("Список товаров пуст.");
            } else if (actionNumber == 4) {
                // завершить работу
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
