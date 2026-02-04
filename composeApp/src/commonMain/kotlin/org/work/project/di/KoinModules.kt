package org.work.project.di

import org.koin.dsl.module
import org.work.project.api.AuthApi
import org.work.project.presentation.viewmodel.AuthViewModel
import org.work.project.presentation.viewmodel.CourseViewModel
import org.work.project.utils.AuthTokenStorage

val sharedModule = module {
    single { AuthApi(get()) }
    single{ AuthTokenStorage() }
    single{ AuthViewModel(get(), get()) }
    single{ CourseViewModel() }
}