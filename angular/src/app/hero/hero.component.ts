import { Component, OnInit } from '@angular/core';
import { MatButtonToggleChange } from '@angular/material/button-toggle';
import { HeroModel } from './hero.model';
import { HeroService } from './hero.service';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {

  public heroType: string = "";
  public heroes: HeroModel[];

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    this.updateHero();
  }

  public onValChange(event: MatButtonToggleChange) {
    this.heroType = event.value;
    this.updateHero();
  }

  private updateHero() {
    this.heroService.getHeroes(this.heroType).subscribe((heroes: HeroModel[]) => {
      this.heroes = heroes;
    });
  }
}
