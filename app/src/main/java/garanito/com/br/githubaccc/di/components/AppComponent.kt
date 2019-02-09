package garanito.com.br.githubaccc.di.components

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import garanito.com.br.githubaccc.MyApp
import garanito.com.br.githubaccc.MyApp_MembersInjector
import garanito.com.br.githubaccc.di.modules.AcitityModule
import garanito.com.br.githubaccc.di.modules.AppModule
import garanito.com.br.githubaccc.di.modules.AppModule_ProvideDataBaseFactory
import garanito.com.br.githubaccc.di.modules.FragmentModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AcitityModule::class,
            FragmentModule::class,
            AppModule::class
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
    fun  inject(app: MyApp)
}