public class User {
    public String name;
    public int age;
    public Listing[] listings;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.listings = new Listing[10];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    
}
