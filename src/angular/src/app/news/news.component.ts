import { Component, OnInit } from "@angular/core";
import { NewsApiArticle } from "./news.response.model";
import { NewsService } from "./news.service";

@Component({
    selector: 'app-news',
    templateUrl: './news.component.html',
    styleUrls: ['./news.component.css']
  })
  export class NewsComponent implements OnInit {

    public news: NewsApiArticle[];

    constructor(private newsService: NewsService) {
    }

    ngOnInit(): void {
      this.newsService.getNews().subscribe((response: NewsApiArticle[]) => {
        this.news = response;
      });
    }
  }