import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentoDialogComponent } from './documento-dialog.component';

describe('DocumentoDialogComponent', () => {
  let component: DocumentoDialogComponent;
  let fixture: ComponentFixture<DocumentoDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentoDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocumentoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
