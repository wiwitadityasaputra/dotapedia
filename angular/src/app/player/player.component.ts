import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Player, PlayerCountry } from "./player.response.model";
import { PlayerService } from "./player.service";
import { PlayerCountryView } from "./player.view.model";

@Component({
    selector: 'app-player',
    templateUrl: './player.component.html',
    styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

    public playerCountries: PlayerCountryView[] = [];
    public players: Player[];
    public countryFlag: boolean = false;

    constructor(private router: Router,
        private activatedRoute: ActivatedRoute,
        private playerService: PlayerService) {
    }

    ngOnInit(): void {
        const countries = this.activatedRoute.snapshot.queryParamMap.get("countries");
        let arrayCountry: string[] = [];
        if (countries) {
            arrayCountry = countries.split(",");
        }

        this.playerService.getPlayerCountries().subscribe((response: PlayerCountry[]) => {
            response.forEach( pc => {
                this.playerCountries.push({
                    country: pc.country,
                    totalPlayer: pc.totalPlayer,
                    selected: false
                })
            });

            arrayCountry.forEach(c => {
                const cLower = c.toLocaleLowerCase();
                const pc = this.playerCountries.find( pc => pc.country.toLocaleLowerCase() == cLower);
                if (pc) {
                    pc.selected = true;
                }
            });
            this.updatePlayers();
        });
    }

    public selecCountry(pc: PlayerCountryView): void {
        pc.selected = !pc.selected;
        this.updatePlayers();
    }

    private updatePlayers(): void {
        let selectedCountries = "";
        this.playerCountries.forEach(pc => {
            if (pc.selected) {
                selectedCountries += pc.country + ",";
            }
        });

        if (selectedCountries.length >= 1) {
            this.playerService.getPlayerByCountries(selectedCountries).subscribe((response: Player[]) => {
                this.players = response;
                this.countryFlag = true;

                this.updateParam(selectedCountries);
            });
        } else {
            this.players = [];
            this.countryFlag = false;
            this.updateParam(null);
        }
    }

    private updateParam(countries: string | null): void {
        this.router.navigate(
          ['/player'],
          { queryParams: { countries: countries } }
        );
      }
}