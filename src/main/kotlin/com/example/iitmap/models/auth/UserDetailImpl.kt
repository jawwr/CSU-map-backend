package com.example.iitmap.models.auth

import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@NoArgsConstructor
class UserDetailImpl(
    private val id: Long,
    private val username: String,
    private val password: String,
    private val authorities: MutableCollection<out GrantedAuthority>
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities

    override fun getPassword(): String = password

    override fun getUsername(): String = username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    companion object {
        fun of(user: User): UserDetailImpl {
            val authorities: MutableList<out GrantedAuthority> = mutableListOf(SimpleGrantedAuthority(user.role.name))
            return UserDetailImpl(
                id = user.id,
                username = user.login,
                password = user.password,
                authorities = authorities
            )
        }
    }
}
