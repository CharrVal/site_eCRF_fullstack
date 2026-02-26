import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVitalSign } from './create-vital-sign';

describe('CreateVitalSign', () => {
  let component: CreateVitalSign;
  let fixture: ComponentFixture<CreateVitalSign>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateVitalSign],
    }).compileComponents();

    fixture = TestBed.createComponent(CreateVitalSign);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
