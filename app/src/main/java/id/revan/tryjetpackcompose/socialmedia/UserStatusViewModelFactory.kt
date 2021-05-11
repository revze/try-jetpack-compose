package id.revan.tryjetpackcompose.socialmedia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.revan.tryjetpackcompose.repository.SocialMediaRepository

class UserStatusViewModelFactory(private val repository: SocialMediaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserStatusViewModel(repository) as T
    }
}