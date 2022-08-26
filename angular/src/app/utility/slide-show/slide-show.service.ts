import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from 'rxjs';
import { SlideShowView } from "./slide-show.view.model";

@Injectable()
export class SlideShowService {
    private item = new BehaviorSubject<SlideShowView>({ imageSrcs: null, selected: null });
    private selectedItem: Observable<SlideShowView> = this.item.asObservable();

    constructor() {}

    public getObservable(): Observable<SlideShowView> {
        return this.selectedItem;
    }

    public show(data: SlideShowView): void {
        this.item.next(data);
    }
}