import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVitalSign } from './update-vital-sign';

describe('UpdateVitalSign', () => {
  let component: UpdateVitalSign;
  let fixture: ComponentFixture<UpdateVitalSign>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateVitalSign],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateVitalSign);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
