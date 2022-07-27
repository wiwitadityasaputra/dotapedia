import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { ScheduleResponse } from "./schedule.response.model";


@Injectable()
export class ScheduleService {
    private API_PATH: string = "/api/schedule";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getUpcomingMatch(): Observable<ScheduleResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/upcoming-match";
        return this.http.get<ScheduleResponse[]>(url);
    }

    public getLatestmatch(region: string, page: number): Observable<ScheduleResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/latest-match?region=" + region + "&page=" + page;
        return this.http.get<ScheduleResponse[]>(url);
    }
}