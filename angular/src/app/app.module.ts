import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TeamAllComponent } from './team/team-all/team-all.component';
import { TeamDeatilComponent } from './team/team-detail/team-detail.component';
import { TournamentAllComponent } from './tournament/tournament-all/tournament-all.component';
import { TournamentDetailComponent } from './tournament/tournament-detail/tournament-detail.component';
import { SeriesComponent } from './tournament/tournament-detail/series/series.component';
import { HeroComponent } from './hero/hero.component';
import { PlayerAllComponent } from './player/player-all/player-all.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { FooterComponent } from './utility/footer/footer.component';

import { RegionPipe } from './utility/region.pipe';
import { TournamentTypePipe } from './utility/tournament-type.pipe';

import { EnvirontmentService } from './utility/environtment.service';
import { HeroService } from './hero/hero.service';
import { TeamService } from './team/team.service';
import { TournamentService } from './tournament/tournament.service';
import { RegionService } from './utility/region.service';
import { SeriesService } from './tournament/tournament-detail/series/series.service';
import { ScheduleService } from './schedule/schedule.service';
import { PlayerService } from './player/player.service';

import { NgttDoubleEliminationTreeModule } from './utility/ngtt-double-elimination-tree/ngtt-double-elimination-tree.module';
import { NgttMatchModule } from './utility/ngtt-match/ngtt-match.module';
import { PlayerDetailComponent } from './player/player-detail/player-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeroComponent,
    TournamentAllComponent,
    TournamentDetailComponent,
    TeamAllComponent,
    TeamDeatilComponent,
    SeriesComponent,
    ScheduleComponent,
    PlayerAllComponent,
    PlayerDetailComponent,

    FooterComponent,

    RegionPipe,
    TournamentTypePipe,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,

    NgttDoubleEliminationTreeModule,
    NgttMatchModule,

    AppRoutingModule,
  ],
  providers: [
    EnvirontmentService,
    HeroService,
    TeamService,
    TournamentService,
    RegionService,
    SeriesService,
    ScheduleService,
    PlayerService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
