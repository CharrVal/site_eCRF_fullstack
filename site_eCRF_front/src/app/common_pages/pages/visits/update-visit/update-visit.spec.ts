import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVisit } from './update-visit';

describe('UpdateVisit', () => {
  let component: UpdateVisit;
  let fixture: ComponentFixture<UpdateVisit>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateVisit],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateVisit);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
