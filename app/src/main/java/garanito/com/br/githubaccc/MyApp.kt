package garanito.com.br.githubaccc

import android.app.Application
import android.app.Activity
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.HasActivityInjector
import garanito.com.br.githubaccc.di.components.DaggerAppComponent


class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    private fun initDagger() {
       DaggerAppComponent.builder().application(this).build().inject(this)
    }
}