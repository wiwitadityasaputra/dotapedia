import { Component, OnInit } from '@angular/core';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { TournamentModel } from './tournament.model';
import { TournamentService } from './tournament.service';

@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css']
})
export class TournamentComponent implements OnInit {

  public tournaments: TournamentModel[] = [];
  public allRegion: boolean = true;
  public regions = [
    { name: "Western Europe", checked: true, value: "WESTERN_EUROPE" },
    { name: "Eastern Europe", checked: true, value: "EASTERN_EUROPE" },
    { name: "China", checked: true, value: "CHINA" },
    { name: "Southeast Asia", checked: true, value: "SOUTHEAST_ASIA" },
    { name: "North America", checked: true, value: "NORTH_AMERICA" },
    { name: "South America", checked: true, value: "SOUTH_AMERICA" },
  ];

  constructor(private tournamentService: TournamentService) { }

  ngOnInit(): void {
    this.updateTournaments();
  }

  allRegionChange(event: MatCheckboxChange): void {
    const checked = event.checked;
    Object.entries(this.regions).forEach(([key, value]) => {
      value.checked = checked;
    });

    if (checked) {
      this.updateTournaments();
    }
  }

  selectedRegionChange(event: MatCheckboxChange): void {
    if (!event.checked) {
      this.allRegion = false;
    }
    this.updateTournaments();    
  }

  private updateTournaments(): void {
    let regions: string = "";
    Object.entries(this.regions).forEach(([key, value]) => {
      if (value.checked) {
        regions += "," + value.value;
      }
    });

    this.tournamentService.getTournaments(regions.slice(1)).subscribe((response) => {
      // this.tournaments = response;
      this.tournaments.push(response[0]);this.tournaments.push(response[1]);
      this.tournaments.push(response[0]);this.tournaments.push(response[1]);
    });
  }
}
