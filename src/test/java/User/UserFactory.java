package User;

import Utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.admin_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }
    public static User withEmptyNamePermission() {
        return new User(PropertyReader.getProperty("saucedemo.empty_username"),
                PropertyReader.getProperty("saucedemo.password"));
    }
    public static User withEmptyPasswordPermission() {
        return new User(PropertyReader.getProperty("saucedemo.admin_user"),
                PropertyReader.getProperty("saucedemo.empty_password"));
    }
}
