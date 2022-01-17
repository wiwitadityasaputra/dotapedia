import { Component, OnInit } from '@angular/core';
import { TeamViewModel } from './model/team-view.model';
import { TeamModel } from './model/team.model';
import { TeamService } from './team.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  public teams: TeamViewModel[];

  constructor(private teamService: TeamService) { }

  ngOnInit(): void {
    this.teamService.getTeams().subscribe((response) => {
      this.teams = [];
      let teamViewModel: TeamViewModel = {
        teamA: null,
        teamB: null
      };
      let teamA: boolean = true;

      for (let key in response) {
        let team: TeamModel = response[key];

        if (teamA) {
          teamA = false;
          teamViewModel = {
            teamA: team,
            teamB: null
          }
        } else {
          teamA = true;
          teamViewModel.teamB = team;

          this.teams.push(teamViewModel);
        }
      }
    });
  }

}
