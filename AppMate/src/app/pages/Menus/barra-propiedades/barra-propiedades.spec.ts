import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraPropiedades } from './barra-propiedades';

describe('BarraPropiedades', () => {
  let component: BarraPropiedades;
  let fixture: ComponentFixture<BarraPropiedades>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BarraPropiedades],
    }).compileComponents();

    fixture = TestBed.createComponent(BarraPropiedades);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
