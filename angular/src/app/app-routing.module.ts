import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TournamentComponent } from './tournament/tournament.component';
import { TournamentDetailComponent } from './tournament/tournament-detail/tournament-detail.component';
import { TeamComponent } from './team/team.component';
import { HeroComponent } from './hero/hero.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { HomeComponent } from './home/home.component';
import { TeamDeatilComponent } from './team/team-detail/team-detail.component';

const routes: Routes = [
  { path: '', component: HomeComponent, data: { name: 'home' } },
  { path: 'home', component: HomeComponent, data: { name: 'home' } },
  { path: 'tournament', component: TournamentComponent, data: { name: 'tournament' } },
  { path: 'tournament/:tournamentId', component: TournamentDetailComponent, data: { name: 'tournament' } },
  { path: 'team', component: TeamComponent, data: { name: 'team' } },
  { path: 'team/:teamId', component: TeamDeatilComponent, data: { name: 'team' } },
  { path: 'hero', component: HeroComponent, data: { name: 'hero' } },
  { path: 'schedule', component: ScheduleComponent, data: { name: 'schedule' } },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
