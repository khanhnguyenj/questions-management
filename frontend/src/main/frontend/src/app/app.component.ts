import {Component, AfterViewInit} from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    
    private isChartsCollapsed = true;
    private isUICollapsed = true;
    private isMultiLevelCollapsed = true;
    private isSampleCollapsed = true;
    private isThirdLevelCollapsed = true;

    private title= 'Questions Management';

}
