package id.revan.tryjetpackcompose.repository

import android.app.Application
import id.revan.tryjetpackcompose.R
import id.revan.tryjetpackcompose.core.State
import id.revan.tryjetpackcompose.entity.UserStatus
import kotlinx.coroutines.delay

class SocialMediaRepositoryImpl(private val application: Application) : SocialMediaRepository {
    override suspend fun getUserStatus(): State<List<UserStatus>> {
        delay(1500)
        val userStatus = mutableListOf<UserStatus>()
        (0..10).forEach {
            when {
                it % 3 == 0 -> {
                    userStatus.add(
                        UserStatus(
                            user = "Revando",
                            photoUrl = "https://picsum.photos/id/239/400/350",
                            date = "10 Mei 2021",
                            status = application.getString(R.string.dummy_text1)
                        )
                    )
                }
                it % 2 == 0 -> {
                    userStatus.add(
                        UserStatus(
                            user = "Kevin",
                            photoUrl = "https://picsum.photos/id/240/400/350",
                            date = "05 Apr 2021",
                            status = application.getString(R.string.dummy_text2)
                        )
                    )
                }
                else -> {
                    userStatus.add(
                        UserStatus(
                            user = "Sasuke",
                            photoUrl = "https://picsum.photos/id/242/400/350",
                            date = "30 Jan 2021",
                            status = application.getString(R.string.dummy_text3)
                        )
                    )
                }
            }
        }
//        For make content error, use: return State.Error(State.Error.NETWORK, application.getString(R.string.network_error))
        return State.Success(userStatus)
    }
}