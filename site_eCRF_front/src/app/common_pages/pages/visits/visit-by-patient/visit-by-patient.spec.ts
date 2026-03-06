import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitByPatient } from './visit-by-patient';

describe('VisitByPatient', () => {
  let component: VisitByPatient;
  let fixture: ComponentFixture<VisitByPatient>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisitByPatient],
    }).compileComponents();

    fixture = TestBed.createComponent(VisitByPatient);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
