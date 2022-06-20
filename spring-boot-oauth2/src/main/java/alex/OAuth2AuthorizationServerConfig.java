package alex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/** Created by qct on 2017/9/19. */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  private final AuthenticationManager authenticationManager;

  //    private final RedisConnectionFactory redisConnectionFactory;

  @Autowired
  //    public OAuth2AuthorizationServerConfig(RedisConnectionFactory redisConnectionFactory,
  public OAuth2AuthorizationServerConfig(
      @Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager) {
    //        this.redisConnectionFactory = redisConnectionFactory;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()")
        .allowFormAuthenticationForClients();
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
    clients
        .inMemory()
        .withClient("client_id")
        .secret("client_secret")
        .authorizedGrantTypes("password", "client_credentials", "refresh_token")
        .scopes("read")
        .autoApprove("read");
  }

  /* @Override
      public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
  //        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
          endpoints.tokenStore(new InMemoryTokenStore())
              .authenticationManager(authenticationManager);
      }*/

  // JWT token
  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    //        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
    endpoints
        .tokenStore(new InMemoryTokenStore())
        .accessTokenConverter(accessTokenConverter())
        .authenticationManager(authenticationManager);
  }

  @Bean
  public AccessTokenConverter accessTokenConverter() {
    return new JwtAccessTokenConverter();
  }
}
