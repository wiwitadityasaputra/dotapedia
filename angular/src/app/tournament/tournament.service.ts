import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EnvirontmentService } from "../utility/environtment.service";
import { PlayerParticipantResponse } from "./tournament-detail/tournament-detail.view.model";
import { TournamentModel, TournamentDetailResponse, RoundRoibinSeriesResponse, BracketSeriesResponse } from "./tournament.response.model";

@Injectable()
export class TournamentService {
    private API_PATH: string = "/api/tournaments";

    constructor(private http: HttpClient, private environtment: EnvirontmentService) {
    }

    public getTournaments(regions: string): Observable<TournamentModel[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "?regions=" + regions;
        return this.http.get<TournamentModel[]>(url);
    }

    public getTournamentDetail(tournamentId: number): Observable<TournamentDetailResponse> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + tournamentId;
        return this.http.get<TournamentDetailResponse>(url);
    }

    public getPlayerParticipant(tournamentId: number): Observable<PlayerParticipantResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + tournamentId + "/players";
        return this.http.get<PlayerParticipantResponse[]>(url);
    }

    public getRoundRobinSeries(tournamentId: number): Observable<RoundRoibinSeriesResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + tournamentId + "/round-robin-series";
        return this.http.get<RoundRoibinSeriesResponse[]>(url);
    }

    public getBracketSeries(tournamentId: number): Observable<BracketSeriesResponse[]> {
        var url = this.environtment.getServerUrl() + this.API_PATH + "/" + tournamentId + "/bracket-series";
        return this.http.get<BracketSeriesResponse[]>(url);
    }
}