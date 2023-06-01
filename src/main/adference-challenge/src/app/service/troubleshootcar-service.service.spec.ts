import { TestBed } from '@angular/core/testing';

import { TroubleshootcarServiceService } from './troubleshootcar-service.service';

describe('TroubleshootcarServiceService', () => {
  let service: TroubleshootcarServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TroubleshootcarServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
