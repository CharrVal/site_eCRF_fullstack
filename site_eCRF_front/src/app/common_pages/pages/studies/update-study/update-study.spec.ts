import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStudy } from './update-study';

describe('UpdateStudy', () => {
  let component: UpdateStudy;
  let fixture: ComponentFixture<UpdateStudy>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateStudy],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateStudy);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
