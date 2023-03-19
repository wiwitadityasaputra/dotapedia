import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { HomeResponse } from "./home.response.model";

@Injectable()
export class HomeService {
    private API_PATH: string = "/api/home";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getHome(): Observable<HomeResponse> {
        var url = this.environtment.getServerUrl() + this.API_PATH;
        return this.http.get<HomeResponse>(url);
    }
}