import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroMateria } from './registro-materia';

describe('Registro', () => {
  let component: RegistroMateria;
  let fixture: ComponentFixture<RegistroMateria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistroMateria],
    }).compileComponents();

    fixture = TestBed.createComponent(RegistroMateria);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
