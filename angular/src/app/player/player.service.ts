import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { Player, PlayerCountry } from "./player.response.model";

@Injectable()
export class PlayerService {
    private API_PATH: string = "/api/players";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getPlayerCountries(): Observable<PlayerCountry[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/countries";
        return this.http.get<PlayerCountry[]>(url);
    }

    public getPlayerByCountries(countries: string): Observable<Player[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "?countries=" + countries;
        return this.http.get<Player[]>(url);
    }

    public getPlayerById(playerId: number): Observable<Player> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + playerId;
        return this.http.get<Player>(url);
    }
}