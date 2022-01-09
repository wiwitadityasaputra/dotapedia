import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { TournamentComponent } from './tournament/tournament.component';
import { TeamComponent } from './team/team.component';
import { HeroComponent } from './hero/hero.component';
import { ScheduleComponent } from './schedule/schedule.component';

const routes: Routes = [
  { path: 'home', component: LandingComponent, data: { name: 'home' } },
  { path: 'tournament', component: TournamentComponent, data: { name: 'tournament' } },
  { path: 'team', component: TeamComponent, data: { name: 'team' } },
  { path: 'hero', component: HeroComponent, data: { name: 'hero' } },
  { path: 'schedule', component: ScheduleComponent, data: { name: 'schedule' } },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
