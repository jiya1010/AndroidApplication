package com.example.androidapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapplication.domain.GetUserUseCase
import com.example.androidapplication.domain.User
import com.example.androidapplication.domain.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _user = MutableLiveData<UserResponse>()
    val user: LiveData<UserResponse> get() = _user

    fun loginUser(userRequest:User) {
        viewModelScope.launch {
            val result = getUserUseCase(userRequest)
            _user.value = result
        }
    }
}
