import { Component, OnInit } from "@angular/core";
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

    constructor(private playerService: PlayerService) {
    }

    ngOnInit(): void {
        this.playerService.getPlayerCountries().subscribe((response: PlayerCountry[]) => {
            response.forEach( pc => {
                this.playerCountries.push({
                    country: pc.country,
                    totalPlayer: pc.totalPlayer,
                    selected: false
                })
            })
        });
    }

    public selecCountry(pc: PlayerCountryView): void {
        pc.selected = !pc.selected;

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
            });
        } else {
            this.players = [];
            this.countryFlag = false;   
        }
    }
}