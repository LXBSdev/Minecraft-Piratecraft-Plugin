package online.lxbs.minecraft.plugins.piratecraft.instance;

public enum Team {
    RED("Red"),
    BLUE("Blue");

    private final String name;

    Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
