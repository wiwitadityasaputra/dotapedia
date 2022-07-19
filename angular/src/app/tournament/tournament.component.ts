import { Component, OnInit } from '@angular/core';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { Router } from '@angular/router';
import { TournamentModel } from './tournament.response.model';
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
    { name: "Western Europe", checked: false, value: "WESTERN_EUROPE" },
    { name: "Eastern Europe", checked: false, value: "EASTERN_EUROPE" },
    { name: "China", checked: false, value: "CHINA" },
    { name: "Southeast Asia", checked: false, value: "SOUTHEAST_ASIA" },
    { name: "North America", checked: false, value: "NORTH_AMERICA" },
    { name: "South America", checked: false, value: "SOUTH_AMERICA" },
  ];

  constructor(private router: Router, private tournamentService: TournamentService) { }

  ngOnInit(): void {
    this.updateTourney("ALL");
  }

  toggleAllRegion(): void {
    if (this.allRegion) {
      this.updateTourney("ALL");
      this.regions.forEach((region) => {
        region.checked = false;
      })
    } else {
      this.tournaments = [];
    }
  }

  toggleRegion(): void {
    this.allRegion = false;

    let regions: string = "";
    Object.entries(this.regions).forEach(([key, value]) => {
      if (value.checked) {
        regions += "," + value.value;
      }
    });
    if (regions === "") {
      this.tournaments = [];
    } else {
      this.updateTourney(regions);
    }
  }

  private updateTourney(selectedRegion: string) {
    this.tournamentService.getTournaments(selectedRegion).subscribe((response) => {
      this.tournaments = response;
    });
  }

  selectTournament(tournament: TournamentModel): void {
    this.router.navigate(['/tournament/' + tournament.id, { }]);
  }
}
