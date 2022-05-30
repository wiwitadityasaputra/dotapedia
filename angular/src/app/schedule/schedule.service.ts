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

    public getSchedule() : Observable<ScheduleResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH;
        return this.http.get<ScheduleResponse[]>(url);
    }
}