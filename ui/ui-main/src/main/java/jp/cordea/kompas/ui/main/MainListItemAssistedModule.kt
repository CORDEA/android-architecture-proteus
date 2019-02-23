package jp.cordea.kompas.ui.main

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_MainListItemAssistedModule::class])
interface MainListItemAssistedModule
