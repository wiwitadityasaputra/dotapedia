import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { RegionService } from '../utility/region.service';
import { ScheduleResponse } from './schedule.response.model';
import { ScheduleService } from './schedule.service';
import { ScheduleView } from './schedule.view.model';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  public schedules: ScheduleView[];

  constructor(private scheduleService: ScheduleService,
              private regionService: RegionService) { }

  ngOnInit(): void {
    this.scheduleService.getSchedule().subscribe((response: ScheduleResponse[]) => {
      this.schedules = [];
      response.forEach((r) => {
        this.schedules.push({
          direTeamId: r.direTeamId,
          direTeamName: r.direTeamName,
          radiantTeamId: r.radiantTeamId,
          radiantTeamName: r.radiantTeamName,
          startDate: r.startDate,
          tournamentId: r.tournamentId,
          tournamentImage: r.tournamentImage,
          tournamentName: r.tournamentName,
          tournamentRegion: r.tournamentRegion,

          regionAbbr: this.regionService.getRegionAbbreviationByKey(r.tournamentRegion),
          startDateStr: moment(r.startDate).format('YYYY, MMMM DD'),
        });        
      });
    });
  }
}
