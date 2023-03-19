package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

public interface TournamentTeamResponse {
    String getDpcPoints();
    Integer getPlace();
    String getPrice();
    String getSeed();

    Integer getTeamId();
    String getTeamImageId();
    String getTeamName();
    String getTeamShortName();
}
