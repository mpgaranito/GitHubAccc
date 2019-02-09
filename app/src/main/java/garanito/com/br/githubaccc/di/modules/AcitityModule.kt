package garanito.com.br.githubaccc.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import garanito.com.br.githubaccc.ui.main.MainActivity

@Module
abstract class AcitityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
