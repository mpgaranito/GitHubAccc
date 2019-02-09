package garanito.com.br.githubaccc.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import garanito.com.br.githubaccc.ui.userprofile.UserProfileFragment

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeUserProfileFragment(): UserProfileFragment
}