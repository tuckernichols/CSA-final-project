public class Property {
    private String name;
    private String buyPrice;
    private boolean isavailable = true;

    public Property(String name, String buyPrice, boolean isavailable) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.isavailable = isavailable;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return buyPrice;
    }

    public boolean isAvailable() {
        return isavailable;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                '}';
    }
}

