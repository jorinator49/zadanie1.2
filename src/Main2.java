import java.util.*;

class Main2 {
    String name;
    String strana;
    String janr;
    int godv;
    int prokat;

}

class Main2Info {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Введите количество фильмов: ");
        int count = sc.nextInt();
        Main2[] teams = new Main2[count];

        for (int i = 0; i < count; i++) {
            teams[i] = new Main2();
            sc.nextLine();
            System.out.println("Введите название фильма: ");
            teams[i].name = sc.nextLine();
            System.out.println("Страна: ");
            teams[i].strana = sc.nextLine();
            System.out.println("Жанр: ");
            teams[i].janr = sc.nextLine();
            System.out.println("Год выпуска: ");
            teams[i].godv = sc.nextInt();
            System.out.println("Стимость проката: ");
            teams[i].prokat = sc.nextInt();

        }
        System.out.println("Введены следующие команды");
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].name + " " + teams[i].strana + " " + teams[i].janr + " " + teams[i].godv + " " + teams[i].prokat);
        }

        int max = teams[0].prokat;
        int indexMax = 0;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].prokat > max) {
                max = teams[i].prokat;
                indexMax = i;
            }
        }
        System.out.println("Наибольшая цена:");
        System.out.println(teams[indexMax].name + " " + teams[indexMax].strana + " " + teams[indexMax].janr + " " + teams[indexMax].godv + " " + teams[indexMax].prokat);

        System.out.println("Средняя цена: ");
        double avgWins = 0;
        for (int i = 0; i < teams.length; i++) {
            avgWins += teams[i].prokat;
        }
        System.out.println("Фильм цена выше среднего:");
        double avgW = avgWins / teams.length;
        System.out.println(avgW);
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].prokat > avgW) {
                System.out.println(teams[i].name + " " + teams[i].strana + " " + teams[i].janr + " " + teams[i].godv + " " + teams[i].prokat);
            }
        }

        System.out.println("Сортировка массива:");
        boolean sorted = false;
        int rab;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < teams.length - 1; i++) {
                if (teams[i].godv > teams[i + 1].godv) {
                    sorted = false;
                    rab = teams[i].godv;
                    teams[i].godv = teams[i + 1].godv;
                    teams[i + 1].godv = rab;
                }
            }
        }
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].name + " " + teams[i].strana + " " + teams[i].janr + " " + teams[i].godv + " " + teams[i].prokat);
        }

        sc.nextLine();
        System.out.println("Введите поиск фильма:");
        String name = sc.nextLine();
        int index = -1;
        for (int i = 0; i < teams.length; i++) {
            if (name.equals(teams[i].name)) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println("Найдена запись!");
            System.out.println(teams[index]);
            System.out.println("Изменение поля:");
            System.out.println("name, strana");
            String editQuery = sc.nextLine();
            switch (editQuery) {
                case "name": {
                    System.out.println("Новое название фильма:");
                    String newName = sc.nextLine();
                    teams[index].name = newName;
                    break;
                }
                case "strana": {
                    System.out.println("Новая страна:");
                    String newCity = sc.nextLine();
                    teams[index].name = newCity;
                    break;
                }

                default: {
                    System.out.println("Поле ввода не существует");
                }
            }
        } else {
            System.out.println("Ничего не найдено!");
        }
        for (int j = 0; j < teams.length; j++) {
            System.out.println(teams[j].name + " " + teams[j].strana + " " + teams[j].janr + " " + teams[j].godv + " " + teams[j].prokat);
        }
    }
}
