import { TestBed } from '@angular/core/testing';

import { UserLoggedService } from '../../services/auth/user-logged-service';

describe('UserLoggedService', () => {
  let service: UserLoggedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserLoggedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});