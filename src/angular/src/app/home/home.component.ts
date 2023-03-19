import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { ScheduleResponse } from '../schedule/schedule.response.model';
import { ScheduleView } from '../schedule/schedule.view.model';
import { RegionService } from '../utility/region.service';
import { HomeResponse } from './home.response.model';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public data: HomeResponse;
  public nextMatchs: ScheduleView[];

  constructor(private homeService: HomeService,
    private regionService: RegionService) { }

  ngOnInit(): void {
    this.homeService.getHome().subscribe( response => {
      this.data = response;

      this.nextMatchs = [];
      this.data.upcomingMatch.forEach((match) => {
        this.nextMatchs.push(this.scheduleResponseToView(match));
      })
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
