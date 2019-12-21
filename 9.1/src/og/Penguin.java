package og;

public class Penguin {
    private final int birthYear;
    private final String name;
    private final Gender gender;
    private Fish favoriteFish;

    public Penguin(int birthYear, String name, Gender gender, Fish favoriteFish) {
        this.birthYear = birthYear;
        this.name = name;
        this.gender = gender;
        this.favoriteFish = favoriteFish;
    }

    @Override
    public boolean equals(Object other) {
        // TODO
        if(other instanceof Penguin){
            Penguin otherPenguin = (Penguin) other;
            return this.getBirthYear() == otherPenguin.getBirthYear() && this.getName().equals(otherPenguin.getName()) && this.getGender() == otherPenguin.getGender();
        }else{
            return false;
        }
    }

    public int hashCode() {
        // TODO
        return super.hashCode()+this.getBirthYear();
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Fish getFavoriteFish() {
        return favoriteFish;
    }

    public void setFavoriteFish(Fish favoriteFish) {
        this.favoriteFish = favoriteFish;
    }

}
