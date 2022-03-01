package by.epam.Efimchik.task1;

public class Main {

    public static void main(String[] args) {
        try {
            StartMenu start = new StartMenu();
            start.startMenu();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
