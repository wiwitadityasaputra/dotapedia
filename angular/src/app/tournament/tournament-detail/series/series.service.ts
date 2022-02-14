import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "src/app/utility/environtment.service";
import { SeriesResponse } from "./series.response.model";

@Injectable()
export class SeriesService {
    private API_PATH: string = "/api/series";
    private serieses: SeriesResponse[];

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
        this.serieses = [];
    }

    public getSeries(seriesId: number): Observable<SeriesResponse> { 
        const series = this.serieses.find(series => {
            return series.seriesId === seriesId;
        });
        if (series) {
            return new Observable<SeriesResponse>((observer) => {
                observer.next(series);
                observer.complete();
            });
        }

        return new Observable<SeriesResponse>((observer) => {

            var url = this.environtment.getServerUrl() + this.API_PATH + "/" + seriesId;
            this.http.get<SeriesResponse>(url)
                .subscribe((response: SeriesResponse) => {
                    this.serieses.push(response);

                    observer.next(response);
                    observer.complete();
                });
        });
    }
}