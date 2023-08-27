package com.example.iitmap.config

import com.example.iitmap.auth.JwtFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class AuthConfig(
    private val authFilter: JwtFilter,
    private val authProvider: AuthenticationProvider
) {
    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain? =
        httpSecurity
            .csrf {
                it.disable()
            }
            .authorizeHttpRequests {
                it.requestMatchers("/api/auth/**")
                    .permitAll()
                it.requestMatchers(HttpMethod.POST)
                    .authenticated()
                it.requestMatchers(HttpMethod.PUT)
                    .authenticated()
                it.requestMatchers(HttpMethod.DELETE)
                    .authenticated()
                it.anyRequest().permitAll()
            }
            .authenticationProvider(authProvider)
            .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
}