import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { HeroResponse } from "./hero.response.model";

@Injectable()
export class HeroService {
    private API_PATH: string = "/api/heroes";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }
  
    public getHeroes(heroType: string): Observable<HeroResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH;
        if (heroType) {
            url += "?heroType=" + heroType;
        };
        return this.http.get<HeroResponse[]>(url);
    }
}