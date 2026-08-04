import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizarraAlumno } from './pizarra-alumno';

describe('PizarraAlumno', () => {
  let component: PizarraAlumno;
  let fixture: ComponentFixture<PizarraAlumno>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PizarraAlumno],
    }).compileComponents();

    fixture = TestBed.createComponent(PizarraAlumno);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
