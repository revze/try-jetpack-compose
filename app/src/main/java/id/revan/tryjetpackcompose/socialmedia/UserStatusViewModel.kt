package id.revan.tryjetpackcompose.socialmedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.revan.tryjetpackcompose.core.Error
import id.revan.tryjetpackcompose.core.State
import id.revan.tryjetpackcompose.entity.UserStatus
import id.revan.tryjetpackcompose.repository.SocialMediaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserStatusViewModel(private val repository: SocialMediaRepository) : ViewModel() {
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private var _userStatus = MutableLiveData<List<UserStatus>>()
    val userStatus: LiveData<List<UserStatus>> = _userStatus

    private var _error = MutableLiveData<Error>()
    val error: LiveData<Error> = _error

    init {
        getUserStatus()
    }

    fun getUserStatus() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getUserStatus()
            if (result is State.Success) {
                _isLoading.postValue(false)
                _userStatus.postValue(result.data)
            } else if (result is State.Error) {
                _isLoading.postValue(false)
                _error.postValue(Error(result.errorCode, result.message))
            }
        }
    }
}