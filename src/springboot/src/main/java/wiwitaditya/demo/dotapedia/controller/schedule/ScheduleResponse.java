package wiwitaditya.demo.dotapedia.controller.schedule;

public interface ScheduleResponse {
    String getStartDate();

    Integer getTeamAId();
    String getTeamAName();
    Integer getTeamAScore();

    Integer getTeamBId();
    String getTeamBName();
    Integer getTeamBScore();

    Integer getTournamentId();
    String getTournamentRegion();
    String getTournamentName();
    String getTournamentImage();
}
