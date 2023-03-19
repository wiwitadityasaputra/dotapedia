import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { NewsApiArticle } from "./news.response.model";

@Injectable()
export class NewsService {
    private API_PATH: string = "/api/news";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getNews(): Observable<NewsApiArticle[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH;
        return this.http.get<NewsApiArticle[]>(url);
    }
}