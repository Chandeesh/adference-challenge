import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TroubleshootCarComponent } from './troubleshoot-car.component';

describe('TroubleshootCarComponent', () => {
  let component: TroubleshootCarComponent;
  let fixture: ComponentFixture<TroubleshootCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TroubleshootCarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TroubleshootCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
