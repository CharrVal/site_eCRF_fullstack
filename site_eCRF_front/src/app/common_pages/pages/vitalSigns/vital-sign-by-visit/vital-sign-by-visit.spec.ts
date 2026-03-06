import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VitalSignByVisit } from './vital-sign-by-visit';

describe('VitalSignByVisit', () => {
  let component: VitalSignByVisit;
  let fixture: ComponentFixture<VitalSignByVisit>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VitalSignByVisit],
    }).compileComponents();

    fixture = TestBed.createComponent(VitalSignByVisit);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
