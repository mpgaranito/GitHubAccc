package garanito.com.br.githubaccc.ui.userprofile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import garanito.com.br.githubaccc.data.local.entity.User
import garanito.com.br.githubaccc.data.repositories.UserRepository
import javax.inject.Inject

//var no construtor, para nao precisar criar uma propriedade variavel
class UserProfileViewModel @Inject constructor(var userRepository:UserRepository):ViewModel(){
   var  user:LiveData<User> = MutableLiveData<User>()
    fun getUser(login: String)  {
      user   = userRepository.getUser(login)
    }

}