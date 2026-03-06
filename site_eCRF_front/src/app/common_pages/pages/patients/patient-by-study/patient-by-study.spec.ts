import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientByStudy } from './patient-by-study';

describe('PatientByStudy', () => {
  let component: PatientByStudy;
  let fixture: ComponentFixture<PatientByStudy>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientByStudy],
    }).compileComponents();

    fixture = TestBed.createComponent(PatientByStudy);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
