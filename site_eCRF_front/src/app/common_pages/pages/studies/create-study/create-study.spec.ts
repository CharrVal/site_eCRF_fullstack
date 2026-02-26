import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateStudy } from './create-study';

describe('CreateStudy', () => {
  let component: CreateStudy;
  let fixture: ComponentFixture<CreateStudy>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateStudy],
    }).compileComponents();

    fixture = TestBed.createComponent(CreateStudy);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
