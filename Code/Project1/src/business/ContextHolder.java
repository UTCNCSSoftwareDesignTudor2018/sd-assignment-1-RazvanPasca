package business;

import model.User;

public class ContextHolder {
    private static User user;

    public static User getCurrentUser() {
        return user;
    }

    public static void setCurrentUser(User nuser) {
        user = nuser;
    }
}
