import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DocumentosComponent} from "./views/documentos/documentos.component";

const routes: Routes = [
  {
    path: "setores/:setorId/pastas/:pastaId/documentos",
    component: DocumentosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
