import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSite } from './update-site';

describe('UpdateSite', () => {
  let component: UpdateSite;
  let fixture: ComponentFixture<UpdateSite>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateSite],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateSite);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
