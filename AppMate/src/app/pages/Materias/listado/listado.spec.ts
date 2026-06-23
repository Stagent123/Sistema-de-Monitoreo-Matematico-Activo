import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoMateria } from './listado-materia';

describe('Listado', () => {
  let component: ListadoMateria;
  let fixture: ComponentFixture<ListadoMateria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListadoMateria],
    }).compileComponents();

    fixture = TestBed.createComponent(ListadoMateria);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
