public class Cereal {
    String name;
    final float rating;
    public Cereal(String name, float rating) {
        this.name = name;
        this.rating = rating;
    }

    public float getProperty(Constants.CEREAL_PROPERTIES cp) {
        switch (cp) {
            case RATING:
                return this.rating;
            default:
                return 0;
        }
    }

    public String toString() {
        return name;
    }
}
