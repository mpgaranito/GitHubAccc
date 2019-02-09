package garanito.com.br.githubaccc.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import garanito.com.br.githubaccc.di.key.ViewModelKey
import garanito.com.br.githubaccc.ui.userprofile.UserProfileViewModel
import garanito.com.br.githubaccc.util.viewmodel.FactoryViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserProfileViewModel(repoViewModel: UserProfileViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory
}
