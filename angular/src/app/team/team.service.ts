import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { TeamModel } from "./model/team.model";

@Injectable()
export class TeamService {
    private API_PATH: string = "/api/teams";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getTeams(): Observable<TeamModel[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH;
        return this.http.get<TeamModel[]>(url);
    }
}