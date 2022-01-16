import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HeroModel } from "./hero.model";

@Injectable()
export class HeroService {
    getProtocol(): string {
        return "http";
    }
    getHost(): string {
        return "localhost";
    }
    getPort(): string {
        return "8430";
    }
    getFullUrl(path: string): string {
        return this.getProtocol() + "://" + this.getHost() + ":" + this.getPort() + path;
    }

    constructor(private http: HttpClient) {
    }
  
    public getHeroes(heroType: string): Observable<HeroModel[]> {
        var url = this.getFullUrl("/api/heroes");
        if (heroType) {
            url += "?heroType=" + heroType;
        };
        return this.http.get<HeroModel[]>(url);
    }
}