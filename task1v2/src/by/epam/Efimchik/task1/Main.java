package by.epam.Efimchik.task1;

public class Main {

    public static void main(String[] args) {
        try {
            Start start = new Start();
            start.startMenu();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
