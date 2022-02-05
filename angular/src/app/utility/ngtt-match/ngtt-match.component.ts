import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'ngtt-match',
  templateUrl: './ngtt-match.component.html',
  styleUrls: ['./ngtt-match.component.scss']
})
export class NgttMatchComponent implements OnInit {

  @Input() match: any;

  constructor() {
  }

  ngOnInit() {
  }

}
