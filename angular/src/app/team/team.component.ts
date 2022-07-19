import { Component, OnInit } from '@angular/core';
import { MatTabChangeEvent } from '@angular/material/tabs';
import { RegionService, RegionType } from '../utility/region.service';
import { TeamResponse } from './team.response.model';
import { TeamModel } from './team.view.model';
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

  constructor(private teamService: TeamService, private regionService: RegionService) { }

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
    // this.regions[index].checked = !this.regions[index].checked;
  }
  
  private updateTeams(index: number): void {
    this.teamService.getTeams(this.regionService.getRegionByIndex(index))
    .subscribe((teams) => {
      console.log(teams)
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

  /*
  ngOnInit(): void {
    const totalRegion = this.regions.length;
    this.teams = new Array(totalRegion).fill([]).map(() => []);
    this.teamsLoaded = new Array(totalRegion).fill(false);
    this.updateTeams(0);
  }

  changeRegion(index: number) {
    if (false === this.regions[index].checked) {
      this.regions.forEach( r => r.checked = false);
      this.regions[index].checked = true;
    }
    if (!this.teamsLoaded[index]) {
      this.updateTeams(index);
    }
  }

  public tabChanged(event: MatTabChangeEvent): void {
    const index = event.index;
    if (this.teams[index].length == 0) {
      this.updateTeams(index);
    }
  }

  private updateTeams(index: number): void {
    this.teamsLoaded[index] = false;
    this.teamService.getTeams(this.regionService.getRegionByIndex(index))
      .subscribe((response: TeamResponse[]) => {
        this.teamsLoaded[index] = true;
        
        let teamViewModel: TeamModel = {
          teamA: null,
          teamB: null
        };
        let teamA: boolean = true;

        for (let key in response) {
          let team: TeamResponse = response[key];
          this.teamService.getPlayers(team.teamId)
            .subscribe((players) => {
              team.players = players;
            });

          if (teamA) {
            teamA = false;
            teamViewModel = {
              teamA: team,
              teamB: null
            }
          } else {
            teamA = true;
            teamViewModel.teamB = team;

            this.teams[index].push(teamViewModel);
          }
        }
      });
  }
  */
}
