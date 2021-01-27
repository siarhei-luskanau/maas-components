@file:Suppress("unused", "EXTENSION_SHADOWED_BY_MEMBER")

package com.trafi.users

import com.trafi.core.ApiResult
import com.trafi.core.CFlow
import com.trafi.core.model.Profile
import com.trafi.core.model.User
import com.trafi.core.wrap
import kotlinx.coroutines.flow.flow

fun UsersApi.createOrGetUser(profile: Profile? = null): CFlow<ApiResult<User>> = flow {
    emit(createOrGetUser(profile))
}.wrap()

fun UsersApi.updateProfile(profile: Profile? = null): CFlow<ApiResult<User>> = flow {
    emit(updateProfile(profile))
}.wrap()
