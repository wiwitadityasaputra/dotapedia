import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TournamentModel } from '../tournament.response.model';
import { TournamentService } from '../tournament.service';

@Component({
  selector: 'app-all-tournament',
  templateUrl: './tournament-all.component.html',
  styleUrls: ['./tournament-all.component.css']
})
export class TournamentAllComponent implements OnInit {

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

  constructor(private router: Router,
    private activatedRoute: ActivatedRoute,
    private tournamentService: TournamentService) {
    }

  ngOnInit(): void {
    const regions = this.activatedRoute.snapshot.queryParamMap.get("regions");
    if (regions) {
      this.updateTourney(regions);
      const regionArray = regions.split(",");
      regionArray.forEach(r => {
        if (r && r.trim().length > 0) {
          console.log('r = ', r)
          const region = this.regions.find( region => region.value == r);
          if (region) {
            region.checked = true;
          }
        }
      });
      this.allRegion = regionArray[0] == "ALL";
    } else {
      this.updateTourney("ALL");
      this.updateParam("ALL");
    }
  }

  toggleAllRegion(): void {
    if (this.allRegion) {
      this.updateTourney("ALL");
      this.updateParam("ALL");
      this.regions.forEach((region) => {
        region.checked = false;
      });
    } else {
      this.tournaments = [];
    }
  }

  toggleRegion(): void {
    this.allRegion = false;

    let regions: string = "";
    Object.entries(this.regions).forEach(([key, value]) => {
      if (value.checked) {
        regions += value.value + ",";
      }
    });
    if (regions === "") {
      this.tournaments = [];
    } else {
      this.updateTourney(regions);
      this.updateParam(regions);
    }
  }

  private updateTourney(selectedRegion: string) {
    this.tournamentService.getTournaments(selectedRegion).subscribe((response) => {
      this.tournaments = response;
    });
  }

  private updateParam(regions: string): void {
    this.router.navigate(
      ['/tournament'],
      { queryParams: { regions: regions } }
    );
  }

  selectTournament(tournament: TournamentModel): void {
    this.router.navigate(['/tournament/' + tournament.id, { }]);
  }
}
