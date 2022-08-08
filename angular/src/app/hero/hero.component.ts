import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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

  constructor(private heroService: HeroService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const heroType = this.activatedRoute.snapshot.queryParamMap.get("type");
    if (heroType == 'AGILITY' || heroType == 'STRENGTH' || heroType == 'INTELLIGENCE') {
      this.updateHero(heroType);
      this.updateParam(heroType);
    } else {
      this.updateHero(null);
    }
  }

  public clickButton(heroType: string) {
    this.activeButton = heroType;
    this.updateHero(heroType === "ALL" ? null : heroType);
  }

  private updateHero(heroType: string | null) {
    this.heroService.getHeroes(heroType).subscribe((heroes: HeroResponse[]) => {
      this.heroes = heroes;
    });
    if (heroType != null) {
      this.updateParam(heroType);
    }
  }

  private updateParam(heroType: string): void {
    this.router.navigate(
      ['/hero'],
      { queryParams: { type: heroType } }
    );
  }
}
