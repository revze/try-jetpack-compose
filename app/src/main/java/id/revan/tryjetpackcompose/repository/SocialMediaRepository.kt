package id.revan.tryjetpackcompose.repository

import id.revan.tryjetpackcompose.entity.UserStatus
import id.revan.tryjetpackcompose.core.State

interface SocialMediaRepository {
    suspend fun getUserStatus(): State<List<UserStatus>>
}