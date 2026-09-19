import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Rectangulo } from './rectangulo';

describe('Rectangulo', () => {
  let component: Rectangulo;
  let fixture: ComponentFixture<Rectangulo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Rectangulo],
    }).compileComponents();

    fixture = TestBed.createComponent(Rectangulo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
