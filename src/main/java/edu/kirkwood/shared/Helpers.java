package edu.kirkwood.shared;
import edu.kirkwood.learnx.model.User;
import edu.kirkwood.personal_project.model.UserTwo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Helpers {
    public static long ageInYears(String birthDay) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(birthDay, formatter1);
        } catch(DateTimeParseException e) {
            try {
                birthDate = LocalDate.parse(birthDay, formatter2);
            } catch(DateTimeParseException e2) {
                return 0;
            }
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static User getUsersFromSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");

        return userFromSession;
    }

    public static boolean isActive(User user){
        boolean status = false;
        if(user != null && user.getStatus().equals("active")){
            status = true;
        }

        return status;
    }

    public static boolean isStudent(User user){
        boolean status = false;
        if(isActive(user) == true &&  user.getPrivileges().equals("student")){
            status = true;
        }
        return status;
    }

    public static boolean isTeacher(User user){
        boolean status = false;
        if(isActive(user) == true &&  user.getPrivileges().equals("teacher")){
            status = true;
        }

        return status;
    }

    public static boolean isAdmin(User user){
        boolean status = false;
        if(isActive(user) == true &&  user.getPrivileges().equals("admin")){
            status = true;
        }
        return status;
    }


    public static boolean isActiveDbz(UserTwo userTwo){
        boolean status = false;
        if(userTwo != null && userTwo.getStatus().equals("active")){
            status = true;
        }

        return status;
    }
    public static boolean isPlayer(UserTwo userTwo){
        boolean status = false;
        if(isActiveDbz(userTwo) == true && userTwo.getPrivileges().equals("player")){
            status = true;
        }
        return status;
    }


}
