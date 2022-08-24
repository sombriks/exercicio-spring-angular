import {ComponentFixture, TestBed} from '@angular/core/testing';

import {DocumentosComponent} from './documentos.component';
import {AppRoutingModule} from "../../app-routing.module";
import {ApiService} from "../../api/api.service";
import {AppModule} from "../../app.module";

describe('DocumentosComponent', () => {
  let component: DocumentosComponent;
  let fixture: ComponentFixture<DocumentosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        AppModule
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(DocumentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
