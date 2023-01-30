import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthConfig, OAuthService} from "angular-oauth2-oidc";
import {filter} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'hangouts-planner';
  userInfoDirectCall: any;
  userInfoApiGateway: any;

  authCodeFlowConfig: AuthConfig = {
    // Url of the Identity Provider
    issuer: 'http://localhost:9990/auth/realms/hangouts-planner',
    redirectUri: window.location.origin,
    clientId: 'hangouts-planner-frontend-client',
    responseType: 'code',
    scope: 'openid profile email offline_access',
    showDebugInformation: true,
  };

  constructor(private readonly http: HttpClient, private readonly oauthService: OAuthService) {
  }

  ngOnInit(): void {
    this.oauthService.configure(this.authCodeFlowConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();

    this.oauthService.events
      .pipe(filter((e) => e.type === 'token_received'))
      .subscribe((_) => this.oauthService.loadUserProfile());
  }


  fetchUserInfoViaDirectCall() {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${sessionStorage.getItem('access_token')}`)
    this.http.get('http://localhost:8083/api/v1/users/user-info', {headers})
      .subscribe(response => this.userInfoDirectCall = response, err => this.userInfoDirectCall = err);
  }

  fetchUserInfoViaApiGateway() {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${sessionStorage.getItem('access_token')}`)
    this.http.get('/api/hangouts-planner-app/users/user-info', {headers})
      .subscribe(response => this.userInfoApiGateway = response, err => this.userInfoApiGateway = err);
  }

  logInUsingKeycloak() {
    this.oauthService.initCodeFlow();
  }
}
