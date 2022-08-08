import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TeamResponse } from './team.response.model';
import { TeamService } from './team.service';

interface TeamRegion {
  name: string,
  checked: boolean,
  value: string
}

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  public teams: TeamResponse[];
  public teamsLoaded: boolean[];
  public regions: TeamRegion[] = [
    { name: "Western Europe", checked: true, value: "WESTERN_EUROPE" },
    { name: "Eastern Europe", checked: false, value: "EASTERN_EUROPE" },
    { name: "China", checked: false, value: "CHINA" },
    { name: "Southeast Asia", checked: false, value: "SOUTHEAST_ASIA" },
    { name: "North America", checked: false, value: "NORTH_AMERICA" },
    { name: "South America", checked: false, value: "SOUTH_AMERICA" },
  ];

  constructor(private teamService: TeamService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const region = this.activatedRoute.snapshot.queryParamMap.get("region");
    if (region) {
      const validRegion = this.regions.find(r => r.value === region);
      if (validRegion) {
        this.updateTeams(region);
        this.updateParam(region);

        this.regions[0].checked = false;
        validRegion.checked = true;
      } else {
        this.initDefaultRegion();
      }
    } else {
      this.initDefaultRegion();
    }
  }

  private initDefaultRegion(): void {
    const defaultRegion = this.regions[0].value;
    this.updateTeams(defaultRegion);
    this.updateParam(defaultRegion);
  }

  changeRegion(region: TeamRegion): void {
    const lastChecked = region.checked
    if (lastChecked !== true) {
      this.regions.forEach( r => r.checked = false);
      region.checked = true;
      this.updateTeams(region.value);
      this.updateParam(region.value);
    }
  }

  selectTeam(team: TeamResponse): void {
    this.router.navigate(['/team/' + team.teamId, { }]);
  }
  
  private updateTeams(region: string): void {
    this.teamService.getTeams(region)
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

  private updateParam(region: string): void {
    this.router.navigate(
      ['/team'],
      { queryParams: { region: region } }
    );
  }
}
