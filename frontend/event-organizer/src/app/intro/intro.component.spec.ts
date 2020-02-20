import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { IntroComponent } from './intro.component';

describe('IntroComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        IntroComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(IntroComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'event-organizer'`, () => {
    const fixture = TestBed.createComponent(IntroComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('event-organizer');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(IntroComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('.content span').textContent).toContain('event-organizer app is running!');
  });
});
