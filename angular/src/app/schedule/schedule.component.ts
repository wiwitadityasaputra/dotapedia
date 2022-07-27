import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { RegionService, RegionType } from '../utility/region.service';
import { ScheduleResponse } from './schedule.response.model';
import { ScheduleService } from './schedule.service';
import { ScheduleView } from './schedule.view.model';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  public nextMatchs: ScheduleView[];
  public prevMatchs: ScheduleView[];
  public prevPage = 0;
  public prevRegion: string = "All";
  public regions: RegionType[];

  constructor(private scheduleService: ScheduleService,
              private regionService: RegionService) { }

  ngOnInit(): void {
    this.scheduleService.getUpcomingMatch().subscribe((response: ScheduleResponse[]) => {
      this.nextMatchs = [];
      response.forEach((r) => {
        this.nextMatchs.push(this.scheduleResponseToView(r));
      });
    });

    this.updatePrevmatches();

    this.regions = this.regionService.getAllRegions();
  }

  prevMatchSelectRegion(region: Event): void {
    console.log("region change ", (region.target as HTMLInputElement).value);
    this.prevPage = 0;
    this.prevRegion = (region.target as HTMLInputElement).value;
    this.updatePrevmatches();
  }

  prevPrevMatches(): void {
    if (this.prevPage > 0) {
      this.prevPage--;
      this.updatePrevmatches();
    }
  }

  nextPrevMatches(): void {
    this.prevPage++;
    this.updatePrevmatches();
  }

  private updatePrevmatches(): void {

    this.scheduleService.getLatestmatch(this.prevRegion, this.prevPage).subscribe((response: ScheduleResponse[]) => {
      this.prevMatchs = [];
      response.forEach((r) => {
        this.prevMatchs.push(this.scheduleResponseToView(r));
      });
    });
  }

  private scheduleResponseToView(r: ScheduleResponse): ScheduleView {
    return {
      startDate: r.startDate,
      
      direTeamId: r.teamAId,
      direTeamName: r.teamAName,
      direScore: r.teamAScore,

      radiantTeamId: r.teamBId,
      radiantTeamName: r.teamBName,
      radiantScore: r.teamBScore,
      
      tournamentId: r.tournamentId,
      tournamentImage: r.tournamentImage,
      tournamentName: r.tournamentName,
      tournamentRegion: r.tournamentRegion,

      regionAbbr: this.regionService.getRegionAbbreviationByKey(r.tournamentRegion),
      startDateStr: moment(parseInt(r.startDate)).format('YYYY, MMMM DD, hh:mm'),
    }
  }
}
