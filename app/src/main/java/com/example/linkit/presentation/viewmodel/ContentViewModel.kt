package com.example.linkit.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.linkit._enums.UIMode
import com.example.linkit.domain.repository.LinkRepository
import com.example.linkit.domain.interfaces.ILink
import com.example.linkit.domain.model.Link
import com.example.linkit.domain.model.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val linkRepo: LinkRepository
): ViewModel() {
    private val _link = mutableStateOf(ILink.EMPTY)
    val link: State<ILink> = _link
    var uiMode = mutableStateOf(UIMode.NORMAL)

    /** DB에서 화면에 표시할 링크를 불러온다. */
    fun setLink(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _link.value = linkRepo.getLink(id)
        }
    }

    /** 현재 링크를 DB에 반영한다. */
    fun saveLink() {
        viewModelScope.launch(Dispatchers.IO) {
            linkRepo.updateLink(_link.value)
        }
    }

    override fun onCleared() {
        "ContentViewModel 제거!".log()
        super.onCleared()
    }
}