import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { ScheduleResponse } from 'src/app/schedule/schedule.response.model';
import { ScheduleView } from 'src/app/schedule/schedule.view.model';
import { RegionService } from 'src/app/utility/region.service';
import { TeamDetailResponse, TeamPlayerResponse } from '../team.response.model';
import { TeamService } from '../team.service';
import { TeamDetailView } from '../team.view.model';

@Component({
  selector: 'app-team-detail',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDeatilComponent implements OnInit {

  public team: TeamDetailView;
  public playersTop: TeamPlayerResponse[];
  public playersBottom: TeamPlayerResponse[];

  constructor(private activatedRoute: ActivatedRoute,
    private teamService: TeamService,
    private regionService: RegionService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((param: any) => {
      const teamId = param.teamId;

      this.teamService.getPlayers(teamId).subscribe( response => {
        this.playersTop = response.slice(0, 3);
        this.playersBottom = response.slice(3, 5);
      });

      this.teamService.getTeam(teamId).subscribe( response => {
        this.team = {
          team: {
            id: response.team.id,
            name: response.team.name,
            shortName: response.team.shortName,
            image: response.team.image,
            region: response.team.region,
            sponsors: response.team.sponsors,
            totalEarnings: response.team.totalEarnings,
            biographies: []
          },
          latestMatch: this.scheduleResponseToViews(response.latestMatch),
          upcomingMatch: this.scheduleResponseToViews(response.upcomingMatch)
        };
        this.team.team.biographies = [];
        response.team.biography.split("\n").forEach(b => {
          this.team.team.biographies.push(b);
        });
      });
    });
  }

  private scheduleResponseToViews(schedules: ScheduleResponse[]): ScheduleView[] {
    let sv: ScheduleView[] = [];
    schedules.forEach(s => {
      sv.push(this.scheduleResponseToView(s));
    })
    return sv;
  }

  private scheduleResponseToView(r: ScheduleResponse): ScheduleView {
    return {
      startDate: r.startDate,
      
      direTeamId: r.teamAId,
      direTeamName: r.teamAName,
      direScore: r.teamAScore,

      radiantTeamId: r.teamBId,
      radiantTeamName: r.teamBName,
      radiantScore: r.teamBScore,
      
      tournamentId: r.tournamentId,
      tournamentImage: r.tournamentImage,
      tournamentName: r.tournamentName,
      tournamentRegion: r.tournamentRegion,

      regionAbbr: this.regionService.getRegionAbbreviationByKey(r.tournamentRegion),
      startDateStr: moment(parseInt(r.startDate)).format('YYYY, MMMM DD, hh:mm'),
    }
  }
}