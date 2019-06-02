import{Component}from'@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';
  page = 1;

    changeTitle1() {
      this.page = 1;
    }

    changeTitle2() {
      this.page = 2;
    }
}
