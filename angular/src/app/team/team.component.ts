import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegionService } from '../utility/region.service';
import { TeamResponse } from './team.response.model';
import { TeamService } from './team.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  public teams: TeamResponse[];
  public teamsLoaded: boolean[];
  public regions = [
    { name: "Western Europe", checked: true, value: "WESTERN_EUROPE" },
    { name: "Eastern Europe", checked: false, value: "EASTERN_EUROPE" },
    { name: "China", checked: false, value: "CHINA" },
    { name: "Southeast Asia", checked: false, value: "SOUTHEAST_ASIA" },
    { name: "North America", checked: false, value: "NORTH_AMERICA" },
    { name: "South America", checked: false, value: "SOUTH_AMERICA" },
  ];

  constructor(private teamService: TeamService,
    private regionService: RegionService,
    private router: Router) { }

  ngOnInit(): void {
    this.updateTeams(0);
  }

  changeRegion(index: number): void {
    const lastChecked = this.regions[index].checked;
    if (lastChecked !== true) {
      this.regions.forEach( r => r.checked = false);
      this.regions[index].checked = true;
      this.updateTeams(index);
    }
  }

  selectTeam(team: TeamResponse): void {
    this.router.navigate(['/team/' + team.teamId, { }]);
  }
  
  private updateTeams(index: number): void {
    this.teamService.getTeams(this.regionService.getRegionByIndex(index))
    .subscribe((teams) => {
      this.teams = teams;
      this.teams.forEach((team) => {
        if (team.name.indexOf("Team") >= 0) {
          team.name = team.name.substring(4).trim();
        }

        this.teamService.getPlayers(team.teamId)
          .subscribe((players) => {
            team.players = players;
          });
      });
    });
  }
}
