import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { TeamDetailResponse, TeamPlayerResponse, TeamResponse } from "./team.response.model";

@Injectable()
export class TeamService {
    private API_PATH: string = "/api/teams";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getTeam(teamId: string): Observable<TeamDetailResponse> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + teamId;
        return this.http.get<TeamDetailResponse>(url);        
    }

    public getTeams(region: string): Observable<TeamResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "?&region=" + region;
        return this.http.get<TeamResponse[]>(url);
    }

    public getPlayers(teamId: number): Observable<TeamPlayerResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + teamId + "/players";
        return this.http.get<TeamPlayerResponse[]>(url);
    }

    public getTopTreeTeam(): Observable<TeamResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "?&topTree=true";
        return this.http.get<TeamResponse[]>(url);
    }
}