import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TournamentAllComponent } from './tournament/tournament-all/tournament-all.component';
import { TournamentDetailComponent } from './tournament/tournament-detail/tournament-detail.component';
import { HeroComponent } from './hero/hero.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { HomeComponent } from './home/home.component';
import { TeamDeatilComponent } from './team/team-detail/team-detail.component';
import { TeamAllComponent } from './team/team-all/team-all.component';
import { PlayerAllComponent } from './player/player-all/player-all.component';
import { PlayerDetailComponent } from './player/player-detail/player-detail.component';
import { NewsComponent } from './news/news.component';

const routes: Routes = [
  { path: '', component: HomeComponent, data: { name: 'home' } },
  { path: 'home', component: HomeComponent, data: { name: 'home' } },
  { path: 'player', component: PlayerAllComponent, data: { name: 'player-all' } },
  { path: 'player/:playerId', component: PlayerDetailComponent, data: { name: 'player-detail' } },
  { path: 'tournament', component: TournamentAllComponent, data: { name: 'tournament-all' } },
  { path: 'tournament/:tournamentId', component: TournamentDetailComponent, data: { name: 'tournament-detail' } },
  { path: 'team', component: TeamAllComponent, data: { name: 'team-all' } },
  { path: 'team/:teamId', component: TeamDeatilComponent, data: { name: 'team-detail' } },
  { path: 'hero', component: HeroComponent, data: { name: 'hero' } },
  { path: 'schedule', component: ScheduleComponent, data: { name: 'schedule' } },
  { path: 'news', component: NewsComponent, data: { name: 'news' } },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
