package BasicConcepts;

import java.io.*;

public class SerializationPrac {

    public static void main(String[] args) {
        User user = new User("ronaldo", "cr7@123");

        try {
            // Step 2: Serialization (Object → Byte Stream)
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
            oos.writeObject(user);
            oos.close();
            System.out.println("✅ Serialization done: " + user);

            // Step 3: Deserialization (Byte Stream → Object)
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"));
            User deserializedUser = (User) ois.readObject();
            ois.close();

            System.out.println("✅ Deserialization done: " + deserializedUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    String username;
    transient String password; // won't be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}
