import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgttDoubleEliminationTreeComponent } from './ngtt-double-elimination-tree.component';

const components = [NgttDoubleEliminationTreeComponent];

@NgModule({
  declarations: components,
  imports: [
    CommonModule
  ],
  exports: components
})
export class NgttDoubleEliminationTreeModule {
}
