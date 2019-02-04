
package github.hemandroid.transformerswar.TransformerModelData.transformersList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransformerData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("strength")
    @Expose
    private int strength;
    @SerializedName("intelligence")
    @Expose
    private int intelligence;
    @SerializedName("speed")
    @Expose
    private int speed;
    @SerializedName("endurance")
    @Expose
    private int endurance;
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("courage")
    @Expose
    private int courage;
    @SerializedName("firepower")
    @Expose
    private int firepower;
    @SerializedName("skill")
    @Expose
    private int skill;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("team_icon")
    @Expose
    private String teamIcon;

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }

}
