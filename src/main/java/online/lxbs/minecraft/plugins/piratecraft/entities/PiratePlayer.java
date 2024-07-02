package online.lxbs.minecraft.plugins.piratecraft.entities;

public class PiratePlayer {
    private Integer points;
    private String team;

    public PiratePlayer(Integer points, String team) {
        this.points = points;
        this.team = team;
    }

    public Integer getPoints() {
        return points;
    }

    public String getTeam() {
        return team;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
