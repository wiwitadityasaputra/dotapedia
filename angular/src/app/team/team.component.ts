import { Component, OnInit } from '@angular/core';
import { MatTabChangeEvent } from '@angular/material/tabs';
import { RegionService, RegionType } from '../utility/region.service';
import { TeamViewModel } from './model/team-view.model';
import { TeamModel } from './model/team.model';
import { TeamService } from './team.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  public teams: TeamViewModel[][];
  public teamsLoaded: boolean[];
  public regions: RegionType[];

  constructor(private teamService: TeamService, private regionService: RegionService) { }

  ngOnInit(): void {
    this.regions = this.regionService.getAllRegions();
    const totalRegion = this.regions.length;
    this.teams = new Array(totalRegion).fill([]).map(() => []);
    this.teamsLoaded = new Array(totalRegion).fill(false);
    this.updateTeams(0);
  }

  public tabChanged(event: MatTabChangeEvent): void {
    const index = event.index;
    if (this.teams[index].length == 0) {
      this.updateTeams(index);
    }
  }

  private updateTeams(index: number): void {
    this.teamsLoaded[index] = false;
    this.teamService.getTeams(this.regionService.getRegionByIndex(index)).subscribe((response) => {
      this.teamsLoaded[index] = true;
      
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

          this.teams[index].push(teamViewModel);
        }
      }
    });
  }

}
