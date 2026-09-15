import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorEcuaciones } from './editor-ecuaciones';

describe('EditorEcuaciones', () => {
  let component: EditorEcuaciones;
  let fixture: ComponentFixture<EditorEcuaciones>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditorEcuaciones],
    }).compileComponents();

    fixture = TestBed.createComponent(EditorEcuaciones);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
