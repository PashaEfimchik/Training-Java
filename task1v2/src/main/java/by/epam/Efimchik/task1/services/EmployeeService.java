package by.epam.Efimchik.task1.services;

public class EmployeeService {

    public boolean isUsernameExist(String username) {
        return username.equals("admin");
    }

    public boolean isEmailExist (String email) {
        return email.equals("admin@example.com");
    }
}
