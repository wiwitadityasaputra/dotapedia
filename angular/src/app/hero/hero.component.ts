import { Component, OnInit } from '@angular/core';
import { HeroResponse } from './hero.response.model';
import { HeroService } from './hero.service';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {

  public heroes: HeroResponse[];
  public activeButton: string = "ALL";

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    this.updateHero(null);
  }

  public clickButton(heroType: string) {
    this.activeButton = heroType;
    this.updateHero(heroType === "ALL" ? null : heroType);
  }

  private updateHero(heroType: string | null) {
    this.heroService.getHeroes(heroType).subscribe((heroes: HeroResponse[]) => {
      this.heroes = heroes;
    });
  }
}
