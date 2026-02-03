package org.work.project.di

import org.koin.dsl.module
import org.work.project.model.api.AuthApi
import org.work.project.presentation.viewmodel.AuthViewModel
import org.work.project.presentation.viewmodel.CourseViewModel
import org.work.project.utils.AuthTokenStorage

val sharedModule = module {
    single { AuthApi }
    single{ AuthTokenStorage() }
    single{ AuthViewModel(get(), get()) }
    single{ CourseViewModel() }
}