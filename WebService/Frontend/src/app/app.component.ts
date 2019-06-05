import{Component}from'@angular/core';
import {Router} from "@angular/router";
import {PageContextService} from "./services/page-context.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';
  context;

  constructor(private router: Router, context : PageContextService){
    this.context = context;
  }
}
