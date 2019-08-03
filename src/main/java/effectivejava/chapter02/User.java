package effectivejava.chapter02;

public class User {
    private String username;
    private String password;
    private String address;
    private int age;
    private String email;
    private int point;

    public static class Builder {
        private String username;
        private String password;
        private String address;
        private int age;
        private String email;
        private int point = 100;

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder point(int point) {
            this.point = point;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        username = builder.username;
        password = builder.password;
        address = builder.address;
        age = builder.age;
        email = builder.email;
        point = builder.point;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }
}
