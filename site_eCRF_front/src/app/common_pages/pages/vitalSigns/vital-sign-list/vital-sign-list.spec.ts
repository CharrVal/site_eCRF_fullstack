import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VitalSignList } from './vital-sign-list';

describe('VitalSignList', () => {
  let component: VitalSignList;
  let fixture: ComponentFixture<VitalSignList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VitalSignList],
    }).compileComponents();

    fixture = TestBed.createComponent(VitalSignList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
