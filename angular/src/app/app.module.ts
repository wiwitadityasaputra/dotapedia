import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTabsModule } from '@angular/material/tabs';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatDialogModule } from '@angular/material/dialog';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTableModule } from '@angular/material/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroComponent } from './hero/hero.component';
import { LandingComponent } from './landing/landing.component';
import { TournamentComponent } from './tournament/tournament.component';
import { TournamentDetailComponent } from './tournament/tournament-detail/tournament-detail.component';
import { SeriesComponent } from './tournament/tournament-detail/series/series.component';
import { TeamComponent } from './team/team.component';
import { ScheduleComponent } from './schedule/schedule.component';

import { HeroService } from './hero/hero.service';
import { EnvirontmentService } from './utility/environtment.service';
import { TeamService } from './team/team.service';
import { TournamentService } from './tournament/tournament.service';
import { RegionPipe } from './utility/region.pipe';
import { TournamentTypePipe } from './utility/tournament-type.pipe';
import { RegionService } from './utility/region.service';
import { SeriesService } from './tournament/tournament-detail/series/series.service';

import { NgttDoubleEliminationTreeModule } from './utility/ngtt-double-elimination-tree/ngtt-double-elimination-tree.module';
import { NgttMatchModule } from './utility/ngtt-match/ngtt-match.module';
import { ScheduleService } from './schedule/schedule.service';

@NgModule({
  declarations: [
    AppComponent,
    HeroComponent,
    LandingComponent,
    TournamentComponent,
    TournamentDetailComponent,
    TeamComponent,
    SeriesComponent,
    ScheduleComponent,

    RegionPipe,
    TournamentTypePipe,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,

    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatGridListModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatListModule,
    MatExpansionModule,
    MatTabsModule,
    FlexLayoutModule,
    MatDialogModule,
    MatProgressSpinnerModule,
    MatTableModule,

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
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
