import { Component, OnInit } from '@angular/core';
import { SlideShowService } from './slide-show.service';
import { SlideShowView } from './slide-show.view.model';

@Component({
  selector: 'app-slide-show',
  templateUrl: './slide-show.component.html',
  styleUrls: ['./slide-show.component.css']
})
export class SlideShowComponent implements OnInit {

  public imageSrc: string;
  public isShow: boolean = false;
  private imageSrcs: string[];
  private selected: number;

  constructor(private slideShowService: SlideShowService) { }

  ngOnInit(): void {
    this.slideShowService.getObservable().subscribe((value: SlideShowView) => {
      if (value.imageSrcs) {
        this.imageSrcs = value.imageSrcs;
        if (value != null) {
          this.selected = value.selected as number;
        }
        

        this.imageSrc = this.imageSrcs[this.selected];
        this.isShow = true;
      }
    });
  }

  public close(): void {
    this.isShow = false;
  }

  public next(): void {
    this.selected++;
    if (this.selected >= this.imageSrcs.length) {
      this.selected = 0;
    }
    this.imageSrc = this.imageSrcs[this.selected];
  }

  public left(): void {
    this.selected--;
    if (this.selected < 0) {
      this.selected = this.imageSrcs.length - 1;
    }
    this.imageSrc = this.imageSrcs[this.selected];
  }

}
