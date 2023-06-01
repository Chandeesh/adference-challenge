import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TroubleshootCarComponent } from './troubleshoot-car/troubleshoot-car.component';

const routes: Routes = [
  { path: 'troubleshootcar', component: TroubleshootCarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

export const routingComponents = [TroubleshootCarComponent];
