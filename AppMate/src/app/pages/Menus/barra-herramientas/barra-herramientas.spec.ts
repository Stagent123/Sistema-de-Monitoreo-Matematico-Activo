import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraHerramientas } from './barra-herramientas';

describe('BarraHerramientas', () => {
  let component: BarraHerramientas;
  let fixture: ComponentFixture<BarraHerramientas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BarraHerramientas],
    }).compileComponents();

    fixture = TestBed.createComponent(BarraHerramientas);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
