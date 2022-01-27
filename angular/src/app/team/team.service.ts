import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { RegionType } from "../utility/region.service";
import { TeamResponse } from "./team.response.model";

@Injectable()
export class TeamService {
    private API_PATH: string = "/api/teams";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getTeams(region: RegionType): Observable<TeamResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "?&region=" + region;
        return this.http.get<TeamResponse[]>(url);
    }
}