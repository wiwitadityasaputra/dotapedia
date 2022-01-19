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

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroComponent } from './hero/hero.component';
import { LandingComponent } from './landing/landing.component';
import { TournamentComponent } from './tournament/tournament.component';
import { TeamComponent } from './team/team.component';
import { ScheduleComponent } from './schedule/schedule.component';

import { HeroService } from './hero/hero.service';
import { EnvirontmentService } from './utility/environtment.service';
import { TeamService } from './team/team.service';
import { TournamentService } from './tournament/tournament.service';
import { RegionPipe } from './utility/region.pipe';
import { TournamentTypePipe } from './utility/tournament-type.pipe';
import { RegionService } from './utility/region.service';

@NgModule({
  declarations: [
    AppComponent,
    HeroComponent,
    LandingComponent,
    TournamentComponent,
    TeamComponent,
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

    AppRoutingModule,
  ],
  providers: [
    EnvirontmentService,
    HeroService,
    TeamService,
    TournamentService,
    RegionService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
