import java.util.*;
import static java.lang.Math.*;

/* Федотов Николай ПИЭ 22
Разработать класс для хранения информации о фильмах:
Название_фильма, год_выпуска, страна, жанр, стоимость_проката*/

class Main {
    String name;
    String strana;
    String janr;
    int godv;
    int prokat;

    public void printFilm() {
        System.out.println(this.name + " " + this.strana + " " + this.janr + " " + this.godv + " " + this.prokat);
    }

}

class Info {
    static Scanner sc;
    public static Main[] fillArray(int count) {
        Main[] teams = new Main[count];
        for (int i = 0; i < count; i++) {
            teams[i] = new Main();
            System.out.println("Введите название фильма: ");
            teams[i].name = sc.nextLine();
            System.out.println("Страна: ");
            teams[i].strana = sc.nextLine();
            System.out.println("Жанр: ");
            teams[i].janr = sc.nextLine();
            System.out.println("Год выпуска: ");
            teams[i].godv = sc.nextInt();
            System.out.println("Стоимость проката: ");
            teams[i].prokat = sc.nextInt();
            sc.nextLine();
        }
        return teams;
    }

    public static void printFilms(Main[] teams){
        for (int i = 0; i < teams.length; i++){
            teams[i].printFilm();
        }
    }

    public static Main findBest(Main[] teams){
        int max = teams[0].prokat;
        int indexMax = 0;
        for (int i = 0; i < teams.length; i++){
            if(teams[i].prokat>max){
                max = teams[i].prokat;
                indexMax = i;
            }
        }
        return teams[indexMax];
    }

    public static double winsAvg(Main[] teams){
        double avgWins = 0;
        for(int i = 0; i < teams.length; i++){
            avgWins += teams[i].prokat;
        }
        return (avgWins / teams.length);
    }

    public static void printAvg(Main[] teams, double avgW){
        for (int i = 0; i < teams.length; i++){
            if (teams[i].prokat > avgW){
                teams[i].printFilm();
            }
        }
    }

    public static Main[] findAvg(Main[] teams, double avgW){
        int countAvg = 0;
        for (int i = 0; i < teams.length; i++){
            if (teams[i].prokat > avgW){
                countAvg++;
            }
        }
        Main[] teamAvg = new Main[countAvg];
        int a = 0;
        for (int i = 0; i < teams.length; i++){
            if(teams[i].prokat > avgW){
                teamAvg[a] = teams[i];
                a++;
            }
        }
        return teamAvg;
    }
    public static int findFilm(Main[] teams, String name){
        int index = -1;
        for (int i = 0; i<teams.length; i++){
            if(name.equals(teams[i].name)){
                index = i;
            }
        }
        return index;
    }

    public static void sortPlace(Main[] teams){
        boolean sorted = false;
        int rab;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < teams.length-1; i++) {
                if (teams[i].godv > teams[i+1].godv) {
                    sorted = false;
                    rab = teams[i].godv;
                    teams[i].godv = teams[i+1].godv;
                    teams[i+1].godv = rab;
                }
            }
        }
    }

    public static void editTeam(Main team){
        System.out.println("Изменение поля:");
        System.out.println("name, strana");
        String editQuery = sc.nextLine();
        switch (editQuery){
            case "name": {
                System.out.println("Новое название фильма:");
                String newName = sc.nextLine();
                team.name = newName;
                break;
            }
            case "strana": {
                System.out.println("Новая страна:");
                String newCity = sc.nextLine();
                team.name = newCity;
                break;
            }

            default: {
                System.out.println("Поле ввода не существует");
            }
        }

    }
    public static void main(String[] args){
        Main team = new Main();

        sc = new Scanner(System.in);
        System.out.println("Введите количество фильмов: ");
        int count = sc.nextInt();
        sc.nextLine();
        Main[] teams = fillArray(count);
        printFilms(teams);
        Main teamB = findBest(teams);
        System.out.println("Наибольшая цена:");
        teamB.printFilm();
        double avgW = winsAvg(teams);
        System.out.println("Среднее цена: " + avgW);
        System.out.println("Фильм цена выше среднего:");
        printAvg(teams, avgW);
        System.out.println("Сортировка массива:");
        sortPlace(teams);
        printFilms(teams);

        System.out.println("Введите поиск фильма:");
        String nameFind = sc.nextLine();
        int indexF = findFilm(teams, nameFind);
        if (indexF != -1){
            System.out.println("Найдена запись!");
            System.out.println(teams[indexF]);
            editTeam(teams[indexF]);
        } else{
            System.out.println("Ничего не найдено!");
        }
        printFilms(teams);
    }
}